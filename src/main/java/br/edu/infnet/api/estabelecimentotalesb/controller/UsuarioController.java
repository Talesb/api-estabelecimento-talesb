package br.edu.infnet.api.estabelecimentotalesb.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.api.estabelecimentotalesb.model.domain.Usuario;
import br.edu.infnet.api.estabelecimentotalesb.model.dto.ValidarDTO;
import br.edu.infnet.api.estabelecimentotalesb.model.service.UsuarioService;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

	private UsuarioService usuarioService;

	public UsuarioController(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}


	@PostMapping(value = "/validar", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Usuario validar(@RequestBody ValidarDTO dto, HttpServletResponse response)  {
		Usuario usuario = this.usuarioService.validar(dto.getLogin(), dto.getSenha());
		if (usuario == null) {
			naoAutorizado(response);
		}
		return usuario;
	}

	private void naoAutorizado(HttpServletResponse response) {
		try {
			response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Authentication Failed");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	@DeleteMapping("/{id}/excluir")
	public void excluir(@PathVariable Integer id) {
		this.usuarioService.excluir(id);
	}

	@GetMapping(value = "/listar", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Usuario> obterLista() {
		return this.usuarioService.obterLista();
	}

}
