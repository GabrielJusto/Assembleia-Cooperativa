package br.con.bonatto.AssembleiaCooperativa.controller.form;

import br.con.bonatto.AssembleiaCooperativa.modelo.Sessao;
import br.con.bonatto.AssembleiaCooperativa.modelo.Voto;

public class SessaoAtualizaForm 
{
	Voto voto;
	
	public SessaoAtualizaForm(Voto voto)
	{
		this.voto = voto;
	}

	
	
	public void atualiza(Sessao sessao) 
	{	
		sessao.addVoto(voto);
	}
	
	
	
	public Voto getVoto() {
		return voto;
	}
	
	
	
	
}
