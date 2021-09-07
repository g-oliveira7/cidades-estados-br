package br.com.contterjan.gestao_empresas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.contterjan.gestao_empresas.domain.Estado;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, String>{
}
