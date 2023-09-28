package com.luisguilherme.desafioattornatus.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.luisguilherme.desafioattornatus.entities.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long>{
	
	List<Endereco> findEnderecoByPessoaId(Long pessoaId);

    @Query("SELECT obj FROM Endereco obj WHERE obj.pessoa.id = :pessoaId AND obj.enderecoPrincipal = true")
    Endereco findEnderecoPrincipalByPessoaId(Long pessoaId);
}
