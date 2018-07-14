package ftnbusiness.business.cenovnik;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CenovnikRepository extends JpaRepository<Cenovnik, Long> {

	List<Cenovnik> findByDatumVazenjaGreaterThan(long datumVazenja);
}
