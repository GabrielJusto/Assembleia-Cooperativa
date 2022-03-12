package br.con.bonatto.AssembleiaCooperativa.controller.form;

import br.con.bonatto.AssembleiaCooperativa.modelo.Pauta;
import br.con.bonatto.AssembleiaCooperativa.modelo.Sessao;
import br.con.bonatto.AssembleiaCooperativa.repository.PautaRepository;

public class PautaAtualizaForm 
{

	private Sessao sessao;

	public PautaAtualizaForm() {}
	
	public PautaAtualizaForm(Sessao sessao)
	{
		this.sessao = sessao;
	}
	
	public Pauta atualiza(String pautaDescricao, PautaRepository pautaRepository)
	{
		Pauta pauta = pautaRepository.findByDescricao(pautaDescricao);
		pauta.setSessao(sessao);
		
		return pauta;
	}
	
	public Sessao getSessao() {
		return sessao;
	}

	public void setSessao(Sessao sessao) {
		this.sessao = sessao;
	}
	
	
	
	
}
