package ftnbusiness.business.stopaPDV;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StopaPDVServiceImpl implements StopaPDVService {

	@Autowired
	private StopaPDVRepository stopaPDVRepository;
	@Override
	public Long addStopaPDV(StopaPDV sdpv) {
		return stopaPDVRepository.save(sdpv).getId();
	}

}
