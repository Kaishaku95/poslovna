package ftnbusiness.business.cenovnik;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity

public class Cenovnik {
	@Id
	@GeneratedValue
	private Long id;
	
	private Long datumVazenja;

	public Cenovnik(Long id, Long datumVazenja) {
		super();
		this.id = id;
		this.datumVazenja = datumVazenja;
	}

	public Cenovnik() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getDatumVazenja() {
		return datumVazenja;
	}

	public void setDatumVazenja(Long datumVazenja) {
		this.datumVazenja = datumVazenja;
	}
	
	
}
