package br.edu.infnet.api.estabelecimentotalesb.model.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import br.edu.infnet.api.estabelecimentotalesb.model.domain.Estabelecimento;
import br.edu.infnet.api.estabelecimentotalesb.model.domain.Funcionario;
import br.edu.infnet.api.estabelecimentotalesb.model.domain.dto.FuncionarioDTO;
import br.edu.infnet.api.estabelecimentotalesb.model.repository.EstabelecimentoRepository;
import br.edu.infnet.api.estabelecimentotalesb.model.repository.FuncionarioRepository;

@Service
public class FuncionarioService {

	private FuncionarioRepository funcionarioRepository;

	private EstabelecimentoRepository estabelecimentoRepository;

	public FuncionarioService(FuncionarioRepository funcionarioRepository,
			EstabelecimentoRepository estabelecimentoRepository) {
		this.funcionarioRepository = funcionarioRepository;
		this.estabelecimentoRepository = estabelecimentoRepository;
	}

	public List<FuncionarioDTO> obterListaPorEstabelecimento(Integer idEstabelecimento) {
		return this.funcionarioRepository.obterLista(idEstabelecimento).stream().map(func -> func.toDTO())
				.collect(Collectors.toList());
	}

	public List<FuncionarioDTO> obterLista() {
		return ((List<Funcionario>) this.funcionarioRepository.findAll()).stream().map(func -> func.toDTO())
				.collect(Collectors.toList());
	}

	public FuncionarioDTO obterById(Integer idfuncionario) {
		if (this.funcionarioRepository.findById(idfuncionario).isPresent()) {
			return this.funcionarioRepository.findById(idfuncionario).get().toDTO();
		}
		return null;
	}

	public void incluir(FuncionarioDTO funcionariodto) throws Exception {
		Optional<Estabelecimento> estabelecimento = this.estabelecimentoRepository
				.findById(funcionariodto.getEstabelecimentoId());

		Funcionario funcionario = Funcionario.toFuncionario(funcionariodto);
		if (estabelecimento.isPresent()) {
			funcionario.setEstabelecimento(estabelecimento.get());
		} else {
			throw new Exception("Não é possível persistir um funcionário sem um estabelecimento");
		}

		this.funcionarioRepository.save(funcionario);
	}

	public void remover(Integer idFuncionario) {
		estabelecimentoRepository.deleteById(idFuncionario);
	}

}
