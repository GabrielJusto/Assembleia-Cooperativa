package br.con.bonatto.AssembleiaCooperativa.controller;

import java.net.URI;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;

import br.con.bonatto.AssembleiaCooperativa.modelo.Pauta;
import br.con.bonatto.AssembleiaCooperativa.repository.PautaRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class SessaoControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private PautaRepository pautaRepository;

	@Test
	@Transactional
	public void testeSessaoRepository() throws Exception 
	{
		
		String pautaDescricao = "Pauta Sessao Teste";
		Pauta pauta = new Pauta(pautaDescricao);
		pautaRepository.save(pauta);
		
		URI uri = new URI("/sessoes");
		String json = "{ \"descricaoPauta\" : \""+pautaDescricao+"\"}";
		
		
		mockMvc.perform(MockMvcRequestBuilders
				.post(uri)
				.content(json)
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers
				.status()
				.is(201));
		
		Pauta pautaResult = pautaRepository.getById(pauta.getId());
		Assert.assertNotNull(pautaResult.getSessao());
		
		
	}
	
	@Test
	@Transactional
	public void testePautaNaoExiste() throws Exception 
	{
		
		String pautaDescricao = "Pauta Sessao Teste Pauta Nao Existe";
		String descricapPautaNaoExiste = "Pauta Sessao Nao Existe";
		Pauta pauta = new Pauta(pautaDescricao);
		pautaRepository.save(pauta);
		
		URI uri = new URI("/sessoes");
		String json = "{ \"descricaoPauta\" : \""+descricapPautaNaoExiste+"\"}";
		
		
		mockMvc.perform(MockMvcRequestBuilders
				.post(uri)
				.content(json)
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers
				.status()
				.is(400));
		
		Pauta pautaResult = pautaRepository.getById(pauta.getId());
		Assert.assertNull(pautaResult.getSessao());
		
		
	}

}
