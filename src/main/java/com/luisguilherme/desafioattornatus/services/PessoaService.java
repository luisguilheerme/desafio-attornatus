package com.luisguilherme.desafioattornatus.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luisguilherme.desafioattornatus.dto.PessoaDTO;
import com.luisguilherme.desafioattornatus.entities.Pessoa;
import com.luisguilherme.desafioattornatus.repositories.PessoaRepository;

import jakarta.transaction.Transactional;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository repository;

	@Transactional
	public PessoaDTO insert(PessoaDTO dto) {
		Pessoa entity = new Pessoa();
		entity.setNome(dto.getNome());
		entity.setDataNascimento(dto.getDataNascimento());
		entity = repository.save(entity);
		return new PessoaDTO(entity);
	}

}
