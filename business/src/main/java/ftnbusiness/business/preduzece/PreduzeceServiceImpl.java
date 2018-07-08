package ftnbusiness.business.preduzece;

import java.util.List;

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

	@Override
	public Preduzece getByName(String naziv) {
		// TODO Auto-generated method stub
		List<Preduzece> preduzeca = preduzeceRepository.findByNaziv(naziv);
		return preduzeca.get(0);
	}
	
	
}
