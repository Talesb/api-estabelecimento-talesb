package br.edu.infnet.api.estabelecimentotalesb.loaders;

import java.util.List;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.api.estabelecimentotalesb.model.domain.Estabelecimento;
import br.edu.infnet.api.estabelecimentotalesb.model.domain.Funcionario;
import br.edu.infnet.api.estabelecimentotalesb.model.service.FuncionarioService;
import br.edu.infnet.api.estabelecimentotalesb.model.service.UsuarioService;

@Component
public class FuncionarioLoader implements ApplicationRunner {

	private FuncionarioService funcionarioService;

	private UsuarioService usuarioService;

	public FuncionarioLoader(FuncionarioService funcionarioService, UsuarioService usuarioService) {
		this.funcionarioService = funcionarioService;
		this.usuarioService = usuarioService;
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {

		System.out.println("Execução do Application Loader de Funcionarios");

		try {
			String[] cpfs = { "16296859171", "30405682484", "70497717590" };

			Estabelecimento estabelecimento = (Estabelecimento) this.usuarioService.validar("murilo", "andreia");

			for (String cpf : cpfs) {

				Funcionario funcionario = new Funcionario();
				funcionario.setCpf(cpf);
				funcionario.setEmail("func@" + cpf + "el.com.br");
				funcionario.setTelefone("7126766552");
				funcionario.setLogin("func" + cpf);
				funcionario.setNome("Func_" + cpf);
				funcionario.setSenha("1234");

				if (estabelecimento != null) {
					funcionario.setEstabelecimento(estabelecimento);
				}
				try {
					funcionarioService.incluir(funcionario);
					System.out.println(" Funcionario cadastrado com sucesso");
				} catch (Exception e) {
					System.out.println("[ERROR] Problemas ao cadastrar Funcionario: " + e.getMessage());
				}
			}

			List<Funcionario> funcionarios = funcionarioService.obterLista(estabelecimento.getId());

			funcionarios.stream().forEach(funcionario -> {
				System.out.println(funcionario.getNome());
			});
		} catch (Exception e) {
			System.out.println("[ERROR] Problemas ao cadastrar Funcionarios em lote: " + e.getMessage());
		}

	}

}
