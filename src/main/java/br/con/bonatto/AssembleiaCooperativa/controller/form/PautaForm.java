package br.con.bonatto.AssembleiaCooperativa.controller.form;

import br.con.bonatto.AssembleiaCooperativa.modelo.Pauta;

public class PautaForm 
{

	private String descricao;

	public String getDescricao() {
		return descricao;
	}
	
	public Pauta converte()
	{
		return new Pauta(descricao);
	}
}
