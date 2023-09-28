package com.luisguilherme.desafioattornatus.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.luisguilherme.desafioattornatus.dto.EnderecoDTO;
import com.luisguilherme.desafioattornatus.services.EnderecoService;

@RestController
@RequestMapping(value = "/enderecos")
public class EnderecoController {
	
	@Autowired
	private EnderecoService service;
		
	@PostMapping(value = "/{pessoaId}")
	public ResponseEntity<EnderecoDTO> insert(@PathVariable Long pessoaId, @RequestBody EnderecoDTO dto) {
		dto = service.insert(dto, pessoaId);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}

	@GetMapping(value = "/{pessoaId}")
	public ResponseEntity<List<EnderecoDTO>> findAll(@PathVariable Long pessoaId) {
		List<EnderecoDTO> dto = service.findAll(pessoaId);
		return ResponseEntity.ok(dto);
	}
}
