package br.con.bonatto.AssembleiaCooperativa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.con.bonatto.AssembleiaCooperativa.modelo.Associado;

public interface AssociadoRepository extends JpaRepository<Associado, Long>{

	public Associado findByNome(String name);
}
