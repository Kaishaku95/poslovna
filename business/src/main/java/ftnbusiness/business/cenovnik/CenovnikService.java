package ftnbusiness.business.cenovnik;

import java.util.List;

public interface CenovnikService {

	Long addCenovnik(Cenovnik c);
	
	List<Cenovnik> findAll();
	
	Cenovnik findOne(Long id);
	
	Cenovnik findNewest();

	Cenovnik findActive(long currentTimeMillis);
}
