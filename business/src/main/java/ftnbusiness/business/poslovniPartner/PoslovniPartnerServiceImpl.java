package ftnbusiness.business.poslovniPartner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PoslovniPartnerServiceImpl implements PoslovniPartnerService{

	@Autowired
	private PoslovniPartnerRepository poslovniPartnerRepository;
	@Override
	public Long addPoslovniPartner(PoslovniPartner pp) {
		return poslovniPartnerRepository.save(pp).getId();
	}

}
