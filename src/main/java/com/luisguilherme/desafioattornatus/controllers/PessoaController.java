package com.luisguilherme.desafioattornatus.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.luisguilherme.desafioattornatus.dto.PessoaDTO;
import com.luisguilherme.desafioattornatus.services.PessoaService;

@RestController
@RequestMapping(value = "/pessoas")
public class PessoaController {

	@Autowired
	private PessoaService service;

	@PostMapping
	public ResponseEntity<PessoaDTO> insert(@RequestBody PessoaDTO dto) {
		dto = service.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<PessoaDTO> update(@PathVariable Long id, @RequestBody PessoaDTO dto) {
		dto = service.update(id, dto);
		return ResponseEntity.ok(dto);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<PessoaDTO> findById(@PathVariable Long id) {
		PessoaDTO dto = service.findById(id);
		return ResponseEntity.ok(dto);
	}
}
