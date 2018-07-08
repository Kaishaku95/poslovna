package ftnbusiness.business.preduzece;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PreduzeceServiceImpl implements PreduzeceService{

	@Autowired
	private PreduzeceRepository preduzeceRepository;

	@Override
	public Long addPreduzece(Preduzece p) {
		return preduzeceRepository.save(p).getId();
	}
	
	
}
