package br.con.bonatto.AssembleiaCooperativa.controller;

import java.net.URI;
import java.util.Optional;

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

import br.con.bonatto.AssembleiaCooperativa.modelo.Associado;
import br.con.bonatto.AssembleiaCooperativa.modelo.Pauta;
import br.con.bonatto.AssembleiaCooperativa.modelo.Sessao;
import br.con.bonatto.AssembleiaCooperativa.modelo.StatusVoto;
import br.con.bonatto.AssembleiaCooperativa.repository.AssociadoRepository;
import br.con.bonatto.AssembleiaCooperativa.repository.PautaRepository;
import br.con.bonatto.AssembleiaCooperativa.repository.SessaoRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class VotoControllerTest 
{

	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private PautaRepository pautaRepository;

	@Autowired
	private SessaoRepository sessaoRepository;
	
	@Autowired
	private AssociadoRepository associadoRepository;
	
	
	@Test
	@Transactional
	public void testeVoto() throws Exception 
	{
		String nomeAssociado = "Gabriel";
		String pautaDescricao = "Pauta Teste";
		Pauta pauta = new Pauta("Pauta Teste");
		Sessao sessao = new Sessao();
		
		pautaRepository.save(pauta);
		
		Optional<Pauta> resultPauta = pautaRepository.findByDescricao(pautaDescricao);
		resultPauta.get().setSessao(sessao);
		sessaoRepository.save(sessao);
		pautaRepository.save(resultPauta.get());
		
		
		associadoRepository.save(new Associado(nomeAssociado));
		
		
	
		
		
		URI uri = new URI("/votos");
		String json = "{ \"statusVoto\":\"NAO\", \"nomeAssociado\":\""+nomeAssociado+ "\", \"descricaoPauta\":\""+pautaDescricao+"\"}";
		
		
		mockMvc.perform(MockMvcRequestBuilders
				.post(uri)
				.content(json)
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers
				.status()
				.is(201));
		
		Sessao sessaoResult = sessaoRepository.getById(sessao.getId());
		Assert.assertNotNull(sessaoResult.getVotos());
		Assert.assertEquals(sessaoResult.getVotos().size(), 1);
		Assert.assertEquals(sessaoResult.getVotos().get(0).getStatus(), StatusVoto.NAO);

		
	}
	
	@Test
	public void testeVotoRepetido() throws Exception 
	{
	
		String nomeAssociado = "Gabriel";
		String pautaDescricao = "Pauta Teste";
		
		URI uri = new URI("/votos");
		String json = "{ \"statusVoto\":\"NAO\", \"nomeAssociado\":\""+nomeAssociado+ "\", \"descricaoPauta\":\""+pautaDescricao+"\"}";
		

		
		mockMvc.perform(MockMvcRequestBuilders
				.post(uri)
				.content(json)
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers
				.status()
				.is(400));
		
	}
	
	@Test
	public void testeSessaoEncerrda() throws Exception 
	{
	
		String nomeAssociado = "Maria";
		String pautaDescricao = "Pauta Sessao Encerrada";
		Pauta pauta = new Pauta(pautaDescricao);
		Sessao sessao = new Sessao(0l);
		
		
		
		associadoRepository.save(new Associado(nomeAssociado));
		pautaRepository.save(pauta);
		
		Optional<Pauta> resultPauta = pautaRepository.findByDescricao(pautaDescricao);
		resultPauta.get().setSessao(sessao);
		sessaoRepository.save(sessao);
		pautaRepository.save(resultPauta.get());
		
		
		
		URI uri = new URI("/votos");
		String json = "{ \"statusVoto\":\"NAO\", \"nomeAssociado\":\""+nomeAssociado+ "\", \"descricaoPauta\":\""+pautaDescricao+"\"}";
		

		
		mockMvc.perform(MockMvcRequestBuilders
				.post(uri)
				.content(json)
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers
				.status()
				.is(400));
		
	}
	
	
	@Test
	public void testePautaNaoExiste() throws Exception 
	{
	
		String nomeAssociado = "Joao";
		String pautaDescricao = "Pauta Existe";
		String pautaNaoExiste = "Nao existe";
		Pauta pauta = new Pauta(pautaDescricao);
		Sessao sessao = new Sessao();
		
		
		
		associadoRepository.save(new Associado(nomeAssociado));
		pautaRepository.save(pauta);
		
		Optional<Pauta> resultPauta = pautaRepository.findByDescricao(pautaDescricao);
		resultPauta.get().setSessao(sessao);
		sessaoRepository.save(sessao);
		pautaRepository.save(resultPauta.get());
		
		
		
		URI uri = new URI("/votos");
		String json = "{ \"statusVoto\":\"NAO\", \"nomeAssociado\":\""+nomeAssociado+ "\", \"descricaoPauta\":\""+pautaNaoExiste+"\"}";
		

		
		mockMvc.perform(MockMvcRequestBuilders
				.post(uri)
				.content(json)
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers
				.status()
				.is(400));
		
	}

}
