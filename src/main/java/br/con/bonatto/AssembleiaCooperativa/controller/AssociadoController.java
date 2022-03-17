package br.con.bonatto.AssembleiaCooperativa.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.con.bonatto.AssembleiaCooperativa.controller.form.AssociadoForm;
import br.con.bonatto.AssembleiaCooperativa.dto.AssociadoDto;
import br.con.bonatto.AssembleiaCooperativa.modelo.Associado;
import br.con.bonatto.AssembleiaCooperativa.repository.AssociadoRepository;

@RestController
@RequestMapping("/associados")
public class AssociadoController 
{

	@Autowired
	private AssociadoRepository associadoRepository;
	
	@PostMapping
	public ResponseEntity<AssociadoDto> cadastraAssociado(@RequestBody @Validated AssociadoForm form, UriComponentsBuilder uriBuilder)
	{
		Associado associado = form.converte();
		associadoRepository.save(associado);
		
		
		URI uri = uriBuilder.path("/associado/{id}").buildAndExpand(associado.getId()).toUri();
		return ResponseEntity.created(uri).body(new AssociadoDto(associado));
		
	}
}
