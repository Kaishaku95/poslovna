package ftnbusiness.business.poslovniPartner;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ftnbusiness.business.faktura.Faktura;

@Service
public class PoslovniPartnerServiceImpl implements PoslovniPartnerService{

	@Autowired
	private PoslovniPartnerRepository poslovniPartnerRepository;
	@Override
	public Long addPoslovniPartner(PoslovniPartner pp) {
		return poslovniPartnerRepository.save(pp).getId();
	}
	@Override
	public PoslovniPartner getById(Long id) {
		// TODO Auto-generated method stub
		Optional<PoslovniPartner> poslovniPartner = poslovniPartnerRepository.findById(id);
		return poslovniPartner.get();
		
	}

}
