package ftnbusiness.business.jedinicaMere;

import java.util.List;

public interface JedinicaMereService {

	Long addJedinicaMere(JedinicaMere jm);

	List<JedinicaMere> findAll();

	JedinicaMere findOne(Long id);

	JedinicaMere add(JedinicaMere dto);
}
