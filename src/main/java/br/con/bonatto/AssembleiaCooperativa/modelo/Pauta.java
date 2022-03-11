package br.con.bonatto.AssembleiaCooperativa.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Pauta 
{

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String descricao;
	
	@OneToOne
	private Sessao sessao;


	
	
	public Pauta() {}
	
	public Pauta(String descricao)
	{
		this.descricao = descricao;
	}
	
	public long getId() {
		return id;
	}

	public String getDescricao() {
		return descricao;
	}

	public Sessao getSessao() {
		return sessao;
	}


	
	

	
	
	
}
