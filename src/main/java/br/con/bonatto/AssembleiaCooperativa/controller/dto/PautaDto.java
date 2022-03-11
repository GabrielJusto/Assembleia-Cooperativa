package br.con.bonatto.AssembleiaCooperativa.controller.dto;

import br.con.bonatto.AssembleiaCooperativa.modelo.Pauta;

public class PautaDto 
{
	
	private long id;
	private String descricao;
	
	public PautaDto(Pauta pauta)
	{
		
		this.id = pauta.getId();
		this.descricao = pauta.getDescricao();
	}

	public long getId() {
		return id;
	}

	public String getDescricao() {
		return descricao;
	}
	
	

}
