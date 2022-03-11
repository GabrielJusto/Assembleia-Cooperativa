package br.con.bonatto.AssembleiaCooperativa.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Associado 
{
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String nome;
	
	
	public long getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	
	
	
	

}
