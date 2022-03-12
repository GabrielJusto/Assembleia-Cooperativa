package br.con.bonatto.AssembleiaCooperativa.controller.dto;

import java.time.LocalDateTime;
import java.util.List;

import br.con.bonatto.AssembleiaCooperativa.modelo.Sessao;
import br.con.bonatto.AssembleiaCooperativa.modelo.StatusSessao;
import br.con.bonatto.AssembleiaCooperativa.modelo.Voto;

public class SessaoDto 
{

	private long id;
	private LocalDateTime dataCriacao;
	private List<Voto> votos;
	private StatusSessao status;
	
	
	public SessaoDto(Sessao sessao)
	{
		this.id = sessao.getId();
		this.dataCriacao = sessao.getDataCriacao();
		this.votos= sessao.getVotos();
		this.status = sessao.getStatus();
	}

	
	

	public long getId() {
		return id;
	}


	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}


	public List<Voto> getVotos() {
		return votos;
	}


	public StatusSessao getStatus() {
		return status;
	}

	
}
