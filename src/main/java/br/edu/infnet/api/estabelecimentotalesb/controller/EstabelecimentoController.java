package br.edu.infnet.api.estabelecimentotalesb.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.api.estabelecimentotalesb.model.domain.Estabelecimento;
import br.edu.infnet.api.estabelecimentotalesb.model.domain.dto.EstabelecimentoDTO;
import br.edu.infnet.api.estabelecimentotalesb.model.service.EstabelecimentoService;

@RestController
@RequestMapping("/api/estabelecimento")
public class EstabelecimentoController {

	private EstabelecimentoService estabelecimentoService;

	public EstabelecimentoController(EstabelecimentoService estabelecimentoService) {
		this.estabelecimentoService = estabelecimentoService;
	}

	@PostMapping(value = "/incluir")
	public void incluir(@RequestBody EstabelecimentoDTO estabelecimento) {
		this.estabelecimentoService.incluir(estabelecimento);
	}

	@GetMapping
	public List<EstabelecimentoDTO> obterTodos() {
		return this.estabelecimentoService.obterTodos();
	}

	@DeleteMapping("/{idEstabelecimento}")
	public void remover(@PathVariable Integer idEstabelecimento) {
		this.estabelecimentoService.remover(idEstabelecimento);
	}

	@GetMapping("/{idEstabelecimento}")
	public EstabelecimentoDTO obterPorId(@PathVariable Integer idEstabelecimento) {
		return this.estabelecimentoService.obterPorId(idEstabelecimento);
	}

}
