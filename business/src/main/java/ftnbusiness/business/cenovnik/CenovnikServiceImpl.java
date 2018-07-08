package ftnbusiness.business.cenovnik;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
	@Override
	public List<Cenovnik> findAll() {
		return cenovnikRepository.findAll();
	}
	@Override
	public Cenovnik findOne(Long id) {
		Optional<Cenovnik> c = cenovnikRepository.findById(id);
		return c.get();
	}
	@Override
	public Cenovnik findNewest() {
		ArrayList<Cenovnik> lista = (ArrayList<Cenovnik>) cenovnikRepository.findAll();
		if(lista.isEmpty()) {
			return null;
		}
		Cenovnik c = lista.get(0);
		for(int i = 1; i<lista.size(); i++) {
			if(c.getDatumVazenja()<lista.get(i).getDatumVazenja()) {
				c = lista.get(i);
			}
		}
 		return c;
	}
	

}
