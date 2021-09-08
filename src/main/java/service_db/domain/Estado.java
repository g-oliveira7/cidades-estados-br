package service_db.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "estados")
public class Estado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String uf;
	private String nome;

	@OneToMany(mappedBy = "estado")
	@JsonIgnore
	private List<Cidade> cidades = new ArrayList<>();

	public Estado() {
	}

	public Estado(String uf, String nome) {
		this.uf = uf;
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public List<Cidade> getCidades() {
		return cidades;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((uf == null) ? 0 : uf.hashCode());
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
		Estado other = (Estado) obj;
		if (uf == null) {
			if (other.uf != null)
				return false;
		} else if (!uf.equals(other.uf))
			return false;
		return true;
	}
}
