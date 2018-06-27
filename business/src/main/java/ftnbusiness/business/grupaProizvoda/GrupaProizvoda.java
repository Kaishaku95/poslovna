package ftnbusiness.business.grupaProizvoda;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import ftnbusiness.business.pdv.PDV;

@Entity
public class GrupaProizvoda {

	@Id
	@GeneratedValue
	private Long id;
	
	
	private String nazivGrupe;
	
	@ManyToOne
	private PDV pdv;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNazivGrupe() {
		return nazivGrupe;
	}

	public void setNazivGrupe(String nazivGrupe) {
		this.nazivGrupe = nazivGrupe;
	}

	public PDV getPdv() {
		return pdv;
	}

	public void setPdv(PDV pdv) {
		this.pdv = pdv;
	}

	public GrupaProizvoda(Long id, String nazivGrupe, PDV pdv) {
		super();
		this.id = id;
		this.nazivGrupe = nazivGrupe;
		this.pdv = pdv;
	}

	public GrupaProizvoda() {
		super();
	}
	
	
}
