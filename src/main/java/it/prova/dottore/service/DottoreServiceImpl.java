package it.prova.dottore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.prova.dottore.model.Dottore;
import it.prova.dottore.repository.DottoreRepository;

@Service
@Transactional
public class DottoreServiceImpl implements DottoreService{
	
	@Autowired
	private DottoreRepository repository;
	
	@Override
	@Transactional(readOnly = true)
	public List<Dottore> findAll(){
		return (List<Dottore>) repository.findAll();
	}
	@Override
	@Transactional(readOnly = true)
	public Dottore findById(Long id) {
		return repository.findById(null).orElse(null);
	}
	@Override
	@Transactional(readOnly = true)
	public Dottore findByCodice(String codice) {
		return repository.findByCodiceDottore(codice).stream().findFirst().orElse(null);
	}
	@Override
	public Dottore inserisciNuovo(Dottore input) {
		//TODO se l'id non è null lancio eccezione
		return repository.save(null);
	}
	@Override
	public Dottore aggiorna(Dottore input) {
		//TODO se non trovo l'id lancio eccezione
		return repository.save(null);
	}
	@Override
	public void rimuovi(Long id) {
		//TODO se non trovo l'id lancio eccezione
		repository.deleteById(id);
	}
}
