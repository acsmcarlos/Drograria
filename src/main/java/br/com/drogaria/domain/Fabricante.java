package br.com.drogaria.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@SuppressWarnings("serial")
public class Fabricante extends GenericDomain { //Gerando a chave primaria direto do GenericDomain

	@Column(length = 50, nullable = false)
	private String descricao;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
	
}
