package br.con.bonatto.AssembleiaCooperativa.repository;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import br.con.bonatto.AssembleiaCooperativa.modelo.Associado;


@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
public class AssociadoRepositoryTest 
{
	
	@Autowired
	private AssociadoRepository repository;

	@Autowired
	private TestEntityManager em;
	
	
	@Test
	public void associadoFindByNameTeste() 
	{
		
		
		String nomeAssociado = "Gabriel";
		
		Associado gabriel = new Associado(nomeAssociado);
		em.persist(gabriel);
		
		
		Associado associado = repository.findByNome(nomeAssociado);
		
		Assert.assertNotNull(associado);
		Assert.assertEquals(nomeAssociado, associado.getNome());
		
	}
	
	@Test
	public void associadoFindByNameNul()
	{
		String nomeAssociado = "Gabriel";
		
		Associado gabriel = new Associado(nomeAssociado);
		em.persist(gabriel);
		
		Associado associado = repository.findByNome("Maria");
		
		Assert.assertNull(associado);
		

	}

}
