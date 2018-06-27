package ftnbusiness.business.stopaPDV;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import ftnbusiness.business.pdv.PDV;

@Entity
public class StopaPDV {
	
	@Id
	@GeneratedValue
	private Long id;
	
	
	private double stopa;
	
	private Long datumVazenja;
	
	@ManyToOne
	private PDV pdv;

	
	public PDV getPdv() {
		return pdv;
	}

	public void setPdv(PDV pdv) {
		this.pdv = pdv;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getStopa() {
		return stopa;
	}

	public void setStopa(double stopa) {
		this.stopa = stopa;
	}

	public Long getDatumVazenja() {
		return datumVazenja;
	}

	public void setDatumVazenja(Long datumVazenja) {
		this.datumVazenja = datumVazenja;
	}

	

	public StopaPDV(Long id, double stopa, Long datumVazenja, PDV pdv) {
		super();
		this.id = id;
		this.stopa = stopa;
		this.datumVazenja = datumVazenja;
		this.pdv = pdv;
	}

	public StopaPDV() {
		super();
	}
	
	

}
