package ftnbusiness.business.proizvod;

import javax.persistence.ManyToOne;

import ftnbusiness.business.grupaProizvoda.GrupaProizvoda;
import ftnbusiness.business.jedinicaMere.JedinicaMere;
import ftnbusiness.business.vrstaProizvoda.VrstaProizvoda;

public class ProizvodDTO {

	private String naziv;

	private GrupaProizvoda grupaProizvoda;
	
	private VrstaProizvoda vrstaProizvoda;
	
	private JedinicaMere jedinicaMere;
	
	private double cena; //cena u aktivnom i narednim cenovnicima
	
	public ProizvodDTO() {
		super();
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

	public double getCena() {
		return cena;
	}

	public void setCena(double cena) {
		this.cena = cena;
	}
	
	
}
