package br.con.bonatto.AssembleiaCooperativa.repository;

import java.util.Optional;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import br.con.bonatto.AssembleiaCooperativa.modelo.Pauta;


@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
public class PautaRepositoryTest 
{

	@Autowired
	private PautaRepository repository;
	
	@Autowired
	private TestEntityManager em;
	
	
	@Test
	public void testePautaFindByDescricao() 
	{
		
		String descricaoPauta = "Pauta teste";
		Pauta pauta = new Pauta(descricaoPauta);
		em.persist(pauta);
		
		Optional<Pauta> pautaPesquisa = repository.findByDescricao(descricaoPauta);
		
		Assert.assertTrue(pautaPesquisa.isPresent());
		Assert.assertEquals(pautaPesquisa.get().getDescricao(), descricaoPauta);
	}
	
	@Test
	void testePautaFindByDescricaoNull() 
	{
		
		String descricaoPauta = "Pauta teste";
		Pauta pauta = new Pauta(descricaoPauta);
		em.persist(pauta);
		
		Optional<Pauta> pautaPesquisa = repository.findByDescricao("Segunda Pauta");
		
		Assert.assertTrue(pautaPesquisa.isEmpty());
	}

}
