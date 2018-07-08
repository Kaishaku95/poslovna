package ftnbusiness.business.faktura;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletResponse;
import javax.websocket.server.PathParam;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ftnbusiness.business.poslovnaGodina.PoslovnaGodina;
import ftnbusiness.business.poslovniPartner.PoslovniPartner;
import ftnbusiness.business.preduzece.Preduzece;
import ftnbusiness.business.preduzece.PreduzeceService;


@RestController
@RequestMapping("/api")
public class FakturaController {

	@Autowired
	private FakturaService fakturaService;	
	@Autowired
	private PreduzeceService preduzeceService;
	
	
	@RequestMapping(method = RequestMethod.GET,value="/fakture")
	public ResponseEntity<ArrayList<Faktura>> getFakture() 
	{
		return new ResponseEntity<ArrayList<Faktura>>(fakturaService.getFakture(), HttpStatus.OK);	
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
}
