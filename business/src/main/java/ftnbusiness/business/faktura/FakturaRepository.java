package ftnbusiness.business.faktura;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ftnbusiness.business.poslovnaGodina.PoslovnaGodina;
import ftnbusiness.business.poslovniPartner.PoslovniPartner;

public interface FakturaRepository extends JpaRepository<Faktura, Long>{

	List<Faktura> findByPoslovniPartner(PoslovniPartner poslovniPartner);
}
