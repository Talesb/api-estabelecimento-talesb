package br.edu.infnet.api.estabelecimentotalesb.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.api.estabelecimentotalesb.model.domain.Funcionario;
import br.edu.infnet.api.estabelecimentotalesb.model.dto.FuncionarioDTO;
import br.edu.infnet.api.estabelecimentotalesb.model.service.FuncionarioService;

@RestController
@RequestMapping("/api/funcionario")
public class FuncionarioController {

	private FuncionarioService funcionarioService;

	public FuncionarioController(FuncionarioService funcionarioService) {
		this.funcionarioService = funcionarioService;
	}

	@PostMapping(value="/incluirdto")
 	public void incluirViaDTO(@RequestBody FuncionarioDTO funcionario) throws Exception {
		this.funcionarioService.incluir(funcionario);
	}
	
	@PostMapping(value="/incluir")
	public void incluir(@RequestBody Funcionario funcionario) throws Exception {
		this.funcionarioService.incluir(funcionario);
	}

	@GetMapping(value = "/{idEstabelecimento}/listar")
	public List<Funcionario> obterLista(@PathVariable Integer idEstabelecimento) {
		return this.funcionarioService.obterLista(idEstabelecimento);
	}

}
