package com.gerenciador.eventos.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.gerenciador.eventos.dto.ParticipanteDTO;
import com.gerenciador.eventos.service.ParticipanteService;

@RestController
@RequestMapping("/api/participantes")
public class ParticipantesController 
{

    @Autowired
    private ParticipanteService participanteService;

    @PostMapping
    public ParticipanteDTO criarParticipante(@RequestBody ParticipanteDTO dto) 
    {
        return participanteService.insert(dto);
    }

    @GetMapping
    public List<ParticipanteDTO> listarParticipantes() 
    {
        return participanteService.findAll();
    }


    @PutMapping("/{id}")
    public ParticipanteDTO atualizarParticipante(@PathVariable Long id, @RequestBody ParticipanteDTO dto) 
    {
        return participanteService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public boolean deletarParticipante(@PathVariable Long id) 
    {
        return participanteService.delete(id);
    }
}
