package it.prova.dottore.service;

import java.util.List;

import it.prova.dottore.model.Dottore;

public interface DottoreService {

	List<Dottore> findAll();

	Dottore findById(Long id);

	Dottore findByCodice(String codice);

	void inserisciNuovo(Dottore input);

	void aggiorna(Dottore input);

	void rimuovi(Long id);

}
