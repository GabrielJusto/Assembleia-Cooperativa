package br.con.bonatto.AssembleiaCooperativa.config.excecao;

public class PautaNaoExisteException extends RuntimeException{


	private static final long serialVersionUID = 1L;
	
	private String descricaoPauta;
	
	public PautaNaoExisteException(String descricaoPauta)
	{
		super("A pauta com descrição " + descricaoPauta + " não existe ");
		this.descricaoPauta = descricaoPauta;
	}


	public String getDescricaoPauta() {
		return descricaoPauta;
	}

	
	
	
}
