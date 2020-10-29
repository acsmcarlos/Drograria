package br.com.drogaria.domain;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

//Classe pai nunca será uma tabela, somente a classe filha
@SuppressWarnings("serial")
@MappedSuperclass //notação para dizer que essa classe nao corresponde a uma tabela, mas será utilizada por outros para gerar tabelas.
public class GenericDomain implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long codigo;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	
	

}
