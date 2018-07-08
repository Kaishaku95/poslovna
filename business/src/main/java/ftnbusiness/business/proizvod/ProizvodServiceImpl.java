package ftnbusiness.business.proizvod;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProizvodServiceImpl implements ProizvodService {

	@Autowired
	private ProizvodRepository proizvodRepository;
	@Override
	public Long addProizvod(Proizvod pr) {
		return proizvodRepository.save(pr).getId();
	}

}
