package ftnbusiness.business.poslovnaGodina;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import ftnbusiness.business.preduzece.Preduzece;

@Entity
public class PoslovnaGodina {
	@Id
	@GeneratedValue
	private Long id;
	
	private int godina; //?
	
	private boolean zakljucena;
	
	@ManyToOne
	private Preduzece preduzece;

	public PoslovnaGodina(Long id, int godina, boolean zakljucena, Preduzece preduzece) {
		super();
		this.id = id;
		this.godina = godina;
		this.zakljucena = zakljucena;
		this.preduzece = preduzece;
	}

	public PoslovnaGodina() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getGodina() {
		return godina;
	}

	public void setGodina(int godina) {
		this.godina = godina;
	}

	public boolean isZakljucena() {
		return zakljucena;
	}

	public void setZakljucena(boolean zakljucena) {
		this.zakljucena = zakljucena;
	}

	public Preduzece getPreduzece() {
		return preduzece;
	}

	public void setPreduzece(Preduzece preduzece) {
		this.preduzece = preduzece;
	}
	
	
	
}
