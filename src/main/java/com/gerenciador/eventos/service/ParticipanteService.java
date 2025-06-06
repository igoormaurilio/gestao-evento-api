package com.gerenciador.eventos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gerenciador.eventos.dto.ParticipanteDTO;
import com.gerenciador.eventos.entities.Participantes;
import com.gerenciador.eventos.repository.ParticipanteRepository;

@Service
public class ParticipanteService 
{

    @Autowired
    private ParticipanteRepository participanteRepository;

    public ParticipanteDTO insert(ParticipanteDTO dto) 
    {
        Participantes entity = new Participantes();
        entity.setNome(dto.getNome());
        entity.setEmail(dto.getEmail());
        entity.setTelefone(dto.getTelefone());

        entity = participanteRepository.save(entity);
        return new ParticipanteDTO(entity);
    }

    public List<ParticipanteDTO> findAll() 
    {
        List<Participantes> lista = participanteRepository.findAll();
        return lista.stream()
                    .map(ParticipanteDTO::new)
                    .toList();
    }

    public ParticipanteDTO update(Long id, ParticipanteDTO dto) 
    {
        Optional<Participantes> optionalParticipante = participanteRepository.findById(id);

        if (optionalParticipante.isPresent()) 
        {
            Participantes entity = optionalParticipante.get();
            entity.setNome(dto.getNome());
            entity.setEmail(dto.getEmail());
            entity.setTelefone(dto.getTelefone());
            entity = participanteRepository.save(entity);
            return new ParticipanteDTO(entity);
        }

        return null;
    }

    public boolean delete(Long id) 
    {
        Optional<Participantes> optionalParticipante = participanteRepository.findById(id);

        if (optionalParticipante.isPresent()) 
        {
            participanteRepository.delete(optionalParticipante.get());
            return true;
        }

        return false;
    }
}
