package br.con.bonatto.AssembleiaCooperativa.controller.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import br.con.bonatto.AssembleiaCooperativa.dto.VotoDto;
import br.con.bonatto.AssembleiaCooperativa.modelo.Sessao;
import br.con.bonatto.AssembleiaCooperativa.modelo.StatusSessao;

public class SessaoDto 
{

	private long id;
	private LocalDateTime dataCriacao;
	private List<VotoDto> votos;
	private StatusSessao status;
	
	
	public SessaoDto(Sessao sessao)
	{
		this.id = sessao.getId();
		this.dataCriacao = sessao.getDataCriacao();
		try {
			this.votos= sessao.getVotos().stream().map(v -> new VotoDto(v)).collect(Collectors.toList());
		} catch (NullPointerException e) {
			// A sessao náo tem votos
		}
		this.status = sessao.getStatus();
	}

	
	

	public long getId() {
		return id;
	}


	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}


	public List<VotoDto> getVotos() {
		return votos;
	}


	public StatusSessao getStatus() {
		return status;
	}

	
}
