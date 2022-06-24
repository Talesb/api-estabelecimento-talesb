package br.edu.infnet.api.estabelecimentotalesb.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.api.estabelecimentotalesb.model.domain.Estabelecimento;
import br.edu.infnet.api.estabelecimentotalesb.model.service.EstabelecimentoService;

@RestController
@RequestMapping("/api/estabelecimento")
public class EstabelecimentoController {

	private EstabelecimentoService estabelecimentoService;

	public EstabelecimentoController(EstabelecimentoService estabelecimentoService) {
		this.estabelecimentoService = estabelecimentoService;
	}

	@PostMapping(value = "/incluir")
	public void incluir(@RequestBody Estabelecimento estabelecimento) {
		this.estabelecimentoService.incluir(estabelecimento);
	}

}
