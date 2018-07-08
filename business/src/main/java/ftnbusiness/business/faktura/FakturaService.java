package ftnbusiness.business.faktura;

import java.util.ArrayList;

import ftnbusiness.business.poslovniPartner.PoslovniPartner;
import ftnbusiness.business.stavkaFakture.StavkaFakture;


public interface FakturaService {

	
	ArrayList<Faktura> getFakture();

	Long addFaktura(Faktura novaFaktura);

	Faktura getById(Long id);

	ArrayList<Faktura> getFakture(PoslovniPartner byId);
}
