package ftnbusiness.business.cenovnik;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service 
public class CenovnikServiceImpl implements CenovnikService{

	@Autowired
	private CenovnikRepository cenovnikRepository;
	@Override
	public Long addCenovnik(Cenovnik c) {
		return cenovnikRepository.save(c).getId();
	}

}
