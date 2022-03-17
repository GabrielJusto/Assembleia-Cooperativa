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

import br.con.bonatto.AssembleiaCooperativa.modelo.Pauta;
import br.con.bonatto.AssembleiaCooperativa.repository.PautaRepository;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class PautaControllerTest {

	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private PautaRepository pautaRepository; 
	
	@Test
	public void testePautaController() throws Exception 
	{
		
		String pautaDescricao = "Pauta Teste Controller";
		
		URI uri = new URI("/pautas");
		String json = "{ \"descricao\" : \""+pautaDescricao+"\"}";
		
		
		mockMvc.perform(MockMvcRequestBuilders
				.post(uri)
				.content(json)
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers
				.status()
				.is(201));
		
		Optional<Pauta> pauta = pautaRepository.findByDescricao(pautaDescricao);
		Assert.assertTrue(pauta.isPresent());
		Assert.assertEquals(pauta.get().getDescricao(), pautaDescricao);
	}

}
