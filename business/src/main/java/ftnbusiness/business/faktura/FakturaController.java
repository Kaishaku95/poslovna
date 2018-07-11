

package ftnbusiness.business.faktura;

import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletResponse;
import javax.websocket.server.PathParam;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ftnbusiness.business.cenovnik.Cenovnik;
import ftnbusiness.business.cenovnik.CenovnikService;
import ftnbusiness.business.pdv.PDV;
import ftnbusiness.business.poslovnaGodina.PoslovnaGodina;
import ftnbusiness.business.poslovnaGodina.PoslovnaGodinaService;
import ftnbusiness.business.poslovniPartner.PoslovniPartner;
import ftnbusiness.business.poslovniPartner.PoslovniPartnerService;
import ftnbusiness.business.preduzece.Preduzece;
import ftnbusiness.business.preduzece.PreduzeceService;
import ftnbusiness.business.proizvod.Proizvod;
import ftnbusiness.business.proizvod.ProizvodService;
import ftnbusiness.business.stavkaCenovnika.StavkaCenovnikaService;
import ftnbusiness.business.stavkaFakture.StavkaFakture;
import ftnbusiness.business.stavkaFakture.StavkaFaktureService;
import ftnbusiness.business.stopaPDV.StopaPDVService;


@RestController
@RequestMapping("/api")
public class FakturaController {

	private static int brojFakture =0;

	@Autowired
	private FakturaService fakturaService;
	@Autowired
	private PreduzeceService preduzeceService;

	@Autowired
	private PoslovnaGodinaService poslovnaGodinaService;

	@Autowired
	private PoslovniPartnerService poslovniPartnerService;

	@Autowired
	private ProizvodService proizvodService;

	@Autowired
	private StopaPDVService stopaPDVService;

	@Autowired
	private StavkaCenovnikaService stavkaCenovnikaService;

	@Autowired
	private StavkaFaktureService stavkaFaktureService;

	@Autowired
	private CenovnikService cenovnikService;

	@RequestMapping(method = RequestMethod.GET,value="/fakture")
	public ResponseEntity<ArrayList<Faktura>> getFakture()
	{
		return new ResponseEntity<ArrayList<Faktura>>(fakturaService.getFakture(), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET,value="/fakture/{id:\\d+}")
	public ResponseEntity<ArrayList<Faktura>> getFaktureIzGodine(@PathVariable Long id)
	{
		PoslovnaGodina pg = poslovnaGodinaService.findOne(id);
		return new ResponseEntity<ArrayList<Faktura>>(fakturaService.getFaktureIzGodine(pg), HttpStatus.OK);
	}

	@GetMapping("/poslovnegodine")
	public ResponseEntity<ArrayList<PoslovnaGodina>> getPoslovneGodine()
	{
		return new ResponseEntity<ArrayList<PoslovnaGodina>>(poslovnaGodinaService.findAll(), HttpStatus.OK);
	}

	@GetMapping("/partneri")
	public ResponseEntity<ArrayList<PoslovniPartner>> getPoslovniPartneri()
	{
		return new ResponseEntity<ArrayList<PoslovniPartner>>(poslovniPartnerService.findAll(), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST,value="/fakture")
	public ResponseEntity<Long> postFakture(@RequestBody NarudzbenicaDTO narudzbenicaDTO)
	{
		Long idNoveFaktura = fakturisi(narudzbenicaDTO,preduzeceService.getByName("Balkan promet"));



		return new ResponseEntity<Long>(idNoveFaktura, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET,value="/narudzbenica")
	public ResponseEntity<NarudzbenicaDTO> getNarudzbenica(@RequestBody NarudzbenicaDTO narudzbenicaDTO)
	{



		return new ResponseEntity<NarudzbenicaDTO>(new NarudzbenicaDTO(narudzbenicaDTO), HttpStatus.OK);
	}


	@RequestMapping(method = RequestMethod.GET,value="/export/fakture/{id}")
	public ResponseEntity<HashMap<String,String>> postFakture(@PathVariable Long id, HttpServletResponse response)
	{
		Faktura novaFaktura = fakturaService.getById(id);
		long derp =5;

		//Faktura novaFaktura=new Faktura(derp, "Ovo je mock faktura", derp, derp, derp, derp, derp, derp, new PoslovniPartner(), new Preduzece(), new PoslovnaGodina());
		try
		{




			JAXBContext context = JAXBContext.newInstance(Faktura.class);
			Marshaller marshaller = context.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

			StringWriter sw = new StringWriter();
			marshaller.marshal(novaFaktura, sw);

		    HashMap<String, String> retVal = new HashMap<>();
		    retVal.put("faktura", Base64Utils.encodeToString(sw.toString().getBytes()));

		    return new ResponseEntity<HashMap<String, String>>(retVal, HttpStatus.OK);

	    } catch (Exception ex) {

	        System.out.println(ex.toString());
	    }
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@GetMapping("/stavke")
	public ResponseEntity<List<StavkaFaktureDTO>> getStavke() {
		ArrayList<StavkaFaktureDTO> stavke = new ArrayList<>();
		ArrayList<Proizvod> proizvodi = proizvodService.findAll();
		for(int i = 0; i<proizvodi.size(); i++) {
			StavkaFaktureDTO sDTO = new StavkaFaktureDTO();
			sDTO.setProizvod(proizvodi.get(i));
			PDV pdv = proizvodi.get(i).getGrupaProizvoda().getPdv();
			Cenovnik c = cenovnikService.findActive(System.currentTimeMillis());
			sDTO.setCena(stavkaCenovnikaService.findCenaByCenovnikAndProizvod(c, proizvodi.get(i)));
			sDTO.setStopaPDV(stopaPDVService.findNewestByPDV(pdv));
			sDTO.setPdv(sDTO.getCena()*sDTO.getStopaPDV()/100);
			sDTO.setKolicina(0);
			stavke.add(sDTO);
			}
		if(stavke == null || stavke.isEmpty())
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(stavke, HttpStatus.OK);
	}

	public Long fakturisi(NarudzbenicaDTO narudzbenica, Preduzece preduzece)
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
			if(stavkaFakture.getKolicina()>0)
			{
			stavke.add(napraviStavku(stavkaFakture, rabat));
			}
		}
		double ukupnoRabat =0;
		double ukupnoBezPDV=0;
		double ukupanPDV=0;
		double ukupno = 0;
		for (StavkaFakture stavkaFakture : stavke)
		{
			ukupnoRabat+=stavkaFakture.getRabat();
			ukupnoBezPDV+=(stavkaFakture.getOsnovica());
			ukupanPDV+=stavkaFakture.getIznosPDV();
			ukupno +=stavkaFakture.getUkupanIznos();
		}
		faktura.setUkupanRabat(ukupnoRabat);
		faktura.setUkupanIznosBezPDV(ukupnoBezPDV);
		faktura.setUkupanPDV(ukupanPDV);
		faktura.setUkupnoZaPlacanje(ukupno);

		long retVal =fakturaService.addFaktura(faktura);
		for (StavkaFakture stavkaFakture : stavke)
		{
			stavkaFakture.setFaktura(faktura);
			stavkaFaktureService.addStavkaFakture(stavkaFakture);
		}



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
		retVal.setRabat(vrednostStavke*(rabat)/100);
		retVal.setOsnovica(vrednostStavke - retVal.getRabat());
		retVal.setIznosPDV(retVal.getOsnovica()*retVal.getStopaPDV()/100);
		retVal.setUkupanIznos(retVal.getOsnovica()+retVal.getIznosPDV());

		return retVal;
	}


	private double sracunajRabat(NarudzbenicaDTO narudzbenica) {
		// TODO Auto-generated method stub
		double rabatPoslovnogPartnera=sracunajRabatPoslovnogPartnera(narudzbenica.getIdPoslovnogPartnera());
		double rabatNarudzbenice=sracunajRabatNarudzbenice(narudzbenica.getStavke());



		return ((int)10*(rabatPoslovnogPartnera+rabatNarudzbenice))/10.0;
	}





	private double sracunajRabatPoslovnogPartnera(Long idPoslovnogPartnera) {
		// TODO Auto-generated method stub
		double maxRabat = 5.0;

		int brojSaradnji = fakturaService.getFakture().size();
		if(brojSaradnji==0)
		{
			return 0;
		}
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

