package com.luisguilherme.desafioattornatus.controllers;

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
import com.luisguilherme.desafioattornatus.dto.PessoaDTO;
import com.luisguilherme.desafioattornatus.factories.PessoaFactory;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class PessoaControllerIT {

	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	private Long existingId;
	private Long nonExistingId;
	private Long countTotalPessoas;
	
	@BeforeEach
	void setUp() throws Exception {
		existingId = 1L;
		nonExistingId = 2L;
		countTotalPessoas = 7L;
	}
	
	@Test
	public void insertShouldReturnPessoaDTO() throws Exception {
		
		PessoaDTO pessoaDTO = PessoaFactory.createPessoaDTO();
		String jsonBody = objectMapper.writeValueAsString(pessoaDTO);
		
		String expectedName = pessoaDTO.getNome();
		
		ResultActions result = 
				mockMvc.perform(post("/pessoas")
					.content(jsonBody)
					.contentType(MediaType.APPLICATION_JSON)
					.accept(MediaType.APPLICATION_JSON));
		
		result.andExpect(status().isCreated());
		result.andExpect(jsonPath("$.id").value(countTotalPessoas+1));
		result.andExpect(jsonPath("$.nome").value(expectedName));
	}
}
