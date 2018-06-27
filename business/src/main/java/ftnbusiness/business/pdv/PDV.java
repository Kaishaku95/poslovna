package ftnbusiness.business.pdv;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class PDV {

	@Id
	@GeneratedValue
	private Long id;
	
	private String naziv;

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

	public PDV(Long id, String naziv) {
		super();
		this.id = id;
		this.naziv = naziv;
	}

	public PDV() {
		super();
	}

	
	
	
	
	
}
