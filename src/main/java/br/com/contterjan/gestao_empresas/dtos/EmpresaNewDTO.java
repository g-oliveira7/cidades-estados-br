package br.com.contterjan.gestao_empresas.dtos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.br.CNPJ;

public class EmpresaNewDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@CNPJ(message = "CNPJ inválido")
	@NotEmpty(message = "É necessário o CNPJ da empresa")
	private String cnpj;
	
	@NotEmpty(message = "É necessário o nome da empresa")
	private String nome;
	
	@NotEmpty(message = "É necessário pelo menos um telefone de contato da empresa")
	private List<String> telefones = new ArrayList<>();
	
	@Email(message = "E-mail inválido")
	@NotEmpty(message = "É necessário um E-mail da empresa")
	private String email;
	
	private String inscricaoEstadual;
	
	private String inscricaoMunicipal;
	
	@NotEmpty(message = "Código de acesso obrigatório")
	private String codAcesso;
	
	@NotEmpty(message = "É necessário pelo menos um responsável pela empresa")
	private List<ResponsavelEmpresaDTO> responsaveis = new ArrayList<>();
	
	@Valid
	private EnderecoDTO endereco;

	public EmpresaNewDTO() {
	}

	public EmpresaNewDTO(String cnpj, String nome, List<String> telefones, String email, String inscricaoEstadual, String inscricaoMunicipal,
			String codAcesso, List<ResponsavelEmpresaDTO> responsaveis, EnderecoDTO endereco) {
		this.cnpj = cnpj;
		this.nome = nome;
		this.telefones = telefones;
		this.email = email;
		this.inscricaoEstadual = inscricaoEstadual;
		this.inscricaoMunicipal = inscricaoMunicipal;
		this.codAcesso = codAcesso;
		this.responsaveis = responsaveis;
		this.endereco = endereco;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<String> getTelefones() {
		return telefones;
	}

	public void setTelefones(List<String> telefones) {
		this.telefones = telefones;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getInscricaoMunicipal() {
		return inscricaoMunicipal;
	}

	public String getInscricaoEstadual() {
		return inscricaoEstadual;
	}

	public void setInscricaoEstadual(String inscricaoEstadual) {
		this.inscricaoEstadual = inscricaoEstadual;
	}

	public void setInscricaoMunicipal(String inscricaoMunicipal) {
		this.inscricaoMunicipal = inscricaoMunicipal;
	}

	public String getCodAcesso() {
		return codAcesso;
	}

	public void setCodAcesso(String codAcesso) {
		this.codAcesso = codAcesso;
	}

	public List<ResponsavelEmpresaDTO> getResponsaveis() {
		return responsaveis;
	}

	public void setResponsaveis(List<ResponsavelEmpresaDTO> responsaveis) {
		this.responsaveis = responsaveis;
	}

	public EnderecoDTO getEndereco() {
		return endereco;
	}

	public void setEndereco(EnderecoDTO endereco) {
		this.endereco = endereco;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cnpj == null) ? 0 : cnpj.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmpresaNewDTO other = (EmpresaNewDTO) obj;
		if (cnpj == null) {
			if (other.cnpj != null)
				return false;
		} else if (!cnpj.equals(other.cnpj))
			return false;
		return true;
	}
}
