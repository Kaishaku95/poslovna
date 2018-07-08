package ftnbusiness.business.vrstaProizvoda;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VrstaProizvodaServiceImpl implements VrstaProizvodaService{

	@Autowired
	private VrstaProizvodaRepository vrstaProizvodaRepository;
	@Override
	public Long addVrstaProizvoda(VrstaProizvoda vp) {
		return vrstaProizvodaRepository.save(vp).getId();
	}

}
