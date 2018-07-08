package ftnbusiness.business.poslovnaGodina;

import java.util.ArrayList;

import ftnbusiness.business.preduzece.Preduzece;

public interface PoslovnaGodinaService {

	Long addPoslovnaGodina(PoslovnaGodina pg);

	PoslovnaGodina getNezakljucenaZaPreduzece(Preduzece preduzece);

	PoslovnaGodina findOne(Long id);

	ArrayList<PoslovnaGodina> findAll();
}
