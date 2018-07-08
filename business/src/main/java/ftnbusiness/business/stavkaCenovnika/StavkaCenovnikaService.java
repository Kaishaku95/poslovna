package ftnbusiness.business.stavkaCenovnika;

import java.util.ArrayList;

import ftnbusiness.business.cenovnik.Cenovnik;
import ftnbusiness.business.proizvod.Proizvod;

public interface StavkaCenovnikaService {

	Long addStavkaCenovnika(StavkaCenovnika sc);

	double findCenaByCenovnikAndProizvod(Cenovnik cn, Proizvod proizvod);

	ArrayList<StavkaCenovnika> findByCenovnik(Cenovnik c);
}
