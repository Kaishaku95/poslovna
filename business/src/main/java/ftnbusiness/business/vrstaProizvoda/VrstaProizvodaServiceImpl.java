package ftnbusiness.business.vrstaProizvoda;

import java.util.List;

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
	@Override
	public VrstaProizvoda add(VrstaProizvoda dto) {
		return vrstaProizvodaRepository.save(dto);
	}
	@Override
	public List<VrstaProizvoda> findAll() {
		return vrstaProizvodaRepository.findAll();
	}
	@Override
	public VrstaProizvoda findOne(Long id) {
		return vrstaProizvodaRepository.getOne(id);
	}

}
