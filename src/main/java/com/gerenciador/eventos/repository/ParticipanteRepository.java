package com.gerenciador.eventos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gerenciador.eventos.entities.Participantes;

public interface ParticipanteRepository extends JpaRepository<Participantes, Long>{

}
