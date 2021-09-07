package br.com.contterjan.gestao_empresas.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.com.contterjan.gestao_empresas.domain.Empresa;
import br.com.contterjan.gestao_empresas.domain.Movimento;
import br.com.contterjan.gestao_empresas.dtos.MovimentoEntradaDTO;
import br.com.contterjan.gestao_empresas.dtos.MovimentoSaidaDTO;
import br.com.contterjan.gestao_empresas.repositories.EmpresaRepository;
import br.com.contterjan.gestao_empresas.repositories.MovimentoRepository;

@Service
public class MovimentoService {

	@Autowired
	MovimentoRepository repo;

	@Autowired
	EmpresaRepository empRepo;
	
	public Page<Movimento> findAllInPage(Integer nPage, Integer size, String direction, String orderBy) {
		PageRequest pageReq = PageRequest.of(nPage, size, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageReq);
	}

	public Movimento findMovimento(String cnpj, String ref) {
		if (cnpj == null || ref == null) {
			throw new IllegalArgumentException("Falha ao encontrar movimento: dados nulos");
		}
		return repo.findByRefAndEmpresaCnpj(ref, cnpj);
	}
	
	public void addEntrada(String cnpj, MovimentoEntradaDTO entrada) {
		if (cnpj == null || entrada == null) {
			throw new IllegalArgumentException("CNPJ ou valores de Entrada nulos");
		}

		Movimento mov = new Movimento();
		if (exists(entrada.getRef())) {
			mov = repo.findById(entrada.getRef().toString()).orElse(null);
			mov.addEntrada(entrada.getValor());
		} else {
			mov = new Movimento(entrada.getRef());
			mov.addEntrada(entrada.getValor());
		}

		Empresa e = empRepo.findById(cnpj)
				.orElseThrow(() -> new IllegalArgumentException("Empresa com CNPJ: " + cnpj + " não encontrada"));
		mov.setEmpresa(e);
		e.getMovimentos().add(mov);
		empRepo.save(e);
	}

	public void addSaida(String cnpj, MovimentoSaidaDTO saida) {
		if (cnpj == null || saida == null) {
			throw new IllegalArgumentException("CNPJ ou valores de Saida nulos");
		}

		Movimento mov = new Movimento();
		if (exists(saida.getRef())) {
			mov = repo.findById(saida.getRef().toString()).orElse(null);
			mov.addSaida(saida.getValor());
		} else {
			mov = new Movimento(saida.getRef());
			mov.addSaida(saida.getValor());
		}

		Empresa e = empRepo.findById(cnpj)
				.orElseThrow(() -> new IllegalArgumentException("Empresa com CNPJ: " + cnpj + " não encontrada"));
		e.getMovimentos().add(mov);
		empRepo.save(e);
	}

	private boolean exists(String ref) {
		Optional<Movimento> mov = repo.findById(ref);
		if (mov.isEmpty()) {
			return false;
		}
		return true;
	}

}
