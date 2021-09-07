package br.com.contterjan.gestao_empresas.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "movimentos")
public class Movimento implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	private String ref;
	
	private Double entrada = 0.0;
	private Double saida = 0.0;

	@ManyToOne
	@JsonIgnore
	private Empresa empresa;

	public Movimento() {
	}

	public Movimento(String ref) {
		this.ref = ref;
	}

	public String getRef() {
		return ref;
	}

	public void setRef(String ref) {
		this.ref = ref;
	}

	public Double getEntrada() {
		return entrada;
	}

	public void addEntrada(Double entrada) {
		this.entrada += entrada;
	}

	public Double getSaida() {
		return saida;
	}

	public void addSaida(Double saida) {
		this.saida += saida;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
}
