package ftnbusiness.business.stavkaFakture;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import ftnbusiness.business.faktura.Faktura;
import ftnbusiness.business.preduzece.Preduzece;

@Entity
public class StavkaFakture {
	@Id
	@GeneratedValue
	private Long id;

	private int kolicina;
	
	private double rabat;
	
	private double jedinicnaCena;
	
	private double stopaPDV;
	
	private double osnovica;
	
	private double iznosPDV;
	
	private double ukupanIznos;
	
	@ManyToOne
	private Faktura faktura;
	
	@ManyToOne
	private Preduzece preduzece;

	public StavkaFakture(Long id, int kolicina, double rabat, double jedinicnaCena, double stopaPDV, double osnovica,
			double iznosPDV, double ukupanIznos, Faktura faktura, Preduzece preduzece) {
		super();
		this.id = id;
		this.kolicina = kolicina;
		this.rabat = rabat;
		this.jedinicnaCena = jedinicnaCena;
		this.stopaPDV = stopaPDV;
		this.osnovica = osnovica;
		this.iznosPDV = iznosPDV;
		this.ukupanIznos = ukupanIznos;
		this.faktura = faktura;
		this.preduzece = preduzece;
	}

	public StavkaFakture() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getKolicina() {
		return kolicina;
	}

	public void setKolicina(int kolicina) {
		this.kolicina = kolicina;
	}

	public double getRabat() {
		return rabat;
	}

	public void setRabat(double rabat) {
		this.rabat = rabat;
	}

	public double getJedinicnaCena() {
		return jedinicnaCena;
	}

	public void setJedinicnaCena(double jedinicnaCena) {
		this.jedinicnaCena = jedinicnaCena;
	}

	public double getStopaPDV() {
		return stopaPDV;
	}

	public void setStopaPDV(double stopaPDV) {
		this.stopaPDV = stopaPDV;
	}

	public double getOsnovica() {
		return osnovica;
	}

	public void setOsnovica(double osnovica) {
		this.osnovica = osnovica;
	}

	public double getIznosPDV() {
		return iznosPDV;
	}

	public void setIznosPDV(double iznosPDV) {
		this.iznosPDV = iznosPDV;
	}

	public double getUkupanIznos() {
		return ukupanIznos;
	}

	public void setUkupanIznos(double ukupanIznos) {
		this.ukupanIznos = ukupanIznos;
	}

	public Faktura getFaktura() {
		return faktura;
	}

	public void setFaktura(Faktura faktura) {
		this.faktura = faktura;
	}

	public Preduzece getPreduzece() {
		return preduzece;
	}

	public void setPreduzece(Preduzece preduzece) {
		this.preduzece = preduzece;
	}
	
	
}