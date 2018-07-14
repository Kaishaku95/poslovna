package ftnbusiness.business.jedinicaMere;

import java.util.List;

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
	@Override
	public List<JedinicaMere> findAll() {
		return jedinicaMereRepository.findAll();
	}
	@Override
	public JedinicaMere findOne(Long id) {
		return jedinicaMereRepository.getOne(id);
	}
	@Override
	public JedinicaMere add(JedinicaMere dto) {
		return jedinicaMereRepository.save(dto);
	}

}
