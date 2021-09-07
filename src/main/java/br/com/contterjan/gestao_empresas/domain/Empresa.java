package br.com.contterjan.gestao_empresas.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "empresas")
public class Empresa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String cnpj;
	private String nome;

	@ElementCollection
	@CollectionTable(name = "telefones_empresa", joinColumns = @JoinColumn(name = "cnpj", referencedColumnName = "cnpj"))
	@Column(name = "telefone")
	private List<String> telefones = new ArrayList<>();
	
	private String email;
	private String inscricaoEstadual;
	private String inscricaoMunicipal;
	private String codAcesso;

	@OneToMany(mappedBy = "empresa", cascade = CascadeType.ALL)
	private List<ResponsavelEmpresa> responsaveis = new ArrayList<>();

	@OneToOne(cascade = CascadeType.ALL)
	private Endereco endereco;

	@OneToMany(mappedBy = "empresa", cascade = CascadeType.ALL)
	private List<Movimento> movimentos = new ArrayList<>();

	public Empresa() {
	}

	public Empresa(String cnpj, String nome, List<String> telefones, String email, String inscricaoEstadual,
			String inscricaoMunicipal, String codAcesso, Endereco endereco) {
		this.cnpj = cnpj;
		this.nome = nome;
		this.telefones = telefones;
		this.email = email;
		this.inscricaoEstadual = inscricaoEstadual;
		this.inscricaoMunicipal = inscricaoMunicipal;
		this.codAcesso = codAcesso;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getInscricaoEstadual() {
		return inscricaoEstadual;
	}

	public void setInscricaoEstadual(String inscricaoEstadual) {
		this.inscricaoEstadual = inscricaoEstadual;
	}

	public String getInscricaoMunicipal() {
		return inscricaoMunicipal;
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

	public List<Movimento> getMovimentos() {
		return movimentos;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public List<ResponsavelEmpresa> getResponsaveis() {
		return responsaveis;
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
		Empresa other = (Empresa) obj;
		if (cnpj == null) {
			if (other.cnpj != null)
				return false;
		} else if (!cnpj.equals(other.cnpj))
			return false;
		return true;
	}
}
