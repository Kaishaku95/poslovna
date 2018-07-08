package ftnbusiness.business.faktura;

import ftnbusiness.business.proizvod.Proizvod;

public class StavkaFaktureDTO {

	private Proizvod proizvod;
	
	private double cena;
	
	private double stopaPDV;
	
	private double pdv;
	
	private double kolicina;
	
	public StavkaFaktureDTO() {
		super();
	}

	public Proizvod getProizvod() {
		return proizvod;
	}

	public void setProizvod(Proizvod proizvod) {
		this.proizvod = proizvod;
	}

	public double getCena() {
		return cena;
	}

	public void setCena(double cena) {
		this.cena = cena;
	}

	public double getStopaPDV() {
		return stopaPDV;
	}

	public void setStopaPDV(double stopaPDV) {
		this.stopaPDV = stopaPDV;
	}

	public double getPdv() {
		return pdv;
	}

	public void setPdv(double pdv) {
		this.pdv = pdv;
	}

	public double getKolicina() {
		return kolicina;
	}

	public void setKolicina(double kolicina) {
		this.kolicina = kolicina;
	}
	
	
}
