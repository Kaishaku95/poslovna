package ftnbusiness.business.poslovnaGodina;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ftnbusiness.business.preduzece.Preduzece;

public interface PoslovnaGodinaRepository extends JpaRepository<PoslovnaGodina, Long> {

	List<PoslovnaGodina> findByPreduzece(Preduzece preduzece);
}
