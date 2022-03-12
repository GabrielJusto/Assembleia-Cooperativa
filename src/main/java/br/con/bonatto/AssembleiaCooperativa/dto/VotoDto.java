package br.con.bonatto.AssembleiaCooperativa.dto;

import br.con.bonatto.AssembleiaCooperativa.modelo.Associado;
import br.con.bonatto.AssembleiaCooperativa.modelo.StatusVoto;
import br.con.bonatto.AssembleiaCooperativa.modelo.Voto;

public class VotoDto 
{

	private long id;
	private StatusVoto status;
	private Associado associado;
	
	
	
	
	public VotoDto (Voto voto)
	{
		this.id = voto.getId();
		this.status = voto.getStatus();
		this.associado = voto.getAssociado();
	}




	public long getId() {
		return id;
	}




	public StatusVoto getStatus() {
		return status;
	}




	public Associado getAssociado() {
		return associado;
	}



	
	
	
}
