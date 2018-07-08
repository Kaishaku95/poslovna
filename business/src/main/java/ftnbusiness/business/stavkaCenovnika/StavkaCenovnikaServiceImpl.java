package ftnbusiness.business.stavkaCenovnika;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ftnbusiness.business.cenovnik.Cenovnik;
import ftnbusiness.business.proizvod.Proizvod;

@Service
public class StavkaCenovnikaServiceImpl implements StavkaCenovnikaService {

	@Autowired
	private StavkaCenovnikaRepository stavkaCenovnikaRepository;
	@Override
	public Long addStavkaCenovnika(StavkaCenovnika sc) {
		return stavkaCenovnikaRepository.save(sc).getId();
	}
	@Override
	public double findCenaByCenovnikAndProizvod(Cenovnik cn, Proizvod proizvod) {
		return stavkaCenovnikaRepository.findByCenovnikAndProizvod(cn, proizvod).getCena();
	}

}
