package ftnbusiness.business.poslovnaGodina;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ftnbusiness.business.preduzece.Preduzece;

@Service
public class PoslovnaGodinaServiceImpl implements PoslovnaGodinaService{

	@Autowired
	private PoslovnaGodinaRepository poslovnaRepository;
	@Override
	public Long addPoslovnaGodina(PoslovnaGodina pg) {
		// TODO Auto-generated method stub
		return poslovnaRepository.save(pg).getId();
	}
	@Override
	public PoslovnaGodina getNezakljucenaZaPreduzece(Preduzece preduzece) {
		// TODO Auto-generated method stub
		List<PoslovnaGodina> poslovneGodine = poslovnaRepository.findByPreduzece(preduzece);
		for (PoslovnaGodina poslovnaGodina : poslovneGodine) 
		{
			if(!poslovnaGodina.isZakljucena())
			{
				return poslovnaGodina;
			}
		}
		return null;
	}

}
