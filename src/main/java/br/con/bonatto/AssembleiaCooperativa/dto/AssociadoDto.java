package br.con.bonatto.AssembleiaCooperativa.dto;

import br.con.bonatto.AssembleiaCooperativa.modelo.Associado;

public class AssociadoDto 
{
	
	private long id;
	private String nome;
	
	
	public AssociadoDto(Associado associado)
	{
		this.id = associado.getId();
		this.nome = associado.getNome();
	}


	public long getId() {
		return id;
	}


	public String getNome() {
		return nome;
	}
	
	
	
}
