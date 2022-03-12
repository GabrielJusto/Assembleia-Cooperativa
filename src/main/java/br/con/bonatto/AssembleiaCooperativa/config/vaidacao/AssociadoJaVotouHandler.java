package br.con.bonatto.AssembleiaCooperativa.config.vaidacao;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.con.bonatto.AssembleiaCooperativa.config.excecao.AssociadoJaVotouException;

@RestControllerAdvice
public class AssociadoJaVotouHandler 
{

	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(AssociadoJaVotouException.class)
	public AssociadoJaVotouDto handle(AssociadoJaVotouException exception)
	{
		return new AssociadoJaVotouDto(exception.getMessage(), exception.getAssociado(), exception.getPauta());
	}
}
