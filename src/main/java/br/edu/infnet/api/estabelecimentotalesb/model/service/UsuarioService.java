package br.edu.infnet.api.estabelecimentotalesb.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.edu.infnet.api.estabelecimentotalesb.model.domain.Usuario;
import br.edu.infnet.api.estabelecimentotalesb.model.repository.UsuarioRepository;

@Service
public class UsuarioService {

	private UsuarioRepository usuarioRepository;

	public UsuarioService(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}

	public Usuario validar(String login, String senha) {
		return this.usuarioRepository.validar(login, senha);
	}

	public void excluir(Integer id) {
		this.usuarioRepository.deleteById(id);
	}

	public List<Usuario> obterLista() {
		return (List<Usuario>) this.usuarioRepository.findAll();
	}

}
