package ftnbusiness.business.poslovnaGodina;

import ftnbusiness.business.preduzece.Preduzece;

public interface PoslovnaGodinaService {

	Long addPoslovnaGodina(PoslovnaGodina pg);

	PoslovnaGodina getNezakljucenaZaPreduzece(Preduzece preduzece);
}
