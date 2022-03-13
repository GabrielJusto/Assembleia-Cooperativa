package br.con.bonatto.AssembleiaCooperativa.config.vaidacao;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.con.bonatto.AssembleiaCooperativa.config.excecao.SessaoEncerradaException;
import br.con.bonatto.AssembleiaCooperativa.dto.SessaoEncerradaDto;

@RestControllerAdvice
public class SessaoEncerradaHandler 
{

	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(SessaoEncerradaException.class)
	public SessaoEncerradaDto handle(SessaoEncerradaException e)
	{
		return new SessaoEncerradaDto(e.getMessage(), e.getDataEncerramento());
	}
}

