package com.luisguilherme.desafioattornatus.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.luisguilherme.desafioattornatus.entities.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}