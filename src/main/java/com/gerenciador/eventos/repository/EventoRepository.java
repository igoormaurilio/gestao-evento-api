package com.gerenciador.eventos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gerenciador.eventos.entities.Eventos;

public interface EventoRepository extends JpaRepository  <Eventos, Long>{

}
