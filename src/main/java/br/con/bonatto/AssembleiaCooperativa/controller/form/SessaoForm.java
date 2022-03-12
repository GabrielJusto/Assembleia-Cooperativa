package br.con.bonatto.AssembleiaCooperativa.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.con.bonatto.AssembleiaCooperativa.modelo.Sessao;
import br.con.bonatto.AssembleiaCooperativa.repository.PautaRepository;

public class SessaoForm 
{

	private Long tempoDuracao;
	
	@NotEmpty @NotNull
	private String descricaoPauta;

	
	
	public Sessao converte(PautaRepository pautaRepository)
	{
		return new Sessao(tempoDuracao);
	}
	
	
	public long getTempoDuracao() {
		return tempoDuracao;
	}

	public String getDescricaoPauta() {
		return descricaoPauta;
	}
	
	
	
	
}
