package com.luisguilherme.desafioattornatus.services;

import static org.mockito.ArgumentMatchers.any;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.luisguilherme.desafioattornatus.dto.EnderecoDTO;
import com.luisguilherme.desafioattornatus.dto.PessoaDTO;
import com.luisguilherme.desafioattornatus.entities.Endereco;
import com.luisguilherme.desafioattornatus.entities.Pessoa;
import com.luisguilherme.desafioattornatus.factories.EnderecoFactory;
import com.luisguilherme.desafioattornatus.factories.PessoaFactory;
import com.luisguilherme.desafioattornatus.repositories.EnderecoRepository;
import com.luisguilherme.desafioattornatus.repositories.PessoaRepository;
import com.luisguilherme.desafioattornatus.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@ExtendWith(SpringExtension.class)
public class EnderecoServiceTests {
	
	@InjectMocks
	private EnderecoService service;

	@Mock
	private EnderecoRepository repository;
	
	@Mock
	private PessoaRepository pessoaRepository;

	private long existingId;
	private long nonExistingId;
	private Endereco endereco;
	private EnderecoDTO enderecoDTO;
	private Pessoa pessoa;
	
	@BeforeEach
	void setUp() throws Exception {
		existingId = 1L;
		nonExistingId = 2L;
		endereco = EnderecoFactory.createEndereco();
		enderecoDTO = new EnderecoDTO(endereco);
		pessoa = PessoaFactory.createPessoa();
		
		Mockito.when(repository.save(any())).thenReturn(endereco);
		Mockito.when(pessoaRepository.save(any())).thenReturn(pessoa);
		Mockito.when(pessoaRepository.getReferenceById(existingId)).thenReturn(pessoa);
		Mockito.when(pessoaRepository.getReferenceById(nonExistingId)).thenThrow(EntityNotFoundException.class);
		
		Mockito.when(repository.findEnderecoByPessoaId(existingId)).thenReturn(List.of(endereco));
		
		Mockito.when(pessoaRepository.findById(existingId)).thenReturn(Optional.of(pessoa));
		Mockito.when(pessoaRepository.findById(nonExistingId)).thenReturn(Optional.empty());
		
		Mockito.when(repository.findEnderecoPrincipalByPessoaId(existingId)).thenReturn(endereco);
		Mockito.when(repository.findEnderecoPrincipalByPessoaId(nonExistingId)).thenThrow(EntityNotFoundException.class);
	}
	
	@Test
	public void insertShouldReturnEnderecoDTO() {
		
		EnderecoDTO result = service.insert(enderecoDTO, pessoa.getId());
		System.out.println(result.getCidade() + result.getId());
		Assertions.assertNotNull(result);
		Assertions.assertEquals(result.getId(), endereco.getId());		
	}
	
	@Test
	public void findAllShouldReturnListofEnderecoDTOWhenPessoaIdExists() {		
		
		List<EnderecoDTO> result = service.findAll(existingId);
		
		Assertions.assertNotNull(result);
		Assertions.assertEquals(List.of(enderecoDTO), result);
	}

	@Test
	public void findAllShouldReturnResourceNotFoundExceptionWhenIdDoesNotExists() {		
		
		Assertions.assertThrows(ResourceNotFoundException.class, () -> {
			service.findAll(nonExistingId);
		});
	}
	
	@Test
	public void findEnderecoPrincipalShouldReturnEnderecoDTOWhenPessoaIdExists() {		
		
		EnderecoDTO result = service.findEnderecoPrincipal(existingId);
		
		Assertions.assertNotNull(result);
		Assertions.assertEquals(result.getId(), existingId);
	}

	@Test
	public void findEnderecoPrincipalShouldReturnResourceNotFoundExceptionWhenIdDoesNotExists() {		
		
		Assertions.assertThrows(ResourceNotFoundException.class, () -> {
			service.findAll(nonExistingId);
		});
	}
}
