package br.com.contterjan.gestao_empresas.resources;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.contterjan.gestao_empresas.domain.Empresa;
import br.com.contterjan.gestao_empresas.dtos.EmpresaDTO;
import br.com.contterjan.gestao_empresas.dtos.EmpresaNewDTO;
import br.com.contterjan.gestao_empresas.services.EmpresaService;

@RestController
@RequestMapping("/empresas")
public class EmpresaResource {

	@Autowired
	EmpresaService serv;

	@PostMapping
	public ResponseEntity<Void> save(@Valid @RequestBody EmpresaNewDTO oDto) {
		Empresa o = serv.save(oDto);
		URI uri = ServletUriComponentsBuilder
				.fromCurrentContextPath()
				.path("**/{id}")
				.buildAndExpand(o.getCnpj())
				.toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@GetMapping
	public ResponseEntity<Page<EmpresaDTO>> findAll(
			@RequestParam(value = "page", defaultValue = "0") Integer nPage,
			@RequestParam(value = "size", defaultValue = "24") Integer size,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction,
			@RequestParam(value = "orderBy", defaultValue = "nome") String orderBy) {
		Page<EmpresaDTO> page = serv.findAllInPage(nPage, size, direction, orderBy);
		return ResponseEntity.ok(page);
	}

	@GetMapping("/{cnpj}")
	public ResponseEntity<Empresa> find(@PathVariable String cnpj) {
		Empresa emp = serv.findByCnpj(cnpj);
		return ResponseEntity.ok(emp);
	}
}
