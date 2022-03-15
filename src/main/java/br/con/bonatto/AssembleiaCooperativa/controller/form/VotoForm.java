package br.con.bonatto.AssembleiaCooperativa.controller.form;

import java.util.Optional;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.con.bonatto.AssembleiaCooperativa.config.excecao.AssociadoJaVotouException;
import br.con.bonatto.AssembleiaCooperativa.config.excecao.PautaNaoExisteException;
import br.con.bonatto.AssembleiaCooperativa.config.vaidacao.Voto;
import br.con.bonatto.AssembleiaCooperativa.modelo.Associado;
import br.con.bonatto.AssembleiaCooperativa.modelo.Pauta;
import br.con.bonatto.AssembleiaCooperativa.modelo.StatusVoto;
import br.con.bonatto.AssembleiaCooperativa.repository.AssociadoRepository;
import br.con.bonatto.AssembleiaCooperativa.repository.PautaRepository;

public class VotoForm 
{
	
	@NotEmpty @NotNull @Voto
	private String statusVoto;
	
	@NotEmpty @NotNull
	private String nomeAssociado;
	
	@NotEmpty @NotNull
	private String descricaoPauta;

	

	public br.con.bonatto.AssembleiaCooperativa.modelo.Voto converte(
			AssociadoRepository associadoRepository, PautaRepository pautaRepository) throws AssociadoJaVotouException
	{
		
		Associado associado = associadoRepository.findByNome(nomeAssociado);
		Optional<Pauta> pauta = pautaRepository.findByDescricao(descricaoPauta);
		if(pauta.isEmpty())
			throw new PautaNaoExisteException(descricaoPauta);
		
		StatusVoto statusVoto = StatusVoto.parseStatusVoto(this.statusVoto);
		
		try {
			if(pauta.get().getSessao().getVotos().stream().anyMatch(v -> v.getAssociado().getId() == associado.getId()))
				throw new AssociadoJaVotouException(nomeAssociado, descricaoPauta);
		} catch (NullPointerException e) {
			//Não tem votos cadastrados ainda, não precisa lidar com essa exceção
		}
		
		return new br.con.bonatto.AssembleiaCooperativa.modelo.Voto(statusVoto, associado, pauta.get().getSessao());
				
	}
	
	public String getStatusVoto() {
		return statusVoto;
	}

	public String getNomeAssociado() {
		return nomeAssociado;
	}

	public String getDescricaoPauta() {
		return descricaoPauta;
	}


	
	
}
