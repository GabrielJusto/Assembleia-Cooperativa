package br.con.bonatto.AssembleiaCooperativa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import br.con.bonatto.AssembleiaCooperativa.modelo.Pauta;
import br.con.bonatto.AssembleiaCooperativa.modelo.Sessao;

@Controller
public class PautaController 
{

	
	@RequestMapping("/nova-pauta")
	@ResponseBody
	public Pauta retrnaPauta()
	{
		Pauta pauta = new Pauta(1, "Pauta", new Sessao(1, null));
		return pauta;
	}
}
