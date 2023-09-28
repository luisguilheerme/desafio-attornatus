package com.luisguilherme.desafioattornatus.factories;

import java.time.Instant;

import com.luisguilherme.desafioattornatus.dto.PessoaDTO;
import com.luisguilherme.desafioattornatus.entities.Pessoa;

public class PessoaFactory {
	
	public static Pessoa createPessoa() {
		Pessoa pessoa = new Pessoa(1L, "Maria", Instant.parse("2001-07-25T00:00:00Z"));
		return pessoa;
	}
	
	public static PessoaDTO createPessoaDTO() {
		Pessoa pessoa = createPessoa();
		return new PessoaDTO(pessoa);
	}

}
