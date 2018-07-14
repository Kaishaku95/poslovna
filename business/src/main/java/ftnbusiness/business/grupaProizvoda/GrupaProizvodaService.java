package ftnbusiness.business.grupaProizvoda;

import java.util.List;

public interface GrupaProizvodaService {

	Long addGrupaProizvoda(GrupaProizvoda gp);
	
	List<GrupaProizvoda> findAll();
}
