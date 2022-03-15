package br.con.bonatto.AssembleiaCooperativa.controller;

import java.net.URI;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.con.bonatto.AssembleiaCooperativa.controller.form.VotoForm;
import br.con.bonatto.AssembleiaCooperativa.dto.VotoDto;
import br.con.bonatto.AssembleiaCooperativa.modelo.Voto;
import br.con.bonatto.AssembleiaCooperativa.repository.AssociadoRepository;
import br.con.bonatto.AssembleiaCooperativa.repository.PautaRepository;
import br.con.bonatto.AssembleiaCooperativa.repository.SessaoRepository;
import br.con.bonatto.AssembleiaCooperativa.repository.VotoRepository;

@RestController
@RequestMapping("/voto")
public class VotoController 
{

	@Autowired
	private AssociadoRepository associadoRepository;
	
	@Autowired
	private PautaRepository pautaRepository;
	
	@Autowired
	private VotoRepository votoRepository;
	
	@Autowired
	private SessaoRepository sessaoRepository;
	
	@PostMapping
	@Transactional
	public ResponseEntity<VotoDto> cadastraVoto(@RequestBody @Validated VotoForm form, UriComponentsBuilder uriBuilder)
	{
		Voto voto = form.converte(associadoRepository, pautaRepository);
		voto.validaVoto(sessaoRepository);
		votoRepository.save(voto);
		voto.associaSessao();
	
		URI uri = uriBuilder.path("/voto/{id}").buildAndExpand(voto.getId()).toUri();
		return ResponseEntity.created(uri).body(new VotoDto(voto));
	}
	
	
}




















