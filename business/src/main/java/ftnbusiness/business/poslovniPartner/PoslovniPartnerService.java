package ftnbusiness.business.poslovniPartner;

import java.util.ArrayList;

public interface PoslovniPartnerService {

	Long addPoslovniPartner(PoslovniPartner pp);

	PoslovniPartner getById(Long idPoslovnogPartnera);
	
	ArrayList<PoslovniPartner> findAll();
}
