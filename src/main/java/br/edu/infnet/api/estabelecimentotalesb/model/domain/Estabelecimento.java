package br.edu.infnet.api.estabelecimentotalesb.model.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "TEstabelecimento", uniqueConstraints = @UniqueConstraint(columnNames = { "cnpj" }))
public class Estabelecimento extends Usuario {

	private String cnpj;
	private String endereco;
	private boolean edtech;

	@OneToMany(cascade = CascadeType.REMOVE, orphanRemoval = true)
	@JoinColumn(name = "idEstabelecimento")
	@JsonManagedReference
	private List<Funcionario> funcionarios;

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public boolean isEdtech() {
		return edtech;
	}

	public void setEdtech(boolean edtech) {
		this.edtech = edtech;
	}

	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}

}
