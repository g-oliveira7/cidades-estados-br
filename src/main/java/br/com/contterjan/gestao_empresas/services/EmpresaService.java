package br.com.contterjan.gestao_empresas.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.com.contterjan.gestao_empresas.domain.Cidade;
import br.com.contterjan.gestao_empresas.domain.Empresa;
import br.com.contterjan.gestao_empresas.domain.Endereco;
import br.com.contterjan.gestao_empresas.domain.ResponsavelEmpresa;
import br.com.contterjan.gestao_empresas.dtos.EmpresaDTO;
import br.com.contterjan.gestao_empresas.dtos.EmpresaNewDTO;
import br.com.contterjan.gestao_empresas.dtos.EnderecoDTO;
import br.com.contterjan.gestao_empresas.dtos.ResponsavelEmpresaDTO;
import br.com.contterjan.gestao_empresas.repositories.CidadeRepository;
import br.com.contterjan.gestao_empresas.repositories.EmpresaRepository;
import br.com.contterjan.gestao_empresas.repositories.EnderecoRepository;
import br.com.contterjan.gestao_empresas.repositories.EstadoRepository;
import br.com.contterjan.gestao_empresas.repositories.MovimentoRepository;
import br.com.contterjan.gestao_empresas.repositories.ResponsavelEmpresaRepository;

@Service
public class EmpresaService {

	@Autowired
	EmpresaRepository repo;

	@Autowired
	CidadeRepository cidadeRepo;

	@Autowired
	EstadoRepository estadoRepo;
	
	@Autowired
	ResponsavelEmpresaRepository respEmpRepo;

	@Autowired
	EnderecoRepository enderecoRepo;
	
	@Autowired
	MovimentoRepository movimentoRepo;


	public Page<EmpresaDTO> findAllInPage(Integer nPage, Integer size, String direction, String orderBy) {
		PageRequest pageReq = PageRequest.of(nPage, size, Direction.valueOf(direction), orderBy);
		Page<Empresa> page = repo.findAll(pageReq);
		Page<EmpresaDTO> pageDto = page.map(x -> new EmpresaDTO(x));
		return pageDto;
	}
	
	public Empresa findByCnpj(String cnpj) {
		if (cnpj == null) {
			throw new IllegalArgumentException("Falha ao encontrar empresa: CNPJ não pode ser nulo");
		}
		return repo.findById(cnpj).get();
	}
	
	public Empresa save(EmpresaNewDTO oDto) {
		if (oDto == null) {
			throw new IllegalArgumentException("Falha ao salvar empresa: dados nulos");
		}
		Empresa emp = fromDto(oDto);
		oDto.getResponsaveis().stream().forEach(x -> emp.getResponsaveis().add(fromDto(x, emp)));
		Endereco end = emp.getEndereco();
		Cidade c = cidadeRepo.findById(end.getCidade().getId()).get();
		end.setEmpresa(emp);
		end.setCidade(c);
		return repo.save(emp);
	}

	private Empresa fromDto(EmpresaNewDTO oDto) {
		Empresa emp = new Empresa(oDto.getCnpj(), oDto.getNome(), oDto.getTelefones(), oDto.getEmail(),
				oDto.getInscricaoEstadual(), oDto.getInscricaoMunicipal(), oDto.getCodAcesso(),
				fromDto(oDto.getEndereco()));
		return emp;
	}

	private ResponsavelEmpresa fromDto(ResponsavelEmpresaDTO oDto, Empresa empresa) {
		ResponsavelEmpresa resp = new ResponsavelEmpresa(oDto.getCpf(), oDto.getNomeCompleto(), oDto.getTituloEleitor(),
				oDto.getDataNascimento(), empresa);
		return resp;
	}

	private Endereco fromDto(EnderecoDTO oDto) {
		Endereco end = new Endereco(null, oDto.getLogradouro(), oDto.getNumero(), oDto.getComplemento(),
				oDto.getBairro(), oDto.getCep(), new Empresa(), new Cidade(oDto.getCidadeId(), null, null));
		return end;
	}
}
