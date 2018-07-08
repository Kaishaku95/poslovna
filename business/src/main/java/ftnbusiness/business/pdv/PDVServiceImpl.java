package ftnbusiness.business.pdv;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PDVServiceImpl implements PDVService {

	@Autowired
	private PDVRepository pdvRepository;
	@Override
	public Long addPDV(PDV pdv) {
		return pdvRepository.save(pdv).getId();
	}

}
