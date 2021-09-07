package br.com.contterjan.gestao_empresas.dtos;

import br.com.contterjan.gestao_empresas.domain.Empresa;

public class EmpresaDTO {

	private String cnpj;
	private String nome;

	public EmpresaDTO() {
	}

	public EmpresaDTO(String cnpj, String nome) {
		this.cnpj = cnpj;
		this.nome = nome;
	}

	public EmpresaDTO(Empresa empresa) {
		this.cnpj = empresa.getCnpj();
		this.nome = empresa.getNome();
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
}
