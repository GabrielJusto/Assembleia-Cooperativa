package br.con.bonatto.AssembleiaCooperativa.modelo;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import br.con.bonatto.AssembleiaCooperativa.config.excecao.SessaoEncerradaException;
import br.con.bonatto.AssembleiaCooperativa.controller.form.SessaoAtualizaForm;
import br.con.bonatto.AssembleiaCooperativa.repository.SessaoRepository;

@Entity
public class Voto 
{
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Enumerated(EnumType.STRING)
	private StatusVoto status;
	
	@ManyToOne
	private Associado associado;
	
	@ManyToOne
	private Sessao sessao;
	
	
	
	public Voto(StatusVoto status, Associado associado, Sessao sessao) {
		super();
		this.status = status;
		this.associado = associado;
		this.sessao = sessao;
	}

	public Voto() {}

	
	public void validaVoto(SessaoRepository sessaoRepository)
	{

		if(sessao.verificaFim(sessaoRepository))
			throw new SessaoEncerradaException(
					sessao.getDataCriacao().plusSeconds(sessao.getTempoDuracao()));
	}
	
	public void associaSessao()
	{
		SessaoAtualizaForm sessaoAtualiza = new SessaoAtualizaForm(this);
		sessaoAtualiza.atualiza(sessao);
	}
	
	
	public StatusVoto getStatus() {
		return status;
	}

	public long getId() {
		return id;
	}
	
	public Associado getAssociado() {
		return associado;
	}

	public Sessao getSessao() {
		return sessao;
	}
	
	
	
}
