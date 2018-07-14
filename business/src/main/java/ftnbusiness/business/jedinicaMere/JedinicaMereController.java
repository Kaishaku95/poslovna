package ftnbusiness.business.jedinicaMere;

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

@RestController
@RequestMapping("/api/jedinicamere")
public class JedinicaMereController {
	@Autowired
	private JedinicaMereService jedinicaMereService;
	
	@GetMapping
	public ResponseEntity<List<JedinicaMere>> getJedinice() {
		List<JedinicaMere> lista = jedinicaMereService.findAll();
		if(lista == null || lista.isEmpty())
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(lista, HttpStatus.OK);
	}
	
	@GetMapping("/{id:\\d+}")
	public ResponseEntity<JedinicaMere> getJedinicaMere(@PathVariable Long id) {
		JedinicaMere vrsta = jedinicaMereService.findOne(id);
		if(vrsta == null)
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(vrsta, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<JedinicaMere> addJedinicaMere(@RequestBody JedinicaMere dto) {
		return new ResponseEntity<>(jedinicaMereService.add(dto), HttpStatus.OK);
	}
	
}
