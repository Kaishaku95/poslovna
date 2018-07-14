package ftnbusiness.business.vrstaProizvoda;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ftnbusiness.business.cenovnik.Cenovnik;
import ftnbusiness.business.cenovnik.CenovnikDTO;
import ftnbusiness.business.stavkaCenovnika.StavkaCenovnika;

@RestController
@RequestMapping("/api/vrstaproizvoda")
public class VrstaProizvodaController {
	@Autowired
	private VrstaProizvodaService vrstaProizvodaService;
	
	@GetMapping
	public ResponseEntity<List<VrstaProizvoda>> getVrsteProizvoda() {
		List<VrstaProizvoda> lista = vrstaProizvodaService.findAll();
		if(lista == null || lista.isEmpty())
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(lista, HttpStatus.OK);
	}
	
	@GetMapping("/{id:\\d+}")
	public ResponseEntity<VrstaProizvoda> getVrstaProizvoda(@PathVariable Long id) {
		VrstaProizvoda vrsta = vrstaProizvodaService.findOne(id);
		if(vrsta == null)
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(vrsta, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<VrstaProizvoda> addVrstaProizvoda(@RequestBody VrstaProizvoda dto) {
		return new ResponseEntity<>(vrstaProizvodaService.add(dto), HttpStatus.OK);
	}
	
}
