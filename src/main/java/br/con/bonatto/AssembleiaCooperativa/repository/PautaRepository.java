package br.con.bonatto.AssembleiaCooperativa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.con.bonatto.AssembleiaCooperativa.modelo.Pauta;

public interface PautaRepository extends JpaRepository<Pauta, Long> {

	Pauta findByDescricao(String descricaoPauta);
	
}
