package br.con.bonatto.AssembleiaCooperativa.config.vaidacao;

public class AssociadoJaVotouDto 
{

	private String erro;
	private String associado;
	private String pauta;
	public AssociadoJaVotouDto(String erro, String associado, String pauta) {
		super();
		this.erro = erro;
		this.associado = associado;
		this.pauta = pauta;
	}
	public String getErro() {
		return erro;
	}
	public String getAssociado() {
		return associado;
	}
	public String getPauta() {
		return pauta;
	}
	
	
}
