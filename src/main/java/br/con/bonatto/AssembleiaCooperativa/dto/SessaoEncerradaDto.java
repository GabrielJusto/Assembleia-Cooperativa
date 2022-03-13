package br.con.bonatto.AssembleiaCooperativa.dto;

import java.time.LocalDateTime;

public class SessaoEncerradaDto 
{

	private String mensagem;
	private LocalDateTime dataEncerramento;
	
	public SessaoEncerradaDto(String mensagem, LocalDateTime dataEncerramento) {
		super();
		this.mensagem = mensagem;
		this.dataEncerramento = dataEncerramento;
	}
	public String getMensagem() {
		return mensagem;
	}
	public LocalDateTime getDataEncerramento() {
		return dataEncerramento;
	}
	
	
}
