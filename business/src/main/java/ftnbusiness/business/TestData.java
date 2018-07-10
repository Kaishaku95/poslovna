package ftnbusiness.business;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ftnbusiness.business.cenovnik.Cenovnik;
import ftnbusiness.business.cenovnik.CenovnikService;
import ftnbusiness.business.faktura.Faktura;
import ftnbusiness.business.faktura.FakturaService;
import ftnbusiness.business.grupaProizvoda.GrupaProizvoda;
import ftnbusiness.business.grupaProizvoda.GrupaProizvodaService;
import ftnbusiness.business.jedinicaMere.JedinicaMere;
import ftnbusiness.business.jedinicaMere.JedinicaMereService;
import ftnbusiness.business.pdv.PDV;
import ftnbusiness.business.pdv.PDVService;
import ftnbusiness.business.poslovnaGodina.PoslovnaGodina;
import ftnbusiness.business.poslovnaGodina.PoslovnaGodinaService;
import ftnbusiness.business.poslovniPartner.PoslovniPartner;
import ftnbusiness.business.poslovniPartner.PoslovniPartnerService;
import ftnbusiness.business.preduzece.Preduzece;
import ftnbusiness.business.preduzece.PreduzeceService;
import ftnbusiness.business.proizvod.Proizvod;
import ftnbusiness.business.proizvod.ProizvodService;
import ftnbusiness.business.stavkaCenovnika.StavkaCenovnika;
import ftnbusiness.business.stavkaCenovnika.StavkaCenovnikaService;
import ftnbusiness.business.stavkaFakture.StavkaFakture;
import ftnbusiness.business.stavkaFakture.StavkaFaktureService;
import ftnbusiness.business.stopaPDV.StopaPDV;
import ftnbusiness.business.stopaPDV.StopaPDVService;
import ftnbusiness.business.tipPoslovnogPartnera.TipPoslovnogPartnera;
import ftnbusiness.business.tipPoslovnogPartnera.TipPoslovnogPartneraService;
import ftnbusiness.business.vrstaProizvoda.VrstaProizvoda;
import ftnbusiness.business.vrstaProizvoda.VrstaProizvodaService;

@Component
public class TestData {

	@Autowired
	private PoslovnaGodinaService poslovnaGodinaService;
	
	@Autowired 
	private PDVService pdvService;
	
	@Autowired
	private StopaPDVService stopaPDVService;
	
	@Autowired
	private GrupaProizvodaService grupaProizvodaService;
	
	@Autowired
	private VrstaProizvodaService vrstaProizvodaService;
	
	@Autowired
	private PreduzeceService preduzeceService;
	
	@Autowired
	private CenovnikService cenovnikService;
	
	@Autowired
	private JedinicaMereService jedinicaMereService;
	
	@Autowired 
	private ProizvodService proizvodService;
	
	@Autowired
	private StavkaCenovnikaService stavkaCenovnikaService;
	
	@Autowired
	private TipPoslovnogPartneraService tipPoslovnogPartneraService;
	
	@Autowired
	private PoslovniPartnerService poslovniPartnerService;
	
	@Autowired
	private FakturaService fakturaService;
	
	@Autowired
	private StavkaFaktureService stavkaFaktureService;
	
	@PostConstruct
	private void init() {
		PDV pdv1 = new PDV();
		pdv1.setNaziv("Opsti");
		PDV pdv2 = new PDV();
		pdv2.setNaziv("Subvencionisani");
		PDV pdv3 = new PDV();
		pdv3.setNaziv("Rigorozni"); 
		pdvService.addPDV(pdv1);
		pdvService.addPDV(pdv2);
		pdvService.addPDV(pdv3);
		
		StopaPDV spdv1 = new StopaPDV();
		spdv1.setDatumVazenja(1514764800000l); //2018-01-01
		spdv1.setStopa(20);
		spdv1.setPdv(pdv1);
		StopaPDV spdv2 = new StopaPDV();
		spdv2.setDatumVazenja(1514764800000l); //2018-01-01
		spdv2.setStopa(10);
		spdv2.setPdv(pdv2);
		StopaPDV spdv3 = new StopaPDV();
		spdv3.setDatumVazenja(1546300800000l); //2019-01-01
		spdv3.setStopa(12);
		spdv3.setPdv(pdv2);
		StopaPDV spdv4 = new StopaPDV();
		spdv4.setDatumVazenja(1514764800000l); //2018-01-01
		spdv4.setStopa(25);
		spdv4.setPdv(pdv3);
		stopaPDVService.addStopaPDV(spdv1);
		stopaPDVService.addStopaPDV(spdv2);
		stopaPDVService.addStopaPDV(spdv3);
		stopaPDVService.addStopaPDV(spdv4);
		
		GrupaProizvoda gp1 = new GrupaProizvoda();
		gp1.setNazivGrupe("Racunarska oprema");
		gp1.setPdv(pdv3);
		GrupaProizvoda gp2 = new GrupaProizvoda();
		gp2.setNazivGrupe("Hrana");
		gp2.setPdv(pdv2);
		GrupaProizvoda gp3 = new GrupaProizvoda();
		gp3.setNazivGrupe("Pice");
		gp3.setPdv(pdv2);
		GrupaProizvoda gp4 = new GrupaProizvoda();
		gp4.setNazivGrupe("Kancelarijski materijal");
		gp4.setPdv(pdv1);
		grupaProizvodaService.addGrupaProizvoda(gp1); 
		grupaProizvodaService.addGrupaProizvoda(gp2); 
		grupaProizvodaService.addGrupaProizvoda(gp3); 
		grupaProizvodaService.addGrupaProizvoda(gp4); 
		
		VrstaProizvoda vp1 = new VrstaProizvoda();
		vp1.setNaziv("Ishrana");
		VrstaProizvoda vp2 = new VrstaProizvoda();
		vp2.setNaziv("Tehnika");
		VrstaProizvoda vp3 = new VrstaProizvoda();
		vp3.setNaziv("Kancelarijski materijal");
		vrstaProizvodaService.addVrstaProizvoda(vp1);
		vrstaProizvodaService.addVrstaProizvoda(vp2);
		vrstaProizvodaService.addVrstaProizvoda(vp3);
		
		Preduzece p = new Preduzece();
		p.setAdresa("Duznicka 17, Beograd");
		p.setNaziv("Balkan promet");
		p.setKontakt("01123454326");
		preduzeceService.addPreduzece(p);
		
		Cenovnik c1 = new Cenovnik();
		c1.setDatumVazenja(1514764800000l); //2018-01-01
		Cenovnik c2 = new Cenovnik();
		c2.setDatumVazenja(1546300800000l); //2019-01-01
		cenovnikService.addCenovnik(c1);
		cenovnikService.addCenovnik(c2);
		
		JedinicaMere jm1 = new JedinicaMere();
		jm1.setNaziv("Tona");
		jm1.setSkracenica("t");
		JedinicaMere jm2 = new JedinicaMere();
		jm2.setNaziv("Kilogram");
		jm2.setSkracenica("kg");
		JedinicaMere jm3 = new JedinicaMere();
		jm3.setNaziv("Gram");
		jm3.setSkracenica("g");
		JedinicaMere jm4 = new JedinicaMere();
		jm4.setNaziv("Litar");
		jm4.setSkracenica("l");
		JedinicaMere jm5 = new JedinicaMere();
		jm5.setNaziv("Galon");
		jm5.setSkracenica("gal");
		JedinicaMere jm6 = new JedinicaMere();
		jm6.setNaziv("Metar");
		jm6.setSkracenica("m");
		JedinicaMere jm7 = new JedinicaMere();
		jm7.setNaziv("Komad");
		jm7.setSkracenica("kom");
		jedinicaMereService.addJedinicaMere(jm1);
		jedinicaMereService.addJedinicaMere(jm2);
		jedinicaMereService.addJedinicaMere(jm3);
		jedinicaMereService.addJedinicaMere(jm4);
		jedinicaMereService.addJedinicaMere(jm5);
		jedinicaMereService.addJedinicaMere(jm6);
		jedinicaMereService.addJedinicaMere(jm7);
		
		Proizvod pr1 = new Proizvod();
		pr1.setNaziv("Samsung monitor");
		pr1.setJedinicaMere(jm7);
		pr1.setPreduzece(p);
		pr1.setVrstaProizvoda(vp2);
		pr1.setGrupaProizvoda(gp1);
		Proizvod pr2 = new Proizvod();
		pr2.setNaziv("Genius mis");
		pr2.setJedinicaMere(jm7);
		pr2.setPreduzece(p);
		pr2.setVrstaProizvoda(vp2);
		pr2.setGrupaProizvoda(gp1);
		Proizvod pr3 = new Proizvod();
		pr3.setNaziv("Kukuruzno brasno");
		pr3.setJedinicaMere(jm1);
		pr3.setPreduzece(p);
		pr3.setVrstaProizvoda(vp1);
		pr3.setGrupaProizvoda(gp2);
		Proizvod pr4 = new Proizvod();
		pr4.setNaziv("Tuna u konzervi");
		pr4.setJedinicaMere(jm2);
		pr4.setPreduzece(p);
		pr4.setVrstaProizvoda(vp1);
		pr4.setGrupaProizvoda(gp2);
		Proizvod pr5 = new Proizvod();
		pr5.setNaziv("Sok od bundeve");
		pr5.setJedinicaMere(jm5);
		pr5.setPreduzece(p);
		pr5.setVrstaProizvoda(vp1);
		pr5.setGrupaProizvoda(gp3);
		Proizvod pr6 = new Proizvod();
		pr6.setNaziv("Red bull");
		pr6.setJedinicaMere(jm4);
		pr6.setPreduzece(p);
		pr6.setVrstaProizvoda(vp1);
		pr6.setGrupaProizvoda(gp3);
		Proizvod pr7 = new Proizvod();
		pr7.setNaziv("Suncokretovo ulje");
		pr7.setJedinicaMere(jm4);
		pr7.setPreduzece(p);
		pr7.setVrstaProizvoda(vp1);
		pr7.setGrupaProizvoda(gp2);
		Proizvod pr8 = new Proizvod();
		pr8.setNaziv("Krompir");
		pr8.setJedinicaMere(jm2);
		pr8.setPreduzece(p);
		pr8.setVrstaProizvoda(vp1);
		pr8.setGrupaProizvoda(gp2);
		Proizvod pr9 = new Proizvod();
		pr9.setNaziv("Spajalica");
		pr9.setJedinicaMere(jm2);
		pr9.setPreduzece(p);
		pr9.setVrstaProizvoda(vp3);
		pr9.setGrupaProizvoda(gp4);
		Proizvod pr0 = new Proizvod();
		pr0.setNaziv("Fascikla");
		pr0.setJedinicaMere(jm7);
		pr0.setPreduzece(p);
		pr0.setVrstaProizvoda(vp3);
		pr0.setGrupaProizvoda(gp4);
		proizvodService.addProizvod(pr1);
		proizvodService.addProizvod(pr2);
		proizvodService.addProizvod(pr3);
		proizvodService.addProizvod(pr4);
		proizvodService.addProizvod(pr5);
		proizvodService.addProizvod(pr6);
		proizvodService.addProizvod(pr7);
		proizvodService.addProizvod(pr8);
		proizvodService.addProizvod(pr9);
		proizvodService.addProizvod(pr0);

		StavkaCenovnika sc1 = new StavkaCenovnika();
		sc1.setCenovnik(c1);
		sc1.setProizvod(pr1);
		sc1.setCena(7600);
		StavkaCenovnika sc2 = new StavkaCenovnika();
		sc2.setCenovnik(c1);
		sc2.setProizvod(pr2);
		sc2.setCena(600);
		StavkaCenovnika sc3 = new StavkaCenovnika();
		sc3.setCenovnik(c1);
		sc3.setProizvod(pr3);
		sc3.setCena(120);
		StavkaCenovnika sc4 = new StavkaCenovnika();
		sc4.setCenovnik(c1);
		sc4.setProizvod(pr4);
		sc4.setCena(500);
		StavkaCenovnika sc5 = new StavkaCenovnika();
		sc5.setCenovnik(c1);
		sc5.setProizvod(pr5);
		sc5.setCena(200);
		StavkaCenovnika sc6 = new StavkaCenovnika();
		sc6.setCenovnik(c1);
		sc6.setProizvod(pr6);
		sc6.setCena(300);
		StavkaCenovnika sc7 = new StavkaCenovnika();
		sc7.setCenovnik(c1);
		sc7.setProizvod(pr7);
		sc7.setCena(100);
		StavkaCenovnika sc8 = new StavkaCenovnika();
		sc8.setCenovnik(c1);
		sc8.setProizvod(pr8);
		sc8.setCena(40);
		StavkaCenovnika sc9 = new StavkaCenovnika();
		sc9.setCenovnik(c1);
		sc9.setProizvod(pr9);
		sc9.setCena(80);
		StavkaCenovnika sc0 = new StavkaCenovnika();
		sc0.setCenovnik(c1);
		sc0.setProizvod(pr0);
		sc0.setCena(10);
		StavkaCenovnika sc11 = new StavkaCenovnika();
		sc11.setCenovnik(c2);
		sc11.setProizvod(pr1);
		sc11.setCena(7800);
		StavkaCenovnika sc21 = new StavkaCenovnika();
		sc21.setCenovnik(c2);
		sc21.setProizvod(pr2);
		sc21.setCena(800);
		StavkaCenovnika sc31 = new StavkaCenovnika();
		sc31.setCenovnik(c2);
		sc31.setProizvod(pr3);
		sc31.setCena(140);
		StavkaCenovnika sc41 = new StavkaCenovnika();
		sc41.setCenovnik(c2);
		sc41.setProizvod(pr4);
		sc41.setCena(600);
		StavkaCenovnika sc51 = new StavkaCenovnika();
		sc51.setCenovnik(c2);
		sc51.setProizvod(pr5);
		sc51.setCena(210);
		StavkaCenovnika sc61 = new StavkaCenovnika();
		sc61.setCenovnik(c2);
		sc61.setProizvod(pr6);
		sc61.setCena(280);
		StavkaCenovnika sc71 = new StavkaCenovnika();
		sc71.setCenovnik(c2);
		sc71.setProizvod(pr7);
		sc71.setCena(110);
		StavkaCenovnika sc81 = new StavkaCenovnika();
		sc81.setCenovnik(c2);
		sc81.setProizvod(pr8);
		sc81.setCena(42);
		StavkaCenovnika sc91 = new StavkaCenovnika();
		sc91.setCenovnik(c2);
		sc91.setProizvod(pr9);
		sc91.setCena(88);
		StavkaCenovnika sc01 = new StavkaCenovnika();
		sc01.setCenovnik(c2);
		sc01.setProizvod(pr0);
		sc01.setCena(11);
		stavkaCenovnikaService.addStavkaCenovnika(sc1);
		stavkaCenovnikaService.addStavkaCenovnika(sc2);
		stavkaCenovnikaService.addStavkaCenovnika(sc3);
		stavkaCenovnikaService.addStavkaCenovnika(sc4);
		stavkaCenovnikaService.addStavkaCenovnika(sc5);
		stavkaCenovnikaService.addStavkaCenovnika(sc6);
		stavkaCenovnikaService.addStavkaCenovnika(sc7);
		stavkaCenovnikaService.addStavkaCenovnika(sc8);
		stavkaCenovnikaService.addStavkaCenovnika(sc9);
		stavkaCenovnikaService.addStavkaCenovnika(sc0);
		stavkaCenovnikaService.addStavkaCenovnika(sc11);
		stavkaCenovnikaService.addStavkaCenovnika(sc21);
		stavkaCenovnikaService.addStavkaCenovnika(sc31);
		stavkaCenovnikaService.addStavkaCenovnika(sc41);
		stavkaCenovnikaService.addStavkaCenovnika(sc51);
		stavkaCenovnikaService.addStavkaCenovnika(sc61);
		stavkaCenovnikaService.addStavkaCenovnika(sc71);
		stavkaCenovnikaService.addStavkaCenovnika(sc81);
		stavkaCenovnikaService.addStavkaCenovnika(sc91);
		stavkaCenovnikaService.addStavkaCenovnika(sc01);
		
		TipPoslovnogPartnera tpp1 = new TipPoslovnogPartnera();
		tpp1.setNaziv("Dobavljac");
		TipPoslovnogPartnera tpp2 = new TipPoslovnogPartnera();
		tpp2.setNaziv("Kupac");
		TipPoslovnogPartnera tpp3 = new TipPoslovnogPartnera();
		tpp3.setNaziv("Kupac i Dobavljac");
		tipPoslovnogPartneraService.addTipPoslovnogPartnera(tpp1);
		tipPoslovnogPartneraService.addTipPoslovnogPartnera(tpp2);
		tipPoslovnogPartneraService.addTipPoslovnogPartnera(tpp3);
		
		PoslovniPartner pp1 = new PoslovniPartner();
		pp1.setAdresa("Neizmirenih dugova bb, Zrenjanin");
		pp1.setNaziv("Prevarant i sinovi doo");
		pp1.setKontakt("023333444");
		pp1.setTipPoslovnogPartnera(tpp2);
		PoslovniPartner pp2 = new PoslovniPartner();
		pp2.setAdresa("Robovlasnicka 6, Novi Sad");
		pp2.setNaziv("Nanosoft");
		pp2.setKontakt("021363444");
		pp2.setTipPoslovnogPartnera(tpp2);
		PoslovniPartner pp3 = new PoslovniPartner();
		pp3.setAdresa("Apsolventska 1, Beograd");
		pp3.setNaziv("Eufrat Import");
		pp3.setKontakt("011333444");
		pp3.setTipPoslovnogPartnera(tpp1);
		PoslovniPartner pp4 = new PoslovniPartner();
		pp4.setAdresa("Sumnjiva 58, Zrenjanin");
		pp4.setNaziv("Haiti invest");
		pp4.setKontakt("023333444");
		pp4.setTipPoslovnogPartnera(tpp3);
		poslovniPartnerService.addPoslovniPartner(pp1);
		poslovniPartnerService.addPoslovniPartner(pp2);
		poslovniPartnerService.addPoslovniPartner(pp3);
		poslovniPartnerService.addPoslovniPartner(pp4);
		
		PoslovnaGodina pg1 = new PoslovnaGodina();
		pg1.setGodina(2016);
		pg1.setZakljucena(true);
		pg1.setPreduzece(p);
		PoslovnaGodina pg2 = new PoslovnaGodina();
		pg2.setGodina(2017);
		pg2.setZakljucena(true);
		pg2.setPreduzece(p);
		PoslovnaGodina pg3 = new PoslovnaGodina();
		pg3.setGodina(2018);
		pg3.setZakljucena(false);
		pg3.setPreduzece(p);
		poslovnaGodinaService.addPoslovnaGodina(pg1);
		poslovnaGodinaService.addPoslovnaGodina(pg2);
		poslovnaGodinaService.addPoslovnaGodina(pg3);

		Faktura f = new Faktura();
		f.setBrojFakture("1");
		f.setDatumFakture(1514764800000l);
		f.setDatumValute(1514764800000l);
		f.setPoslovnaGodina(pg1);
		f.setPoslovniPartner(pp4);
		f.setPreduzece(p);
		f.setUkupanIznosBezPDV(0);
		f.setUkupanPDV(0);
		f.setUkupanRabat(0);
		f.setUkupnoZaPlacanje(0);
		fakturaService.addFaktura(f);
		Faktura f2 = new Faktura();
		f2.setBrojFakture("2");
		f2.setDatumFakture(1514764800000l);
		f2.setDatumValute(1514764800000l);
		f2.setPoslovnaGodina(pg1);
		f2.setPoslovniPartner(pp4);
		f2.setPreduzece(p);
		f2.setUkupanIznosBezPDV(0);
		f2.setUkupanPDV(0);
		f2.setUkupanRabat(0);
		f2.setUkupnoZaPlacanje(0);
		fakturaService.addFaktura(f2);
		
		StavkaFakture sf = new StavkaFakture();
		sf.setFaktura(f);
		sf.setIznosPDV(0);
		sf.setJedinicnaCena(0);
		sf.setKolicina(0);
		sf.setOsnovica(0);
		sf.setProizvod(pr0);
		sf.setRabat(0);
		sf.setStopaPDV(0);
		sf.setUkupanIznos(0);
		stavkaFaktureService.addStavkaFakture(sf);
		StavkaFakture sf2 = new StavkaFakture();
		sf2.setFaktura(f);
		sf2.setIznosPDV(0);
		sf2.setJedinicnaCena(0);
		sf2.setKolicina(0);
		sf2.setOsnovica(0);
		sf2.setProizvod(pr0);
		sf2.setRabat(0);
		sf2.setStopaPDV(0);
		sf2.setUkupanIznos(0);
		stavkaFaktureService.addStavkaFakture(sf2);
	}
}
