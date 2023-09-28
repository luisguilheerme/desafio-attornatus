package com.luisguilherme.desafioattornatus.controllers;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.luisguilherme.desafioattornatus.dto.EnderecoDTO;
import com.luisguilherme.desafioattornatus.factories.EnderecoFactory;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class EnderecoControllerIT {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	private Long existingId;
	private Long nonExistingId;
	private Long countTotalEnderecos;
	
	@BeforeEach
	void setUp() throws Exception {
		existingId = 1L;
		nonExistingId = 100L;
		countTotalEnderecos = 9L;
	}
	
	@Test
	public void insertShouldReturnEnderecoDTOWhenIdExists() throws Exception {
		
		EnderecoDTO enderecoDTO = EnderecoFactory.createEnderecoDTO();
		String jsonBody = objectMapper.writeValueAsString(enderecoDTO);
		
		String expectedName = enderecoDTO.getLogradouro();
		
		ResultActions result = 
				mockMvc.perform(post("/enderecos/{pessoaId}", existingId)
					.content(jsonBody)
					.contentType(MediaType.APPLICATION_JSON)
					.accept(MediaType.APPLICATION_JSON));
		
		result.andExpect(status().isCreated());
		result.andExpect(jsonPath("$.id").value(countTotalEnderecos+1));
		result.andExpect(jsonPath("$.logradouro").value(expectedName));
	}
	
	@Test
	public void insertShouldReturnNotFoundWhenIdDoesNotExists() throws Exception {
		
		EnderecoDTO enderecoDTO = EnderecoFactory.createEnderecoDTO();
		String jsonBody = objectMapper.writeValueAsString(enderecoDTO);
		
		ResultActions result = 
				mockMvc.perform(post("/enderecos/{pessoaId}", nonExistingId)
					.content(jsonBody)
					.contentType(MediaType.APPLICATION_JSON)
					.accept(MediaType.APPLICATION_JSON));
		
		result.andExpect(status().isNotFound());
	}
	
	@Test
	public void findAllShouldReturnListofEnderecoDTOWhenIdExists() throws Exception {
		
		ResultActions result = 
				mockMvc.perform(get("/enderecos/{pessoaId}", existingId)
					.accept(MediaType.APPLICATION_JSON));
		
		 	result.andExpect(jsonPath("$").isArray()); 
		    result.andExpect(jsonPath("$[0].logradouro", is("Rua das Palmeiras")));
		    result.andExpect(jsonPath("$[1].logradouro", is("Rua das Alamedas")));	
	}
	
	@Test
	public void findAllShouldReturnNotFoundWhenIdDoesNotExists() throws Exception {
		
		EnderecoDTO enderecoDTO = EnderecoFactory.createEnderecoDTO();
		String jsonBody = objectMapper.writeValueAsString(enderecoDTO);
		
		ResultActions result = 
				mockMvc.perform(get("/enderecos/{pessoaId}", nonExistingId)
					.content(jsonBody)
					.contentType(MediaType.APPLICATION_JSON)
					.accept(MediaType.APPLICATION_JSON));
		
		result.andExpect(status().isNotFound());
	}

	@Test
	public void findEnderecoPrincipalShouldReturnEnderecoDTOWhenIdExists() throws Exception {
		
		ResultActions result = 
				mockMvc.perform(get("/enderecos/{pessoaId}/main", existingId)
					.accept(MediaType.APPLICATION_JSON));
		
			result.andExpect(status().isOk()); 
		    result.andExpect(jsonPath("$.logradouro", is("Rua das Palmeiras")));	
	}
	
	@Test
	public void findEnderecoPrincipalShouldReturnNotFoundWhenIdDoesNotExists() throws Exception {
		
		EnderecoDTO enderecoDTO = EnderecoFactory.createEnderecoDTO();
		String jsonBody = objectMapper.writeValueAsString(enderecoDTO);
		
		ResultActions result = 
				mockMvc.perform(get("/enderecos/{pessoaId}/main", nonExistingId)
					.content(jsonBody)
					.contentType(MediaType.APPLICATION_JSON)
					.accept(MediaType.APPLICATION_JSON));
		
		result.andExpect(status().isNotFound());
	}
}
