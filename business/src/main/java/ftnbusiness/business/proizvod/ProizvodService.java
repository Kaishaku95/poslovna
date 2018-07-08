package ftnbusiness.business.proizvod;
import java.util.ArrayList;

public interface ProizvodService {

	Long addProizvod(Proizvod pr);

	Proizvod getById(Long id);
	ArrayList<Proizvod> findAll();
}
