package ftnbusiness.business.faktura;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;

import ftnbusiness.business.poslovnaGodina.PoslovnaGodinaService;
import ftnbusiness.business.poslovniPartner.PoslovniPartnerService;
import ftnbusiness.business.preduzece.Preduzece;
import ftnbusiness.business.proizvod.ProizvodService;
import ftnbusiness.business.stavkaFakture.StavkaFakture;
import ftnbusiness.business.stavkaFakture.StavkaFaktureService;

public class FakturaFactory {

	
	@Autowired
	PoslovniPartnerService poslovniPartnerService;
	@Autowired
	PoslovnaGodinaService poslovnaGodinaService;
	
	@Autowired
	ProizvodService	proizvodService;
	
	@Autowired
	private FakturaService fakturaService;
	@Autowired
	private StavkaFaktureService stavkaFaktureService;
	
	private Preduzece preduzece;

	private static int brojFakture =0;
	
	public FakturaFactory(Preduzece preduzece) {
		super();
		this.preduzece = preduzece;
	}
	
	
	public Long fakturisi(NarudzbenicaDTO narudzbenica)	
	{
		Faktura faktura = new Faktura();

		final Calendar cal = Calendar.getInstance();

		faktura.setDatumFakture(cal.getTime().getTime());
		Date date = new Date();
		cal.setTime(date);   // assigns calendar to given date 
		int sat =cal.get(Calendar.HOUR_OF_DAY); // gets hour in 24h format
		if( sat<8)
		{
			cal.add(Calendar.DATE, -1);
			faktura.setDatumValute(cal.getTime().getTime()); 
		}else
		{
			faktura.setDatumValute(faktura.getDatumFakture());
		}
		faktura.setPreduzece(preduzece);
		faktura.setPoslovniPartner(poslovniPartnerService.getById(narudzbenica.getIdPoslovnogPartnera()));
		faktura.setBrojFakture(napraviIme(faktura));
		faktura.setPoslovnaGodina(poslovnaGodinaService.getNezakljucenaZaPreduzece(preduzece));
		    
		ArrayList<StavkaFakture> stavke = new ArrayList<StavkaFakture>();
		double rabat = sracunajRabat(narudzbenica);
		for (StavkaFaktureDTO stavkaFakture : narudzbenica.getStavke()) 
		{
			stavke.add(napraviStavku(stavkaFakture, rabat));
		}
		double ukupnoRabat =0;
		double ukupnoBezPDV=0;
		double ukupanPDV=0;
		double ukupno = 0;
		for (StavkaFakture stavkaFakture : stavke) 
		{
			ukupnoRabat+=stavkaFakture.getRabat();
			ukupnoBezPDV+=(stavkaFakture.getOsnovica()-stavkaFakture.getRabat());
			ukupanPDV+=stavkaFakture.getIznosPDV();
			ukupno +=stavkaFakture.getUkupanIznos();
		}
		faktura.setUkupanRabat(ukupnoRabat);
		faktura.setUkupanIznosBezPDV(ukupnoBezPDV);
		faktura.setUkupanPDV(ukupanPDV);
		faktura.setUkupnoZaPlacanje(ukupno);
		
		
		for (StavkaFakture stavkaFakture : stavke) 
		{
			stavkaFakture.setFaktura(faktura);
			stavkaFaktureService.addStavkaFakture(stavkaFakture);
		}
		
		long retVal =fakturaService.addFaktura(faktura);

		return retVal;
	}
	private StavkaFakture napraviStavku(StavkaFaktureDTO stavkaFakture, double rabat) {
		// TODO Auto-generated method stub
		StavkaFakture retVal = new StavkaFakture();
		retVal.setKolicina((int)stavkaFakture.getKolicina());
		retVal.setProizvod(proizvodService.getById(stavkaFakture.getProizvod().getId()));
		
		retVal.setJedinicnaCena(stavkaFakture.getCena());
		retVal.setStopaPDV(stavkaFakture.getStopaPDV());
		
		double vrednostStavke = stavkaFakture.getCena()*stavkaFakture.getKolicina();
		retVal.setRabat(vrednostStavke*(100-rabat)/100);
		retVal.setOsnovica(vrednostStavke - retVal.getRabat());
		retVal.setIznosPDV(retVal.getOsnovica()*retVal.getStopaPDV()/100);
		retVal.setUkupanIznos(vrednostStavke-retVal.getRabat()+retVal.getIznosPDV());
		
		return retVal;
	}


	private double sracunajRabat(NarudzbenicaDTO narudzbenica) {
		// TODO Auto-generated method stub
		double rabatPoslovnogPartnera=sracunajRabatPoslovnogPartnera(narudzbenica.getIdPoslovnogPartnera());
		double rabatNarudzbenice=sracunajRabatNarudzbenice(narudzbenica.getStavke());
		
		
		
		return rabatPoslovnogPartnera+rabatNarudzbenice;
	}


	


	private double sracunajRabatPoslovnogPartnera(Long idPoslovnogPartnera) {
		// TODO Auto-generated method stub
		double maxRabat = 5.0;
		
		int brojSaradnji = fakturaService.getFakture().size();
		int brojSaradnjiSaPartnerom = fakturaService.getFakture(poslovniPartnerService.getById(idPoslovnogPartnera)).size();
		
		
		
		return (brojSaradnjiSaPartnerom/brojSaradnji)*maxRabat;
	}
	private double sracunajRabatNarudzbenice(ArrayList<StavkaFaktureDTO> stavke) {
		// TODO Auto-generated method stub
		double maxRabat=10.0; //Maksimalni moguci rabat na kolicinu
		double trazenaCena=100000; //Cena potrebna za ostavernje maksimalnog moguceg rabata
		
		double ostvarenaCena=0;
		
		for (StavkaFaktureDTO stavkaFaktureDTO : stavke) 
		{
			ostvarenaCena+=stavkaFaktureDTO.getCena()*stavkaFaktureDTO.getKolicina();
		}
		if(ostvarenaCena>trazenaCena)
		{
			return maxRabat;
		}
		
		
		return (ostvarenaCena/trazenaCena)*maxRabat;
	}

	private String napraviIme(Faktura faktura)
	{
		SimpleDateFormat f = new SimpleDateFormat("ddMMyy");
		StringBuilder sb = new StringBuilder();
		
		sb.append(f.format(new Date()));
		sb.append("-");
		if(brojFakture<10 )
		{
			sb.append("0000");
		}else if(brojFakture<100)
		{
			sb.append("000");
		}else if(brojFakture<1000)
		{
			sb.append("00");
		}else if(brojFakture<10000)
		{
			sb.append("0");
		}
		sb.append(++brojFakture);
		sb.append("-");
		sb.append(new Random().nextInt(100000));
		
		
		return sb.toString();
	}
	
}
