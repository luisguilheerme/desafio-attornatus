package com.luisguilherme.desafioattornatus.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.luisguilherme.desafioattornatus.dto.PessoaDTO;
import com.luisguilherme.desafioattornatus.entities.Pessoa;
import com.luisguilherme.desafioattornatus.factories.PessoaFactory;
import com.luisguilherme.desafioattornatus.repositories.PessoaRepository;

@ExtendWith(SpringExtension.class)
public class PessoaServiceTests {

	@InjectMocks
	private PessoaService service;

	@Mock
	private PessoaRepository repository;

	private long existingId;
	private long nonExistingId;
	private Pessoa pessoa;
	private PessoaDTO pessoaDTO;

	@BeforeEach
	void setUp() throws Exception {
		existingId = 1L;
		nonExistingId = 2L;
		pessoa = PessoaFactory.createPessoa();
		pessoaDTO = new PessoaDTO(pessoa);

	}

}
