package br.edu.infnet.api.estabelecimentotalesb.model.service;

import org.springframework.stereotype.Service;

import br.edu.infnet.api.estabelecimentotalesb.model.domain.Estabelecimento;
import br.edu.infnet.api.estabelecimentotalesb.model.repository.EstabelecimentoRepository;

@Service
public class EstabelecimentoService {

	private EstabelecimentoRepository estabelecimentoRepository;

	public EstabelecimentoService(EstabelecimentoRepository estabelecimentoRepository) {
		this.estabelecimentoRepository = estabelecimentoRepository;
	}

	public void incluir(Estabelecimento estabelecimento) {
		this.estabelecimentoRepository.save(estabelecimento);
	}

}
