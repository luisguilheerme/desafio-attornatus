package com.luisguilherme.desafioattornatus.factories;

import com.luisguilherme.desafioattornatus.entities.Endereco;
import com.luisguilherme.desafioattornatus.entities.Pessoa;

public class EnderecoFactory {
	
	public static Endereco createEndereco() {
		Pessoa pessoa = PessoaFactory.createPessoa();
		return new Endereco(1L, "Rua Um", "15080000", "123", "Brasilia", pessoa, true );		
	}

}
