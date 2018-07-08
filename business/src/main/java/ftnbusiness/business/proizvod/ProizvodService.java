package ftnbusiness.business.proizvod;

import java.util.ArrayList;

public interface ProizvodService {

	Long addProizvod(Proizvod pr);

	ArrayList<Proizvod> findAll();
}
