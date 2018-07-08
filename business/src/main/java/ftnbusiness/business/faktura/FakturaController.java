

package ftnbusiness.business.faktura;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.websocket.server.PathParam;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import ftnbusiness.business.stopaPDV.StopaPDVService;


@RestController
@RequestMapping("/api")
public class FakturaController {

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
	private CenovnikService cenovnikService;
	
	@RequestMapping(method = RequestMethod.GET,value="/fakture")
	public ResponseEntity<ArrayList<Faktura>> getFakture() 
	{
		return new ResponseEntity<ArrayList<Faktura>>(fakturaService.getFakture(), HttpStatus.OK);	
	}
	
	@RequestMapping(method = RequestMethod.GET,value="/fakture/{id:\\\\d+}")
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
		Long idNoveFaktura = new FakturaFactory(preduzeceService.getByName("Balkan Promet")).fakturisi(narudzbenicaDTO);
		
		
		
		return new ResponseEntity<Long>(idNoveFaktura, HttpStatus.OK);	
	}
	

	@RequestMapping(method = RequestMethod.GET,value="/export/fakture/{id}")
	public ResponseEntity<HashMap<String,String>> postFakture(@PathParam("id") Long id, HttpServletResponse response) 
	{
		//Faktura novaFaktura = fakturaService.getById(id);
		long derp =5;
		
		Faktura novaFaktura=new Faktura(derp, "Ovo je mock faktura", derp, derp, derp, derp, derp, derp, new PoslovniPartner(), new Preduzece(), new PoslovnaGodina());
		try 
		{
				
				
				
		    
			JAXBContext context = JAXBContext.newInstance(Faktura.class);
			Marshaller marshaller = context.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			 
			StringWriter sw = new StringWriter();
			marshaller.marshal(novaFaktura, sw);
			 
		    HashMap<String, String> retVal = new HashMap<>();
		    retVal.put("fakuta", sw.toString());
			  
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
			Cenovnik c = cenovnikService.findNewest();
			stavkaCenovnikaService.findCenaByCenovnikAndProizvod(c, proizvodi.get(i));
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
}

