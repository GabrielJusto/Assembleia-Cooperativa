package br.con.bonatto.AssembleiaCooperativa.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.con.bonatto.AssembleiaCooperativa.modelo.Associado;

public class AssociadoForm 
{

	@NotNull @NotEmpty
	private String nome;
	
	public Associado converte()
	{
		return new Associado(nome);
	}

	public String getNome() {
		return nome;
	}
	
	
}
