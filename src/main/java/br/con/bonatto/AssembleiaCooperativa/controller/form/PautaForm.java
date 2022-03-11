package br.con.bonatto.AssembleiaCooperativa.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.con.bonatto.AssembleiaCooperativa.modelo.Pauta;

public class PautaForm 
{
	@NotNull @NotEmpty
	private String descricao;

	public String getDescricao() {
		return descricao;
	}
	
	public Pauta converte()
	{
		return new Pauta(descricao);
	}
}
