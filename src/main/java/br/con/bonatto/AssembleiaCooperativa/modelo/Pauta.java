package br.con.bonatto.AssembleiaCooperativa.modelo;

public class Pauta 
{

	private long id;
	private String descricao;
	private Sessao sessao;
	
	
	public Pauta(long id, String descricao, Sessao sessao) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.sessao = sessao;
	}
	public Sessao getSessao() {
		return sessao;
	}
	public long getId() {
		return id;
	}
	public String getDescricao() {
		return descricao;
	}

	
	
	
}
