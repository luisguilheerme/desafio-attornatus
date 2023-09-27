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

import com.luisguilherme.desafioattornatus.dto.PessoaDTO;
import com.luisguilherme.desafioattornatus.entities.Pessoa;
import com.luisguilherme.desafioattornatus.factories.PessoaFactory;
import com.luisguilherme.desafioattornatus.repositories.PessoaRepository;
import com.luisguilherme.desafioattornatus.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

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
		
		Mockito.when(repository.save(any())).thenReturn(pessoa);
		
		Mockito.when(repository.getReferenceById(existingId)).thenReturn(pessoa);
		Mockito.when(repository.getReferenceById(nonExistingId)).thenThrow(EntityNotFoundException.class);
		
		Mockito.when(repository.findById(existingId)).thenReturn(Optional.of(pessoa));
		Mockito.when(repository.findById(nonExistingId)).thenReturn(Optional.empty());
		
		Mockito.when(repository.findAll()).thenReturn(List.of(pessoa));
	}
	
	@Test
	public void insertShouldReturnPessoaDTO() {
		
		PessoaDTO result = service.insert(pessoaDTO);
		
		Assertions.assertNotNull(result);
		Assertions.assertEquals(result.getId(), pessoa.getId());		
	}
	
	@Test
	public void updateShouldReturnPessoaDTOWhenIdExists() {
		
		PessoaDTO result = service.update(existingId, pessoaDTO);
		
		Assertions.assertNotNull(result);
		Assertions.assertEquals(result.getId(), existingId);	
		Assertions.assertEquals(result.getNome(), pessoaDTO.getNome());
	}

	@Test
	public void findByIdShouldReturnPessoaDTOWhenIdExists() {
		
		PessoaDTO result = service.findById(existingId);
		
		Assertions.assertNotNull(result);
		Assertions.assertEquals(result.getId(), existingId);
		Assertions.assertEquals(result.getNome(), pessoa.getNome());
	}
	
	@Test
	public void findByIdShouldReturnResourceNotFoundExceptionWhenIdDoesNotExists() {		
		
		Assertions.assertThrows(ResourceNotFoundException.class, () -> {
			service.findById(nonExistingId);
		});
	}
	
	@Test
	public void findAllShouldReturnListofPessoaDTO() {		
		
		List<PessoaDTO> result = service.findAll();
		
		Assertions.assertNotNull(result);
		Assertions.assertEquals(List.of(pessoaDTO), result);
	}

}
