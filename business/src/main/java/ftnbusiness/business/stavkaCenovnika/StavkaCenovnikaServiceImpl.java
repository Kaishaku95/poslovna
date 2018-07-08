package ftnbusiness.business.stavkaCenovnika;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StavkaCenovnikaServiceImpl implements StavkaCenovnikaService {

	@Autowired
	private StavkaCenovnikaRepository stavkaCenovnikaRepository;
	@Override
	public Long addStavkaCenovnika(StavkaCenovnika sc) {
		return stavkaCenovnikaRepository.save(sc).getId();
	}

}
