package ftnbusiness.business.poslovnaGodina;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
	@Override
	public PoslovnaGodina findOne(Long id) {
		// TODO Auto-generated method stub
		Optional<PoslovnaGodina> opt = poslovnaRepository.findById(id);
		return opt.get();
	}
	@Override
	public ArrayList<PoslovnaGodina> findAll() {
		// TODO Auto-generated method stub
		return (ArrayList<PoslovnaGodina>) poslovnaRepository.findAll();
	}

}
