package ftnbusiness.business.faktura;

import java.util.ArrayList;


public interface FakturaService {

	
	ArrayList<Faktura> getFakture();

	Long addFaktura(Faktura novaFaktura);

	Faktura getById(Long id);
}
