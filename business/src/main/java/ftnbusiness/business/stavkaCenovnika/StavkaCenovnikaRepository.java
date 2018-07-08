package ftnbusiness.business.stavkaCenovnika;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ftnbusiness.business.cenovnik.Cenovnik;
import ftnbusiness.business.proizvod.Proizvod;

public interface StavkaCenovnikaRepository extends JpaRepository<StavkaCenovnika, Long> {

	List<StavkaCenovnika> findByCenovnikAndProizvod(Cenovnik cenovnik, Proizvod proizvod);

	List<StavkaCenovnika> findByCenovnik(Cenovnik c);
}
