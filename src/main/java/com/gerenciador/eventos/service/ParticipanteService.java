package com.gerenciador.eventos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.gerenciador.eventos.dto.ParticipanteDTO;
import com.gerenciador.eventos.entities.Participantes;
import com.gerenciador.eventos.repository.ParticipanteRepository;

public class ParticipanteService {
	
	@Autowired
	ParticipanteRepository participanteRepository;
	
	public ParticipanteDTO insert(ParticipanteDTO dto) {
	      Participantes entity = new Participantes();
	      entity.setNome(dto.getNome());
	      entity.setEmail(dto.getEmail());;
	      entity.setTelefone(dto.getTelefone());;
	      
	     
	      entity = participanteRepository.save(entity);
	      return new ParticipanteDTO(entity);
	  }
	
	   public List<ParticipanteDTO> findAll() {
	        List<Participantes> lista = participanteRepository.findAll();
	        return lista.stream().map(x -> new ParticipanteDTO(x)).toList();
	    }
	   public ParticipanteDTO update(Long id, ParticipanteDTO dto) {
	        Optional<Participantes> optionalProduto = participanteRepository.findById(id);
	        
	        if (optionalProduto.isPresent()) {
	            Participantes entity = optionalProduto.get();
	            entity.setNome(dto.getNome());
	            entity.setEmail(dto.getEmail());
	            entity.setTelefone(dto.getTelefone());
	          
	            
	            entity = participanteRepository.save(entity);
	            return new ParticipanteDTO(entity);
	        
	        }
	        return null;
	        
	    }
	   public boolean delete(Long id) {
	        Optional<Participantes> optionalProduto = participanteRepository.findById(id);
	        
	        if (optionalProduto.isPresent()) {
	            participanteRepository.delete(optionalProduto.get());
	            return true;
	        }
	        
	        return false;
	    }
 
}


