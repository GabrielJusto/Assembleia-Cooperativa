package br.con.bonatto.AssembleiaCooperativa.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.con.bonatto.AssembleiaCooperativa.controller.dto.PautaDto;
import br.con.bonatto.AssembleiaCooperativa.controller.form.PautaForm;
import br.con.bonatto.AssembleiaCooperativa.modelo.Pauta;
import br.con.bonatto.AssembleiaCooperativa.repository.PautaRepository;


@RequestMapping("/pauta")
@RestController
public class PautaController 
{

	
	@Autowired
	private PautaRepository pautaRepository;
	
	@PostMapping
	@ResponseBody
	public ResponseEntity<PautaDto> cadastraPauta(@RequestBody PautaForm form, UriComponentsBuilder uriBuilder)
	{
		Pauta pauta = form.converte();
		pautaRepository.save(pauta);
		
		URI uri = uriBuilder.path("/pauta/{id}").buildAndExpand(pauta.getId()).toUri();
		return ResponseEntity.created(uri).body(new PautaDto(pauta));
	}
}
