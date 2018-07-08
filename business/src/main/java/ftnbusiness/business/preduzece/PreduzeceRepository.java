package ftnbusiness.business.preduzece;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PreduzeceRepository extends JpaRepository<Preduzece, Long> {

	List<Preduzece> findByNaziv(String place);
}
