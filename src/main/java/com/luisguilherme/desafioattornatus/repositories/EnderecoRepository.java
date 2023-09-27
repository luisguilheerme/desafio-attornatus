package com.luisguilherme.desafioattornatus.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.luisguilherme.desafioattornatus.entities.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long>{
	/*
	@Query("SELECT new com.luisguilherme.desafioattornatus.dto.EnderecoDTO(obj.id, obj.logradouro, obj.cep, obj.numero, obj.cidade, obj.pessoa.id) "
			+ "FROM Endereco obj "
			+ "WHERE obj.pessoa.id = :pessoaId ")
	List<Endereco> enderecosPessoa(Long pessoaId);
	*/
	
	List<Endereco> findEnderecoByPessoaId(Long pessoaId);

}
