package com.gerenciador.eventos.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gerenciador.eventos.dto.EventoDTO;
import com.gerenciador.eventos.entities.Eventos;
import com.gerenciador.eventos.service.EventoService;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/api/eventos")
public class EventoController 
{
    @Autowired
    private EventoService eventoService;

    @PostMapping
    public EventoDTO criarEvento(@RequestBody EventoDTO dto) 
    {
        return eventoService.insert(dto);
    }

    @Transactional
    @PostMapping("/{idEvento}/participantes")
    public ResponseEntity<String> inscreverMultiplesParticipantes(
    @PathVariable Long idEvento,
    @RequestBody List<Long> idsParticipantes) 
    {

        boolean sucesso = eventoService.inscreverParticipantesPorIds(idEvento, idsParticipantes);

        if (sucesso) 
        {
            return ResponseEntity.ok("Participantes inscritos com sucesso!");
        } else 
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Evento cheio ou dados inválidos.");
        }
    }

    
    @GetMapping
    public List<EventoDTO> listarEventos() 
    {
        return eventoService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Eventos> buscarEventoPorId(@PathVariable Long id) 
    {
        return eventoService.getEventoComParticipantes(id);
    }


    @PutMapping("/{id}")
    public EventoDTO atualizarEvento(@PathVariable Long id, @RequestBody EventoDTO dto) 
    {
        return eventoService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public boolean deletarEvento(@PathVariable Long id) 
    {
        return eventoService.delete(id);
    }
}
