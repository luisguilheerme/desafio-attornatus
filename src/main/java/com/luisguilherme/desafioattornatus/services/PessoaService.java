package com.luisguilherme.desafioattornatus.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luisguilherme.desafioattornatus.repositories.PessoaRepository;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository repository;

}
