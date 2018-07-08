package ftnbusiness.business.cenovnik;

import java.util.List;

public class CenovnikDTO {

	private Long datum;
	
	private List<StavkaCenovnikaDTO> stavke;
	
	public CenovnikDTO() {
		super();
	}

	public Long getDatum() {
		return datum;
	}

	public void setDatum(Long datum) {
		this.datum = datum;
	}

	public List<StavkaCenovnikaDTO> getStavke() {
		return stavke;
	}

	public void setStavke(List<StavkaCenovnikaDTO> stavke) {
		this.stavke = stavke;
	}
	
	
}
