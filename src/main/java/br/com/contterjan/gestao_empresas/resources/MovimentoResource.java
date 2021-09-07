package br.com.contterjan.gestao_empresas.resources;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.contterjan.gestao_empresas.domain.Movimento;
import br.com.contterjan.gestao_empresas.dtos.MovimentoEntradaDTO;
import br.com.contterjan.gestao_empresas.dtos.MovimentoSaidaDTO;
import br.com.contterjan.gestao_empresas.services.MovimentoService;

@RestController
@RequestMapping("/movimentos")
public class MovimentoResource {

	@Autowired
	MovimentoService serv;
	
	@GetMapping
	public ResponseEntity<Page<Movimento>> findAll(
			@RequestParam(value = "page", defaultValue = "0") Integer nPage,
			@RequestParam(value = "size", defaultValue = "24") Integer size,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction,
			@RequestParam(value = "orderBy", defaultValue = "nome") String orderBy) {
		Page<Movimento> page = serv.findAllInPage(nPage, size, direction, orderBy);
		return ResponseEntity.ok(page);
	}

	@GetMapping("/{cnpj}/{ano}/{mes}")
	public ResponseEntity<Movimento> getMovimento(@PathVariable String cnpj, @PathVariable String ano,
			@PathVariable String mes) throws ParseException {
		String ref = mes.concat("/").concat(ano);
		Movimento mov = serv.findMovimento(cnpj, ref);
		return ResponseEntity.ok(mov);
	}

	@PutMapping("/entrada/{cnpj}")
	public ResponseEntity<Void> putEntrada(@PathVariable String cnpj, @RequestBody MovimentoEntradaDTO entrada) {
		serv.addEntrada(cnpj, entrada);
		return ResponseEntity.noContent().build();
	}

	@PutMapping("/saida/{cnpj}")
	public ResponseEntity<Void> putSaida(@PathVariable String cnpj, @RequestBody MovimentoSaidaDTO saida) {
		serv.addSaida(cnpj, saida);
		return ResponseEntity.noContent().build();
	}
}
