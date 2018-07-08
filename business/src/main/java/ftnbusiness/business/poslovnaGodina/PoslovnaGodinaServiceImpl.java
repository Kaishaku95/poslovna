package ftnbusiness.business.poslovnaGodina;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PoslovnaGodinaServiceImpl implements PoslovnaGodinaService{

	@Autowired
	private PoslovnaGodinaRepository poslovnaRepository;
	@Override
	public Long addPoslovnaGodina(PoslovnaGodina pg) {
		// TODO Auto-generated method stub
		return poslovnaRepository.save(pg).getId();
	}

}
