package com.matricula.ORM.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.matricula.ORM.entity.Plano;
import com.matricula.ORM.service.PlanoService;

@RestController
@RequestMapping("planos")
public class PlanoRestController {

	//Essa notação está injetando a Classe PlanoService
	@Autowired
	private PlanoService planoService;

	//mapeamento dos métodos HTTP
	@GetMapping
	public ResponseEntity<Iterable<Plano>> buscarTodos() {
		return ResponseEntity.ok(planoService.buscarTodos());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Plano> buscarPorId(@PathVariable Long id) {
		return ResponseEntity.ok(planoService.buscarPorId(id));
	}

	@PostMapping
	public ResponseEntity<Plano> inserir(@RequestBody Plano plano) {
		planoService.inserir(plano);
		return ResponseEntity.ok(plano);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Plano> atualizar(@PathVariable Long id, @RequestBody Plano plano) {
		planoService.atualizar(id, plano);
		return ResponseEntity.ok(plano);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id) {
		planoService.deletar(id);
		return ResponseEntity.ok().build();
	}
}