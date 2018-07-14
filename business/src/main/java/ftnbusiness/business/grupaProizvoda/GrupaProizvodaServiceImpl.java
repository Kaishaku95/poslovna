package ftnbusiness.business.grupaProizvoda;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GrupaProizvodaServiceImpl implements GrupaProizvodaService{

	@Autowired
	private GrupaProizvodaRepository grupaProizvodaRepository;
	@Override
	public Long addGrupaProizvoda(GrupaProizvoda gp) {
		return grupaProizvodaRepository.save(gp).getId();
	}
	@Override
	public List<GrupaProizvoda> findAll() {
		return grupaProizvodaRepository.findAll();
	}
	
}
