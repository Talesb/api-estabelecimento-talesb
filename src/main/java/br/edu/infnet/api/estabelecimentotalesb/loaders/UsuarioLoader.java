package br.edu.infnet.api.estabelecimentotalesb.loaders;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.api.estabelecimentotalesb.model.domain.Usuario;
import br.edu.infnet.api.estabelecimentotalesb.model.service.UsuarioService;

@Component
public class UsuarioLoader implements ApplicationRunner {

	private UsuarioService usuarioService;

	public UsuarioLoader(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("Execução do Application Loader de Usuario");

		Usuario usuario = this.usuarioService.validar("func70497717590", "1234");

		if (usuario != null) {
			usuarioService.excluir(usuario.getId());
			System.out.println("Exclusão do usuário " + usuario.getLogin() + " realizada com sucesso");
		}


	}

}
