package ftnbusiness.business.jedinicaMere;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JedinicaMereServiceImpl implements JedinicaMereService{

	@Autowired
	private JedinicaMereRepository jedinicaMereRepository;
	@Override
	public Long addJedinicaMere(JedinicaMere jm) {
		return jedinicaMereRepository.save(jm).getId();
	}

}
