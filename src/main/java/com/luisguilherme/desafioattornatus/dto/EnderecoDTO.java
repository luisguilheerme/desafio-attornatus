package com.luisguilherme.desafioattornatus.dto;

import java.util.Objects;

import com.luisguilherme.desafioattornatus.entities.Endereco;

public class EnderecoDTO {

	private Long id;
	private String logradouro;
	private String cep;
	private String numero;
	private String cidade;

	private boolean enderecoPrincipal;

	public EnderecoDTO() {

	}

	public EnderecoDTO(Long id, String logradouro, String cep, String numero, String cidade,
			boolean enderecoPrincipal) {
		this.id = id;
		this.logradouro = logradouro;
		this.cep = cep;
		this.numero = numero;
		this.cidade = cidade;
		this.enderecoPrincipal = enderecoPrincipal;
	}

	public EnderecoDTO(Endereco entity) {
		id = entity.getId();
		logradouro = entity.getLogradouro();
		cep = entity.getCep();
		numero = entity.getNumero();
		cidade = entity.getCidade();
		enderecoPrincipal = entity.isEnderecoPrincipal();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public boolean isEnderecoPrincipal() {
		return enderecoPrincipal;
	}

	public void setEnderecoPrincipal(boolean enderecoPrincipal) {
		this.enderecoPrincipal = enderecoPrincipal;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EnderecoDTO other = (EnderecoDTO) obj;
		return Objects.equals(id, other.id);
	}

}
