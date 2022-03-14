package br.con.bonatto.AssembleiaCooperativa.modelo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import br.con.bonatto.AssembleiaCooperativa.repository.SessaoRepository;


@Entity
public class Sessao 
{
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private LocalDateTime dataCriacao = LocalDateTime.now();
	
	@OneToMany(mappedBy = "sessao")
	private List<Voto> votos;
	
	private Long tempoDuracao = Long.parseLong("60"); //tempo em segundos
	
	@Enumerated(EnumType.STRING)
	private StatusSessao status = StatusSessao.EM_ABERTO;
	
	
	
	
	public Sessao(Long tempoDuracao)
	{	
		if(tempoDuracao != null)
			this.tempoDuracao = tempoDuracao;
		
	}

	
	public Sessao() {}
	

	public void addVoto (Voto voto)
	{
		if(votos == null)
			votos = new ArrayList<>();
		votos.add(voto);
	}
	
	
	public boolean verificaFim(SessaoRepository sessaoRepository)
	{

		if(votos != null && dataCriacao.plusSeconds(tempoDuracao).isBefore(LocalDateTime.now()))
		{
			long votosSim = votos.stream().filter(v -> v.getStatus() == StatusVoto.SIM).count();
			long votosNao = votos.stream().filter(v -> v.getStatus() == StatusVoto.NAO).count();
			
			if(votosSim > votosNao)
				status = StatusSessao.APROVADA;
			else
				status = StatusSessao.RECUSADA;
			
			
			sessaoRepository.save(this);
			return true;
		}
		return false;
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


	public void setStatus(StatusSessao status) {
		this.status = status;
	}


	
	
}
