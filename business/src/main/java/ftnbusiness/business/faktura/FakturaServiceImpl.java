package ftnbusiness.business.faktura;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FakturaServiceImpl implements FakturaService{

	@Autowired
	FakturaRepository fakturaRepository;
	
	
	@Override
	public ArrayList<Faktura> getFakture() {
		// TODO Auto-generated method stub
		return (ArrayList<Faktura>) fakturaRepository.findAll();
	}


	@Override
	public Long addFaktura(Faktura novaFaktura) {
		// TODO Auto-generated method stub
		return fakturaRepository.save(novaFaktura).getId();
	}


	@Override
	public Faktura getById(Long id) {
		// TODO Auto-generated method stub
		Optional<Faktura> faktura = fakturaRepository.findById(id);
		return faktura.get();
	}

}
