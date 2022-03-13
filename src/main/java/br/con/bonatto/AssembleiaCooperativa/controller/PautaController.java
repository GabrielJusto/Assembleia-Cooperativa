package br.con.bonatto.AssembleiaCooperativa.controller;

import java.net.URI;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.con.bonatto.AssembleiaCooperativa.controller.dto.PautaDto;
import br.con.bonatto.AssembleiaCooperativa.controller.form.PautaForm;
import br.con.bonatto.AssembleiaCooperativa.dto.PautaDetalheDto;
import br.con.bonatto.AssembleiaCooperativa.modelo.Pauta;
import br.con.bonatto.AssembleiaCooperativa.repository.PautaRepository;
import br.con.bonatto.AssembleiaCooperativa.repository.SessaoRepository;


@RequestMapping("/pauta")
@RestController
public class PautaController 
{

	
	@Autowired
	private PautaRepository pautaRepository;
	
	@Autowired
	private SessaoRepository sessaoRepository;
	
	@PostMapping
	@ResponseBody
	public ResponseEntity<PautaDto> cadastraPauta(@RequestBody  @Valid PautaForm form, UriComponentsBuilder uriBuilder)
	{
		Pauta pauta = form.converte();
		pautaRepository.save(pauta);
		
		URI uri = uriBuilder.path("/pauta/{id}").buildAndExpand(pauta.getId()).toUri();
		return ResponseEntity.created(uri).body(new PautaDto(pauta));
	}
	
	
	@GetMapping("/{id}")
	@Transactional
	public PautaDetalheDto detalhar(@PathVariable long id)
	{
		Pauta pauta = pautaRepository.getById(id);
		pauta.getSessao().verificaFim(sessaoRepository);
		
		
		return new PautaDetalheDto(pauta);
	}
}
