package br.con.bonatto.AssembleiaCooperativa.modelo;

import java.time.LocalDateTime;
import java.util.List;

public class Sessao 
{
	
	private long id;
	private LocalDateTime dataCriacao;
	private List<Voto> votos;
	private long tempoDuracao = 3600000; //1 hora em milissegundos
	private StatusSessao status = StatusSessao.EM_ABERTO;
	
	
	
	
	
	public Sessao(long id, List<Voto> votos) {
		super();
		this.id = id;
		this.votos = votos;
	}
	
	
	public long getTempoDuracao() {
		return tempoDuracao;
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
