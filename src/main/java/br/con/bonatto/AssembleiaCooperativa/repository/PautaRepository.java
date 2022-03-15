package br.con.bonatto.AssembleiaCooperativa.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.con.bonatto.AssembleiaCooperativa.modelo.Pauta;

public interface PautaRepository extends JpaRepository<Pauta, Long> {

	Optional<Pauta> findByDescricao(String descricaoPauta);
	
}
