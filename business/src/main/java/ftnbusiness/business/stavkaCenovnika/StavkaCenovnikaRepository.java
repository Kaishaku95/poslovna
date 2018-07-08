package ftnbusiness.business.stavkaCenovnika;

import org.springframework.data.jpa.repository.JpaRepository;

import ftnbusiness.business.cenovnik.Cenovnik;
import ftnbusiness.business.proizvod.Proizvod;

public interface StavkaCenovnikaRepository extends JpaRepository<StavkaCenovnika, Long> {

	StavkaCenovnika findByCenovnikAndProizvod(Cenovnik cenovnik, Proizvod proizvod);
}
