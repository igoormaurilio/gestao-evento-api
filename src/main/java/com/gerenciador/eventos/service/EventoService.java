 package com.gerenciador.eventos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gerenciador.eventos.dto.EventoDTO;
import com.gerenciador.eventos.entities.Eventos;
import com.gerenciador.eventos.repository.EventoRepository;

@Service
public class EventoService {
	@Autowired
    private EventoRepository eventoRepository;
 
    public EventoDTO insert(EventoDTO dto) {
        Eventos entity = new Eventos();
        entity.setNome(dto.getNome());
        entity.setDescricao(dto.getDescricao());
        entity.setLocal(dto.getLocal());
        entity.setData(dto.getData());
        entity.setVagas(dto.getVagas());
 
        entity = eventoRepository.save(entity);
        return new EventoDTO(entity);
    }
 
    public List<EventoDTO> findAll() {
        List<Eventos> lista = eventoRepository.findAll();
        return lista.stream().map(EventoDTO::new).toList();
    }
 
    public Optional<Eventos> getEventoComParticipantes(Long id) {
        return eventoRepository.findById(id);
    }
 
    public EventoDTO update(Long id, EventoDTO dto) {
        Optional<Eventos> optionalEvento = eventoRepository.findById(id);
 
        if (optionalEvento.isPresent()) {
            Eventos entity = optionalEvento.get();
            entity.setNome(dto.getNome());
            entity.setDescricao(dto.getDescricao());
            entity.setLocal(dto.getLocal());
            entity.setData(dto.getData());
            entity.setVagas(dto.getVagas());
 
            entity = eventoRepository.save(entity);
            return new EventoDTO(entity);
        }
 
        return null;
    }
 
    public boolean delete(Long id) {
        Optional<Eventos> optionalEvento = eventoRepository.findById(id);
 
        if (optionalEvento.isPresent()) {
            eventoRepository.delete(optionalEvento.get());
            return true;
        }
 
        return false;
    }
}
 