package br.con.bonatto.AssembleiaCooperativa.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Voto 
{
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private boolean votoSim;
	
	@ManyToOne
	private Associado associado;
	
	@ManyToOne
	private Sessao sessao;
	
	
	public long getId() {
		return id;
	}
	public boolean isVotoSim() {
		return votoSim;
	}
	public Associado getAssociado() {
		return associado;
	}
	public Sessao getSessao() {
		return sessao;
	}
	
	
	
}
