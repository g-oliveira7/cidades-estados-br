package br.com.contterjan.gestao_empresas.dtos;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ResponsavelEmpresaDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String cpf;
	private String nomeCompleto;
	private String tituloEleitor;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dataNascimento;

	public ResponsavelEmpresaDTO() {
	}

	public ResponsavelEmpresaDTO(String cpf, String nomeCompleto, String tituloEleitor, Date dataNascimento) {
		this.cpf = cpf;
		this.nomeCompleto = nomeCompleto;
		this.tituloEleitor = tituloEleitor;
		this.dataNascimento = dataNascimento;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public String getTituloEleitor() {
		return tituloEleitor;
	}

	public void setTituloEleitor(String tituloEleitor) {
		this.tituloEleitor = tituloEleitor;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
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
		ResponsavelEmpresaDTO other = (ResponsavelEmpresaDTO) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		return true;
	}
}
