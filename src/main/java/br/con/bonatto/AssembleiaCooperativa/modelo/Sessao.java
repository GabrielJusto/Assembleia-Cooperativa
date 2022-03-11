package br.con.bonatto.AssembleiaCooperativa.modelo;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity
public class Sessao 
{
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private LocalDateTime dataCriacao = LocalDateTime.now();
	
	@OneToMany(mappedBy = "sessao")
	private List<Voto> votos;
	
	private long tempoDuracao = 3600000; //1 hora em milissegundos
	
	@Enumerated(EnumType.STRING)
	private StatusSessao status = StatusSessao.EM_ABERTO;
	
	@OneToOne
	private Pauta pauta;
	
	
	
	
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
	public Pauta getPauta() {
		return pauta;
	}
	
	
	
	
	
}
