package ftnbusiness.business.vrstaProizvoda;

import java.util.List;

public interface VrstaProizvodaService {

	Long addVrstaProizvoda(VrstaProizvoda vp);

	VrstaProizvoda add(VrstaProizvoda dto);

	List<VrstaProizvoda> findAll();

	VrstaProizvoda findOne(Long id);
}
