package br.edu.infnet.api.estabelecimentotalesb.model.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import br.edu.infnet.api.estabelecimentotalesb.model.domain.Estabelecimento;
import br.edu.infnet.api.estabelecimentotalesb.model.domain.dto.EstabelecimentoDTO;
import br.edu.infnet.api.estabelecimentotalesb.model.repository.EstabelecimentoRepository;

@Service
public class EstabelecimentoService {

	private EstabelecimentoRepository estabelecimentoRepository;

	public EstabelecimentoService(EstabelecimentoRepository estabelecimentoRepository) {
		this.estabelecimentoRepository = estabelecimentoRepository;
	}

	public void incluir(EstabelecimentoDTO estabelecimento) {
		this.estabelecimentoRepository.save(Estabelecimento.toEstabelecimento(estabelecimento));
	}

	public List<EstabelecimentoDTO> obterTodos() {
		List<Estabelecimento> estabelecimentos = (List<Estabelecimento>) this.estabelecimentoRepository.findAll();
		return estabelecimentos.stream().map(estabelecimento -> estabelecimento.toDTO()).collect(Collectors.toList());
	}

	public EstabelecimentoDTO obterPorId(Integer idEstabelecimento) {
		Optional<Estabelecimento> estabelecimento = estabelecimentoRepository.findById(idEstabelecimento);
		if (estabelecimento.isPresent()) {
			return estabelecimento.get().toDTO();
		} else {
			return null;
		}

	}

	public void remover(Integer idEstabelecimento) {
		estabelecimentoRepository.deleteById(idEstabelecimento);

	}

}
