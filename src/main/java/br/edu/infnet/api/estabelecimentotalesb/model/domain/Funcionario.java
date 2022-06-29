package br.edu.infnet.api.estabelecimentotalesb.model.domain;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import br.edu.infnet.api.estabelecimentotalesb.model.domain.dto.FuncionarioDTO;

@Entity
@Table(name = "TFuncionario", uniqueConstraints = @UniqueConstraint(columnNames = { "cpf" }))
public class Funcionario extends Usuario {

	private String cpf;
	private String email;
	private String telefone;

	@ManyToOne
	@JoinColumn(name = "idEstabelecimento")
	@JsonBackReference
	private Estabelecimento estabelecimento;

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

	public Estabelecimento getEstabelecimento() {
		return estabelecimento;
	}

	public void setEstabelecimento(Estabelecimento estabelecimento) {
		this.estabelecimento = estabelecimento;
	}

	public static Funcionario toFuncionario(FuncionarioDTO funcionarioDTO) {

		Funcionario funcionario = new Funcionario();
		funcionario.setLogin(funcionarioDTO.getLogin());
		funcionario.setSenha(funcionarioDTO.getSenha());
		funcionario.setNome(funcionarioDTO.getSenha());
		funcionario.setCpf(funcionarioDTO.getCpf());
		funcionario.setTelefone(funcionarioDTO.getTelefone());
		funcionario.setEmail(funcionarioDTO.getEmail());

		return funcionario;

	}

}
