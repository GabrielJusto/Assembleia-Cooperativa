package br.con.bonatto.AssembleiaCooperativa.dto;

import br.con.bonatto.AssembleiaCooperativa.controller.dto.SessaoDto;
import br.con.bonatto.AssembleiaCooperativa.modelo.Pauta;

public class PautaDetalheDto 
{

	private String descricao;
	private SessaoDto sessao;
	
	public PautaDetalheDto(Pauta pauta)
	{
		this.descricao = pauta.getDescricao();
		this.sessao = new SessaoDto(pauta.getSessao());
	}

	public String getDescricao() {
		return descricao;
	}

	public SessaoDto getSessao() {
		return sessao;
	}
	
	
}
