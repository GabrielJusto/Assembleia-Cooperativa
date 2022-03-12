package br.con.bonatto.AssembleiaCooperativa.config.excecao;

public class AssociadoJaVotouException extends RuntimeException {


	private static final long serialVersionUID = 1L;
	
	private String associado;
	private String pauta;
	
	public AssociadoJaVotouException(String associado, String pauta)
	{
		super("Associado " + associado +" já votou na pauta " + pauta);
		this.associado = associado;
		this.pauta = pauta;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getAssociado() {
		return associado;
	}

	public String getPauta() {
		return pauta;
	}

	
}
