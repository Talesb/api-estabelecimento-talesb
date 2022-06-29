package br.edu.infnet.api.estabelecimentotalesb.loaders;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.api.estabelecimentotalesb.model.domain.Estabelecimento;
import br.edu.infnet.api.estabelecimentotalesb.model.service.EstabelecimentoService;

@Component
public class EstabelecimentoLoader implements ApplicationRunner {

	private EstabelecimentoService estabelecimentoService;

	public EstabelecimentoLoader(EstabelecimentoService estabelecimentoService) {
		this.estabelecimentoService = estabelecimentoService;
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
//		System.out.println("Execução do Application Loader de Estabelecimento");
//		Estabelecimento establecimento = new Estabelecimento();
//		establecimento.setCnpj("79889012000179");
//		establecimento.setEdtech(false);
//		establecimento.setEndereco("São Bernardo do Campo");
//		establecimento.setLogin("murilo");
//		establecimento.setNome("Murilo e Andreia Informática Ltda");
//		establecimento.setSenha("andreia");
//		try {
//			estabelecimentoService.incluir(establecimento);
//			System.out.println("Loader de Estabelecimento executado com sucesso");
//		} catch (Exception e) {
//			System.out.println("[ERROR] Problemas ao executar loader de Estabelecimento: " + e.getMessage());
//		}

	}

}
