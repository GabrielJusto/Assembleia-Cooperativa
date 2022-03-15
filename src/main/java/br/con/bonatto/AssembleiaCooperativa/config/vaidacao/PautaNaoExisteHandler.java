package br.con.bonatto.AssembleiaCooperativa.config.vaidacao;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.con.bonatto.AssembleiaCooperativa.config.excecao.PautaNaoExisteException;


@RestControllerAdvice
public class PautaNaoExisteHandler 
{

	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(PautaNaoExisteException.class)
	public PautaNaoExisteDto handle(PautaNaoExisteException e)
	{
		return new PautaNaoExisteDto(e.getDescricaoPauta(),e.getMessage());
	}
}
