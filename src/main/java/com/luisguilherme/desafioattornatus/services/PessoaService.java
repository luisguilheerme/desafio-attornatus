package com.luisguilherme.desafioattornatus.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luisguilherme.desafioattornatus.dto.PessoaDTO;
import com.luisguilherme.desafioattornatus.entities.Pessoa;
import com.luisguilherme.desafioattornatus.repositories.PessoaRepository;
import com.luisguilherme.desafioattornatus.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository repository;

	@Transactional
	public PessoaDTO insert(PessoaDTO dto) {
		Pessoa entity = new Pessoa();
		copyDtoToEntity(dto,entity);
		entity = repository.save(entity);
		return new PessoaDTO(entity);
	}
	
	@Transactional
	public PessoaDTO update(Long id, PessoaDTO dto) {	
		try {
			Pessoa entity = repository.getReferenceById(id);		
			copyDtoToEntity(dto,entity);
			entity = repository.save(entity);		
			return new PessoaDTO(entity);
		}
		catch(EntityNotFoundException e){
			throw new ResourceNotFoundException("Recurso não encontrado");
		}
	}
	
	private void copyDtoToEntity(PessoaDTO dto, Pessoa entity) {
		entity.setNome(dto.getNome());
		entity.setDataNascimento(dto.getDataNascimento());
	}

}
