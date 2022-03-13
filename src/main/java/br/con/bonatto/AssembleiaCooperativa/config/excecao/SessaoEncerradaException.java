package br.con.bonatto.AssembleiaCooperativa.config.excecao;

import java.time.LocalDateTime;

public class SessaoEncerradaException extends RuntimeException
{

	private static final long serialVersionUID = 1L;
	
	private LocalDateTime dataEncerramento;

	
	public SessaoEncerradaException(LocalDateTime dataEncerramento)
	{
		super("Sess'ao de votacao encerrada na data: "  + dataEncerramento);
		this.dataEncerramento = dataEncerramento;
	}


	public LocalDateTime getDataEncerramento() {
		return dataEncerramento;
	}
	
	
}
