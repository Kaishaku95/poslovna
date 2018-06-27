package ftnbusiness.business.stavkaCenovnika;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import ftnbusiness.business.cenovnik.Cenovnik;
import ftnbusiness.business.proizvod.Proizvod;

@Entity
public class StavkaCenovnika {
	@Id
	@GeneratedValue
	private Long id;
	
	private double cena;
	
	@ManyToOne
	private Proizvod proizvod;
	
	@ManyToOne
	private Cenovnik cenovnik;

	public StavkaCenovnika(Long id, double cena, Proizvod proizvod, Cenovnik cenovnik) {
		super();
		this.id = id;
		this.cena = cena;
		this.proizvod = proizvod;
		this.cenovnik = cenovnik;
	}

	public StavkaCenovnika() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getCena() {
		return cena;
	}

	public void setCena(double cena) {
		this.cena = cena;
	}

	public Proizvod getProizvod() {
		return proizvod;
	}

	public void setProizvod(Proizvod proizvod) {
		this.proizvod = proizvod;
	}

	public Cenovnik getCenovnik() {
		return cenovnik;
	}

	public void setCenovnik(Cenovnik cenovnik) {
		this.cenovnik = cenovnik;
	}
	
	
}
