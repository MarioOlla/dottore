package it.prova.dottore.controller.api;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import it.prova.dottore.dto.DottoreDTO;
import it.prova.dottore.service.DottoreService;

@RestController
@RequestMapping("/api/dottore")
public class DottoreController {
	
	@Autowired
	private DottoreService service;
	
	@GetMapping
	public List<DottoreDTO> listAll(){
		return service.findAll().stream()
				.map(dottore -> DottoreDTO.buildDTOFromDottoreModel(dottore))
				.collect(Collectors.toList());
	}
	
	@GetMapping("/{id}")
	public DottoreDTO findById(@PathVariable(name = "id", required = true) Long id) {
		return DottoreDTO.buildDTORidottoFromDottoreModel(service.findById(id));
	}
	
	@GetMapping("/findByCodice/{codiceDottore}")
	public DottoreDTO findByCOdiceDottore(@PathVariable(name = "codiceDottore",required = true) String codiceDottore) {
		return DottoreDTO.buildDTORidottoFromDottoreModel(service.findByCodice(codiceDottore));
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public DottoreDTO inserisciNuovo(@RequestBody DottoreDTO input ) {
		return DottoreDTO.buildDTORidottoFromDottoreModel(service.inserisciNuovo(input.buildDottoreModel()));
	}
	
	@PutMapping
	public DottoreDTO aggiorna (@RequestBody DottoreDTO input) {
		return DottoreDTO.buildDTORidottoFromDottoreModel(service.aggiorna(input.buildDottoreModel()));
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void rimuovi(@PathVariable(name = "id", required = true) Long id) {
		service.rimuovi(id);
	}
	
}
