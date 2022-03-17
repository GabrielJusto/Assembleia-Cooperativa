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

import br.con.bonatto.AssembleiaCooperativa.modelo.Associado;
import br.con.bonatto.AssembleiaCooperativa.repository.AssociadoRepository;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")

public class AssociadoControllerTest {
	
	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private AssociadoRepository associadoRepository; 
	
	@Test
	@Transactional
	public void testeAssociadoController() throws Exception 
	{
		
		String associadoNome = "Associado Teste";
		
		URI uri = new URI("/associados");
		String json = "{ \"nome\" : \""+associadoNome+"\"}";
		
		
		mockMvc.perform(MockMvcRequestBuilders
				.post(uri)
				.content(json)
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers
				.status()
				.is(201));
		
		Associado associado = associadoRepository.findByNome(associadoNome);
		Assert.assertNotNull(associado);
		Assert.assertEquals(associado.getNome(), associadoNome);
		

	}

}
