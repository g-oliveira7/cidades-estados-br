package br.com.contterjan.gestao_empresas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.contterjan.gestao_empresas.domain.Movimento;

@Repository
public interface MovimentoRepository extends JpaRepository<Movimento, String> {

	Movimento findByRefAndEmpresaCnpj(String ref, String cnpj);
}
