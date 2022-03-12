package br.con.bonatto.AssembleiaCooperativa.dto;

import br.con.bonatto.AssembleiaCooperativa.modelo.Pauta;
import br.con.bonatto.AssembleiaCooperativa.modelo.Sessao;

public class PautaDetalheDto 
{

	private String descricao;
	private Sessao sessao;
	
	public PautaDetalheDto(Pauta pauta)
	{
		this.descricao = pauta.getDescricao();
		this.sessao = pauta.getSessao();
	}

	public String getDescricao() {
		return descricao;
	}

	public Sessao getSessao() {
		return sessao;
	}
	
	
}
