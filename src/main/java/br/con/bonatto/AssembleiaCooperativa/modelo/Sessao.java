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


@Entity
public class Sessao 
{
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private LocalDateTime dataCriacao = LocalDateTime.now();
	
	@OneToMany(mappedBy = "sessao")
	private List<Voto> votos;
	
	private Long tempoDuracao = Long.parseLong("3600000"); //1 hora em milissegundos
	
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
