package ftnbusiness.business.poslovniPartner;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PoslovniPartnerRepository extends JpaRepository<PoslovniPartner, Long> {

	ArrayList<PoslovniPartner> findByTipPoslovnogPartnera_NazivContaining(String naziv);
}
