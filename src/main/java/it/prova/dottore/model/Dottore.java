package it.prova.dottore.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "dottore")
public class Dottore {
	
	private Long id;
	
	private String nome;
	
	private String cognome;
	
	private String codiceDottore;
	
	private String codFiscalePazienteAttualmenteInVisita;
	
	private Boolean inVisita;
	
	private Boolean inServizio;

}
