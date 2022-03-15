package br.con.bonatto.AssembleiaCooperativa.controller.form;

import java.util.Optional;

import br.con.bonatto.AssembleiaCooperativa.config.excecao.PautaNaoExisteException;
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
		Optional<Pauta> pauta = pautaRepository.findByDescricao(pautaDescricao);
		
		if(pauta.isEmpty())
			throw new PautaNaoExisteException(pautaDescricao);
		
		pauta.get().setSessao(sessao);
		
		return pauta.get();
	}
	
	public Sessao getSessao() {
		return sessao;
	}

	public void setSessao(Sessao sessao) {
		this.sessao = sessao;
	}
	
	
	
	
}
