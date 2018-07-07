package ftnbusiness.business.faktura;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

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


@RestController
@RequestMapping("/api")
public class FakturaController {

	@Autowired
	FakturaService fakturaService;	
	
	
	@RequestMapping(method = RequestMethod.GET,value="/fakture")
	public ResponseEntity<ArrayList<Faktura>> getFakture() 
	{
		return new ResponseEntity<ArrayList<Faktura>>(fakturaService.getFakture(), HttpStatus.OK);	
	}
	
	@RequestMapping(method = RequestMethod.POST,value="/fakture")
	public ResponseEntity<Long> postFakture(@RequestBody NarudzbenicaDTO narudzbenicaDTO) 
	{
		Faktura novaFaktura = new Faktura(narudzbenicaDTO);
		
		
		
		return new ResponseEntity<Long>(fakturaService.addFaktura(novaFaktura), HttpStatus.OK);	
	}
	
	@RequestMapping(method = RequestMethod.GET,value="/export/fakture/{id}")
	public void postFakture(@PathParam("id") Long id, HttpServletResponse response) 
	{
		//Faktura novaFaktura = fakturaService.getById(id);
		long derp =5;
		
		Faktura novaFaktura=new Faktura(derp, "123", derp, derp, derp, derp, derp, derp, new PoslovniPartner(), new Preduzece(), new PoslovnaGodina());
		try 
		{
			
			
			
		      // get your file as InputStream
			  JAXBContext context = JAXBContext.newInstance(Faktura.class);
			  Marshaller marshaller = context.createMarshaller();
			  marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			  final OutputStream fileOutputStream = new FileOutputStream(new File(
			          "target/test.xml"));
			  marshaller.marshal(novaFaktura, fileOutputStream);
			  fileOutputStream.flush();
			  fileOutputStream.close();
 
			 
			  final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			  outputStream.write("test".getBytes());
			  marshaller.marshal(novaFaktura, outputStream);
			  outputStream.flush();
			  final InputStream is = new ByteArrayInputStream(outputStream.toByteArray());
			  outputStream.close();
			  
			  
			
			
			
			
			
		    
		    // copy it to response's OutputStream
		    org.apache.commons.io.IOUtils.copy(is, response.getOutputStream());
		    response.flushBuffer();
	    } catch (Exception ex) {
	      
	        System.out.println(ex.toString());
	    }
	
			
	}
}
