package br.com.contterjan.gestao_empresas.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "responsaveis_empresa")
public class ResponsavelEmpresa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String cpf;
	private String nomeCompleto;
	private String tituloEleitor;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dataNascimento;

	@ManyToOne
	@JsonIgnore
	private Empresa empresa;

	public ResponsavelEmpresa() {
	}

	public ResponsavelEmpresa(String cpf, String nomeCompleto, String tituloEleitor, Date dataNascimento,
			Empresa empresa) {
		this.cpf = cpf;
		this.nomeCompleto = nomeCompleto;
		this.tituloEleitor = tituloEleitor;
		this.dataNascimento = dataNascimento;
		this.empresa = empresa;
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

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
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
		ResponsavelEmpresa other = (ResponsavelEmpresa) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		return true;
	}
}
