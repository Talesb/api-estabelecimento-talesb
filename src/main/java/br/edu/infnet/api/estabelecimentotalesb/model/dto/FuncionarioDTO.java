package br.edu.infnet.api.estabelecimentotalesb.model.dto;

import br.edu.infnet.api.estabelecimentotalesb.model.domain.Funcionario;

public class FuncionarioDTO {

	private String nome;
	private String login;
	private String senha;
	private String cpf;
	private String email;
	private String telefone;
	private Integer estabelecimentoId;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Integer getEstabelecimentoId() {
		return estabelecimentoId;
	}

	public void setEstabelecimentoId(Integer estabelecimentoId) {
		this.estabelecimentoId = estabelecimentoId;
	}

	public Funcionario toFuncionario() {
		Funcionario func = new Funcionario();
		func.setCpf(this.cpf);
		func.setEmail(this.email);
		func.setTelefone(this.telefone);
		func.setLogin(this.login);
		func.setNome(this.nome);
		func.setSenha(this.senha);
		return func;
	}

}
