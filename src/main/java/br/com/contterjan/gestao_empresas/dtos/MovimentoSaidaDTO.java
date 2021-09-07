package br.com.contterjan.gestao_empresas.dtos;

public class MovimentoSaidaDTO {

	private String ref;
	private Double valor;

	public MovimentoSaidaDTO() {
	}

	public MovimentoSaidaDTO(String ref, Double valor) {
		this.ref = ref;
		this.valor = valor;
	}

	public String getRef() {
		return ref;
	}

	public void setRef(String ref) {
		this.ref = ref;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}
}
