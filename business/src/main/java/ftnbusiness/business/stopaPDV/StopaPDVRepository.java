package ftnbusiness.business.stopaPDV;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ftnbusiness.business.pdv.PDV;

public interface StopaPDVRepository extends JpaRepository<StopaPDV, Long> {

	List<StopaPDV> findByPdv(PDV pdv);
}
