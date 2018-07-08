package ftnbusiness.business.stopaPDV;

import ftnbusiness.business.pdv.PDV;

public interface StopaPDVService {
	
	Long addStopaPDV(StopaPDV sdpv);

	double findNewestByPDV(PDV pdv);

}
