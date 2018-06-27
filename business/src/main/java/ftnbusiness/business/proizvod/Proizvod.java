package ftnbusiness.business.proizvod;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import ftnbusiness.business.grupaProizvoda.GrupaProizvoda;
import ftnbusiness.business.jedinicaMere.JedinicaMere;
import ftnbusiness.business.preduzece.Preduzece;
import ftnbusiness.business.vrstaProizvoda.VrstaProizvoda;

@Entity
public class Proizvod {
	@Id
	@GeneratedValue
	private Long id;
	
	private String naziv;

	@ManyToOne
	private GrupaProizvoda grupaProizvoda;
	
	@ManyToOne
	private VrstaProizvoda vrstaProizvoda;
	
	@ManyToOne
	private JedinicaMere jedinicaMere;
	
	@ManyToOne
	private Preduzece preduzece;
	
	public Proizvod(Long id, String naziv, GrupaProizvoda grupaProizvoda, VrstaProizvoda vrstaProizvoda, JedinicaMere jedinicaMere, Preduzece preduzece) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.grupaProizvoda = grupaProizvoda;
		this.vrstaProizvoda = vrstaProizvoda;
		this.jedinicaMere = jedinicaMere;
		this.preduzece = preduzece;
	}

	public Proizvod() {
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

	public GrupaProizvoda getGrupaProizvoda() {
		return grupaProizvoda;
	}

	public void setGrupaProizvoda(GrupaProizvoda grupaProizvoda) {
		this.grupaProizvoda = grupaProizvoda;
	}

	public VrstaProizvoda getVrstaProizvoda() {
		return vrstaProizvoda;
	}

	public void setVrstaProizvoda(VrstaProizvoda vrstaProizvoda) {
		this.vrstaProizvoda = vrstaProizvoda;
	}

	public JedinicaMere getJedinicaMere() {
		return jedinicaMere;
	}

	public void setJedinicaMere(JedinicaMere jedinicaMere) {
		this.jedinicaMere = jedinicaMere;
	}

	public Preduzece getPreduzece() {
		return preduzece;
	}

	public void setPreduzece(Preduzece preduzece) {
		this.preduzece = preduzece;
	}
	
	
	
}
