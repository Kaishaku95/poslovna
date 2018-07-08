package ftnbusiness.business.cenovnik;

import java.util.ArrayList;
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

import ftnbusiness.business.stavkaCenovnika.StavkaCenovnika;
import ftnbusiness.business.stavkaCenovnika.StavkaCenovnikaService;


@RestController
@RequestMapping("/api/cenovnik")
public class CenovnikController {
	
	@Autowired
	private CenovnikService cenovnikService;
	
	@Autowired
	private StavkaCenovnikaService stavkaCenovnikaService;
	
	@GetMapping
	public ResponseEntity<List<Cenovnik>> getCenovniks() {
		List<Cenovnik> cenovniks = cenovnikService.findAll();
		if(cenovniks == null || cenovniks.isEmpty())
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(cenovniks, HttpStatus.OK);
	}
	
	@GetMapping("/{id:\\d+}")
	public ResponseEntity<Cenovnik> getCenovnik(@PathVariable Long id) {
		Cenovnik cenovnik = cenovnikService.findOne(id);
		if(cenovnik == null)
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(cenovnik, HttpStatus.OK);
	}
	
	/**vraca najnoviji*/
	@GetMapping("/najnoviji")
	public ResponseEntity<Cenovnik> getNewest() {
		Cenovnik cenovnik = cenovnikService.findNewest();
		if(cenovnik == null)
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(cenovnik, HttpStatus.OK);
	}
	
	@PostMapping("/{id:\\d+}")
	public ResponseEntity<Cenovnik> addCenovnik(@PathVariable Long id, 
			@RequestBody CenovnikDTO dto) {
		Cenovnik c = new Cenovnik();
		Cenovnik cn = cenovnikService.findOne(id);
		c.setDatumVazenja(dto.getDatum());
		cenovnikService.addCenovnik(c);
		for(int i = 0; i<dto.getStavke().size(); i++) {
			StavkaCenovnika sc = new StavkaCenovnika();
			sc.setCenovnik(c);
			sc.setProizvod(dto.getStavke().get(i).getProizvod());
			double staraCena = stavkaCenovnikaService.findCenaByCenovnikAndProizvod(cn, dto.getStavke().get(i).getProizvod());
			sc.setCena(dto.getStavke().get(i).getProcenat()
					*staraCena/100+staraCena);
			stavkaCenovnikaService.addStavkaCenovnika(sc);
		}
		return new ResponseEntity<>(c, HttpStatus.OK);
	}
	
	@GetMapping("/stavke/{id:\\d+}")
	public ResponseEntity<List<StavkaCenovnika>> getStavke(@PathVariable Long id) {
		Cenovnik c = cenovnikService.findOne(id);
		ArrayList<StavkaCenovnika> lista = stavkaCenovnikaService.findByCenovnik(c);
		return new ResponseEntity<>(lista, HttpStatus.OK);
	}
}
