package ftnbusiness.business.proizvod;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ftnbusiness.business.faktura.Faktura;

@Service
public class ProizvodServiceImpl implements ProizvodService {

	@Autowired
	private ProizvodRepository proizvodRepository;
	@Override
	public Long addProizvod(Proizvod pr) {
		return proizvodRepository.save(pr).getId();
	}
	@Override
	public Proizvod getById(Long id) {
		// TODO Auto-generated method stub
		Optional<Proizvod> proizvod = proizvodRepository.findById(id);
		return proizvod.get();
	}

}
