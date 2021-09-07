package br.com.contterjan.gestao_empresas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.contterjan.gestao_empresas.domain.ResponsavelEmpresa;

@Repository
public interface ResponsavelEmpresaRepository extends JpaRepository<ResponsavelEmpresa, String>{
}
