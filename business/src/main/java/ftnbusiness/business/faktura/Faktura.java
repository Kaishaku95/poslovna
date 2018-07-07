package ftnbusiness.business.faktura;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import ftnbusiness.business.poslovnaGodina.PoslovnaGodina;
import ftnbusiness.business.poslovniPartner.PoslovniPartner;
import ftnbusiness.business.preduzece.Preduzece;

@Entity
@XmlRootElement(name="faktura")
@XmlAccessorType(XmlAccessType.FIELD)
public class Faktura {
	@Id
	@GeneratedValue
	private Long id;
	
	private String brojFakture;
	
	private long datumFakture;
	
	private long datumValute;
	
	private double ukupanRabat;
	
	private double ukupanIznosBezPDV;
	
	private double ukupanPDV;
	
	private double ukupnoZaPlacanje;
	
	@ManyToOne
	private PoslovniPartner poslovniPartner;
	
	@ManyToOne
	private Preduzece preduzece;
	
	@ManyToOne
	private PoslovnaGodina poslovnaGodina;

	public Faktura(Long id, String brojFakture, long datumFakture, long datumValute, double ukupanRabat,
			double ukupanIznosBezPDV, double ukupanPDV, double ukupnoZaPlacanje, PoslovniPartner poslovniPartner,
			Preduzece preduzece, PoslovnaGodina poslovnaGodina) {
		super();
		this.id = id;
		this.brojFakture = brojFakture;
		this.datumFakture = datumFakture;
		this.datumValute = datumValute;
		this.ukupanRabat = ukupanRabat;
		this.ukupanIznosBezPDV = ukupanIznosBezPDV;
		this.ukupanPDV = ukupanPDV;
		this.ukupnoZaPlacanje = ukupnoZaPlacanje;
		this.poslovniPartner = poslovniPartner;
		this.preduzece = preduzece;
		this.poslovnaGodina = poslovnaGodina;
	}

	public Faktura() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBrojFakture() {
		return brojFakture;
	}

	public void setBrojFakture(String brojFakture) {
		this.brojFakture = brojFakture;
	}

	public long getDatumFakture() {
		return datumFakture;
	}

	public void setDatumFakture(long datumFakture) {
		this.datumFakture = datumFakture;
	}

	public long getDatumValute() {
		return datumValute;
	}

	public void setDatumValute(long datumValute) {
		this.datumValute = datumValute;
	}

	public double getUkupanRabat() {
		return ukupanRabat;
	}

	public void setUkupanRabat(double ukupanRabat) {
		this.ukupanRabat = ukupanRabat;
	}

	public double getUkupanIznosBezPDV() {
		return ukupanIznosBezPDV;
	}

	public void setUkupanIznosBezPDV(double ukupanIznosBezPDV) {
		this.ukupanIznosBezPDV = ukupanIznosBezPDV;
	}

	public double getUkupanPDV() {
		return ukupanPDV;
	}

	public void setUkupanPDV(double ukupanPDV) {
		this.ukupanPDV = ukupanPDV;
	}

	public double getUkupnoZaPlacanje() {
		return ukupnoZaPlacanje;
	}

	public void setUkupnoZaPlacanje(double ukupnoZaPlacanje) {
		this.ukupnoZaPlacanje = ukupnoZaPlacanje;
	}

	public PoslovniPartner getPoslovniPartner() {
		return poslovniPartner;
	}

	public void setPoslovniPartner(PoslovniPartner poslovniPartner) {
		this.poslovniPartner = poslovniPartner;
	}

	public Preduzece getPreduzece() {
		return preduzece;
	}

	public void setPreduzece(Preduzece preduzece) {
		this.preduzece = preduzece;
	}

	public PoslovnaGodina getPoslovnaGodina() {
		return poslovnaGodina;
	}

	public void setPoslovnaGodina(PoslovnaGodina poslovnaGodina) {
		this.poslovnaGodina = poslovnaGodina;
	}
	
	
	public Faktura(NarudzbenicaDTO narudzbenicaDTO)
	{
		
	}
}
