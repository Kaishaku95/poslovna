package ftnbusiness.business.proizvod;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ftnbusiness.business.cenovnik.Cenovnik;
import ftnbusiness.business.cenovnik.CenovnikService;
import ftnbusiness.business.grupaProizvoda.GrupaProizvodaService;
import ftnbusiness.business.jedinicaMere.JedinicaMereService;
import ftnbusiness.business.preduzece.PreduzeceService;
import ftnbusiness.business.stavkaCenovnika.StavkaCenovnika;
import ftnbusiness.business.stavkaCenovnika.StavkaCenovnikaService;
import ftnbusiness.business.vrstaProizvoda.VrstaProizvodaService;

@RestController
@RequestMapping("/api/proizvod")
public class ProizvodController {

	@Autowired
	private ProizvodService proizvodService;
	@Autowired
	private GrupaProizvodaService grupaService;
	@Autowired
	private JedinicaMereService jedinicaService;
	@Autowired
	private VrstaProizvodaService vrstaService;
	@Autowired
	private CenovnikService cenovnikService;
	@Autowired
	private StavkaCenovnikaService stavkaService;
	@Autowired
	private PreduzeceService preduzeceService;

	@GetMapping(path = "/grupe")
	public ResponseEntity<?> getAllGroups() {
		return new ResponseEntity<>(grupaService.findAll(), HttpStatus.OK);
	}

	@GetMapping(path = "/jedinice")
	public ResponseEntity<?> getAllJM() {
		return new ResponseEntity<>(jedinicaService.findAll(), HttpStatus.OK);
	}

	@GetMapping(path = "/vrste")
	public ResponseEntity<?> getAllTypes() {
		return new ResponseEntity<>(vrstaService.findAll(), HttpStatus.OK);
	}
	/*
	@PostMapping
	public ResponseEntity<?> addProizvod(@RequestBody ProizvodDTO dto) {
		Proizvod p = new Proizvod();
		p.setNaziv(dto.getNaziv());
		p.setJedinicaMere(dto.getJedinicaMere());
		p.setVrstaProizvoda(dto.getVrstaProizvoda());
		p.setGrupaProizvoda(dto.getGrupaProizvoda());
		p.setPreduzece(preduzeceService.getByName("Balkan promet"));
		
		Cenovnik current = cenovnikService.findActive(System.currentTimeMillis());
		List<Cenovnik> future = cenovnikService.findFuture(System.currentTimeMillis());
		
		StavkaCenovnika sc = new StavkaCenovnika();
		sc.setCena(dto.getCena());
		sc.setCenovnik(current);
		sc.setProizvod(p);
		
		Long id = proizvodService.addProizvod(p);
		return new ResponseEntity<>(proizvodService.getById(id), HttpStatus.OK);
	}
	 */
}
