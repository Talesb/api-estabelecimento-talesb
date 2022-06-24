package br.edu.infnet.api.estabelecimentotalesb.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.edu.infnet.api.estabelecimentotalesb.model.domain.Estabelecimento;
import br.edu.infnet.api.estabelecimentotalesb.model.domain.Funcionario;
import br.edu.infnet.api.estabelecimentotalesb.model.dto.FuncionarioDTO;
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

	public List<Funcionario> obterLista(Integer idEstabelecimento) {
		return this.funcionarioRepository.obterLista(idEstabelecimento);
	}

	public void incluir(Funcionario funcionario) {
		this.funcionarioRepository.save(funcionario);
	}

	public void incluir(FuncionarioDTO funcionariodto) throws Exception {
		Optional<Estabelecimento> estabelecimento = this.estabelecimentoRepository
				.findById(funcionariodto.getEstabelecimentoId());
		Funcionario funcionario = funcionariodto.toFuncionario();

		if (estabelecimento.isPresent()) {
			funcionario.setEstabelecimento(estabelecimento.get());
		} else {
			throw new Exception("Não é possível persistir um funcionário sem um estabelecimento");
		}

		this.funcionarioRepository.save(funcionario);
	}

}
