package ftnbusiness.business.poslovniPartner;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import ftnbusiness.business.preduzece.Preduzece;
import ftnbusiness.business.tipPoslovnogPartnera.TipPoslovnogPartnera;

@Entity
public class PoslovniPartner {
	@Id
	@GeneratedValue
	private Long id;

	private String naziv;
	
	private String adresa;
	
	private String kontakt;
	
	@ManyToOne
	private TipPoslovnogPartnera tipPoslovnogPartnera;
	
	@ManyToOne
	private Preduzece preduzece;

	public PoslovniPartner(Long id, String naziv, String adresa, String kontakt,
			TipPoslovnogPartnera tipPoslovnogPartnera, Preduzece preduzece) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.adresa = adresa;
		this.kontakt = kontakt;
		this.tipPoslovnogPartnera = tipPoslovnogPartnera;
		this.preduzece = preduzece;
	}

	public PoslovniPartner() {
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

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public String getKontakt() {
		return kontakt;
	}

	public void setKontakt(String kontakt) {
		this.kontakt = kontakt;
	}

	public TipPoslovnogPartnera getTipPoslovnogPartnera() {
		return tipPoslovnogPartnera;
	}

	public void setTipPoslovnogPartnera(TipPoslovnogPartnera tipPoslovnogPartnera) {
		this.tipPoslovnogPartnera = tipPoslovnogPartnera;
	}

	public Preduzece getPreduzece() {
		return preduzece;
	}

	public void setPreduzece(Preduzece preduzece) {
		this.preduzece = preduzece;
	}
	
	
}
