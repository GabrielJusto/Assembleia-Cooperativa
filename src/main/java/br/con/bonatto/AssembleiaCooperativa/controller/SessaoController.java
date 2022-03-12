package br.con.bonatto.AssembleiaCooperativa.controller;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.con.bonatto.AssembleiaCooperativa.controller.dto.SessaoDto;
import br.con.bonatto.AssembleiaCooperativa.controller.form.PautaAtualizaForm;
import br.con.bonatto.AssembleiaCooperativa.controller.form.SessaoForm;
import br.con.bonatto.AssembleiaCooperativa.modelo.Sessao;
import br.con.bonatto.AssembleiaCooperativa.repository.PautaRepository;
import br.con.bonatto.AssembleiaCooperativa.repository.SessaoRepository;

@RestController
@RequestMapping("/sessao")
public class SessaoController 
{

	@Autowired
	private PautaRepository pautaRepository;
	
	@Autowired
	private SessaoRepository sessaoRepository;
	
	@PostMapping
	public ResponseEntity<SessaoDto> cadastraSessao(@RequestBody @Valid SessaoForm form, UriComponentsBuilder uriBuilder)
	{
		
		Sessao sessao = form.converte(pautaRepository);
		sessaoRepository.save(sessao);
		
		/* Associa a sessao a uma pauta*/
		PautaAtualizaForm pautaAtualiza = new PautaAtualizaForm(sessao);
		pautaAtualiza.atualiza(form.getDescricaoPauta(), pautaRepository);

		
		URI uri = uriBuilder.path("/sessao/{id}").buildAndExpand(sessao.getId()).toUri();
		return ResponseEntity.created(uri).body(new SessaoDto(sessao));
	}
}
