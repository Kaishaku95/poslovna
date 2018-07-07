package ftnbusiness.business.jedinicaMere;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class JedinicaMere {
	@Id
	@GeneratedValue
	private Long id;
	
	private String naziv;
	
	private String skracenica;

	public JedinicaMere(Long id, String naziv, String skracenica) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.skracenica = skracenica;
	}

	public JedinicaMere() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getSkracenica() {
		return skracenica;
	}

	public void setSkracenica(String skracenica) {
		this.skracenica = skracenica;
	}
	
	
}
