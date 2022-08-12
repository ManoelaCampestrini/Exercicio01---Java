package com.exercicioapi.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exercicioapi.entidade.Roupa;
import com.exercicioapi.repository.RoupaRepository;

@RestController
@RequestMapping("/roupa")
public class RoupaController {
	
	@Autowired
	RoupaRepository repo;
	
	@GetMapping
	public ResponseEntity<Iterable<Roupa>> buscarRoupas() {
		Iterable<Roupa> roupas = repo.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(roupas);
	}
	
	@GetMapping("/{idroupa}")
	public ResponseEntity<Roupa> buscarRoupaById(@PathVariable("idroupa") Long idroupa) {
		Optional<Roupa> roupa = repo.findById(idroupa);
		return roupa.isPresent() ? ResponseEntity.ok(roupa.get()) : ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<Roupa> salvarRoupa(@RequestBody Roupa roupa) {
		Roupa rp = repo.save(roupa);
		return ResponseEntity.status(HttpStatus.CREATED).body(rp);
	}
	
	@PutMapping("/{idroupa}")
	public ResponseEntity<Roupa> atualizarRoupa(@PathVariable("idroupa") Long idroupa, @RequestBody Roupa roupa) {
		Optional<Roupa> buscarRoupa = repo.findById(idroupa);
		if(buscarRoupa.isPresent()) {
			roupa.setId(idroupa);
			repo.save(roupa);
			return ResponseEntity.ok(roupa);
		}
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{idroupa}")
	public ResponseEntity<Roupa> deletarRoupa(@PathVariable("idroupa") Long idroupa) {
		Optional<Roupa> buscarRoupa = repo.findById(idroupa);
		if(buscarRoupa.isPresent()) {
			repo.deleteById(idroupa);
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}
}
