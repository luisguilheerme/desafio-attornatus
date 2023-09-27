package com.luisguilherme.desafioattornatus.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luisguilherme.desafioattornatus.dto.EnderecoDTO;
import com.luisguilherme.desafioattornatus.entities.Endereco;
import com.luisguilherme.desafioattornatus.repositories.EnderecoRepository;
import com.luisguilherme.desafioattornatus.repositories.PessoaRepository;

@Service
public class EnderecoService {

	@Autowired
	private EnderecoRepository repository;
	
	@Autowired
	private PessoaRepository pessoaRepository;

	public EnderecoDTO insert(EnderecoDTO dto) {

		Endereco entity = new Endereco();
		entity.setLogradouro(dto.getLogradouro());
		entity.setCep(dto.getCep());
		entity.setNumero(dto.getNumero());
		entity.setCidade(dto.getCidade());
		entity.setPessoa(dto.getPessoa());
		entity.setEnderecoPrincipal(dto.isEnderecoPrincipal());		

		List<Endereco> enderecos = entity.getPessoa().getEnderecos();

		if (entity.isEnderecoPrincipal()) {
			enderecos.forEach(e -> e.setEnderecoPrincipal(false));
			entity.setEnderecoPrincipal(true);
		}
		
		enderecos.add(entity);
		entity = repository.save(entity);
		pessoaRepository.save(entity.getPessoa());
		return new EnderecoDTO(entity);
	}
}
