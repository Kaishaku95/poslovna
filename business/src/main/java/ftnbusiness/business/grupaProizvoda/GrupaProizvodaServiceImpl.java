package ftnbusiness.business.grupaProizvoda;

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

}
