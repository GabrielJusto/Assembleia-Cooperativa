package br.con.bonatto.AssembleiaCooperativa.config.vaidacao;

public class ErroFormularioDto 
{
	private String campo;
	private String erro;
	
	
	public ErroFormularioDto(String campo, String erro) {
		super();
		this.campo = campo;
		this.erro = erro;
	}


	public String getCampo() {
		return campo;
	}


	public String getErro() {
		return erro;
	}
	
	
	
	
}
