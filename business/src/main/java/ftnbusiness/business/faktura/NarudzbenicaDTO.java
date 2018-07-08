package ftnbusiness.business.faktura;

import java.util.ArrayList;

public class NarudzbenicaDTO {

	private ArrayList<StavkaFaktureDTO> stavke;
	
	private Long idPoslovnogPartnera;

	public ArrayList<StavkaFaktureDTO> getStavke() {
		return stavke;
	}

	public void setStavke(ArrayList<StavkaFaktureDTO> stavke) {
		this.stavke = stavke;
	}

	public Long getIdPoslovnogPartnera() {
		return idPoslovnogPartnera;
	}

	public void setIdPoslovnogPartnera(Long idPoslovnogPartnera) {
		this.idPoslovnogPartnera = idPoslovnogPartnera;
	}

	public NarudzbenicaDTO(ArrayList<StavkaFaktureDTO> stavke, Long idPoslovnogPartnera) {
		super();
		this.stavke = stavke;
		this.idPoslovnogPartnera = idPoslovnogPartnera;
	}
	
	
	
	
	
	

}
