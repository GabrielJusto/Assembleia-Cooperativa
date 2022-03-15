package br.con.bonatto.AssembleiaCooperativa.config.vaidacao;

public class PautaNaoExisteDto 
{

	private String descricaoPauta;
	
	private String mensagem;

	
	
	public PautaNaoExisteDto(String descricaoPauta, String mensagem) {
		super();
		this.descricaoPauta = descricaoPauta;
		this.mensagem = mensagem;
	}

	public String getDescricaoPauta() {
		return descricaoPauta;
	}

	public String getMensagem() {
		return mensagem;
	}
	
	
}
