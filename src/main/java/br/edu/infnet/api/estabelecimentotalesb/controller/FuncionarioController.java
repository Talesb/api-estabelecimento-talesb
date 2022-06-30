package br.edu.infnet.api.estabelecimentotalesb.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.api.estabelecimentotalesb.model.domain.Funcionario;
import br.edu.infnet.api.estabelecimentotalesb.model.domain.dto.FuncionarioDTO;
import br.edu.infnet.api.estabelecimentotalesb.model.service.FuncionarioService;

@RestController
@RequestMapping("/api/funcionario")
public class FuncionarioController {

	private FuncionarioService funcionarioService;

	public FuncionarioController(FuncionarioService funcionarioService) {
		this.funcionarioService = funcionarioService;
	}

	@PostMapping(value = "/incluir")
	public void incluirViaDTO(@RequestBody FuncionarioDTO funcionario) throws Exception {
		this.funcionarioService.incluir(funcionario);
	}

	@GetMapping(value = "/estabelecimento/{idEstabelecimento}")
	public List<FuncionarioDTO> obterListaPorEstabelecimento(@PathVariable Integer idEstabelecimento) {
		return this.funcionarioService.obterListaPorEstabelecimento(idEstabelecimento);
	}

	@GetMapping
	public List<FuncionarioDTO> obterLista() {
		return this.funcionarioService.obterLista();
	}

	@DeleteMapping(value="/{idEstabelecimento}")
	public void remover(@PathVariable Integer idEstabelecimento) {
		this.funcionarioService.remover(idEstabelecimento);
	}

}
