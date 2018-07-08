package ftnbusiness.business.stopaPDV;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ftnbusiness.business.pdv.PDV;

@Service
public class StopaPDVServiceImpl implements StopaPDVService {

	@Autowired
	private StopaPDVRepository stopaPDVRepository;
	@Override
	public Long addStopaPDV(StopaPDV sdpv) {
		return stopaPDVRepository.save(sdpv).getId();
	}
	@Override
	public double findNewestByPDV(PDV pdv) {
		ArrayList<StopaPDV> spdvs = (ArrayList<StopaPDV>) stopaPDVRepository.findByPdv(pdv);
		if(spdvs.isEmpty()) {
			return -1;
		}
		StopaPDV spdv = spdvs.get(0);
		for(int i = 1; i<spdvs.size(); i++) {
			if(spdv.getDatumVazenja()<spdvs.get(i).getDatumVazenja()) {
				spdv = spdvs.get(i);
			}
		}
		return spdv.getStopa();
	}

}
