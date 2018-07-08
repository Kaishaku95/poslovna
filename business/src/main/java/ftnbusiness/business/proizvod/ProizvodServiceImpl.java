package ftnbusiness.business.proizvod;

import java.util.ArrayList;

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
	@Override
	public ArrayList<Proizvod> findAll() {
		// TODO Auto-generated method stub
		return (ArrayList<Proizvod>) proizvodRepository.findAll();
	}

}
