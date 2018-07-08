package ftnbusiness.business.stavkaFakture;

import org.springframework.beans.factory.annotation.Autowired;

public class StavkaFaktureServiceImpl implements StavkaFaktureService{

	@Autowired
	StavkaFaktureRepository stavkaFaktureRepository;
	
	
	@Override
	public Long addStavkaFakture(StavkaFakture stavkaFakture) {
		// TODO Auto-generated method stub
		return stavkaFaktureRepository.save(stavkaFakture).getId();
	}

}
