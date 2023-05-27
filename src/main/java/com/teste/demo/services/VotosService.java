package com.teste.demo.services;

import com.teste.demo.entities.Votos;

import java.util.List;
import java.util.Optional;

import com.teste.demo.repositories.VotosRepository;
import com.teste.demo.services.exceptions.DatabaseException;
import com.teste.demo.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class VotosService {

    @Autowired
    private VotosRepository repository;

    public List<Votos> findAll(){
        return repository.findAll();
    }

    public Votos findById(Long id){
        Optional<Votos> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Votos insert(Votos obj)    {
        return repository.save(obj);
    }

    public void delete(Long id){
        try {
            repository.deleteById(id);
        }catch (EmptyResultDataAccessException e){
            throw new ResourceNotFoundException(id);
        }catch (DataIntegrityViolationException e){
            throw new DatabaseException(e.getMessage());
        }
    }

    public Votos update(Long id, Votos obj){
        try {
            Votos entity = repository.getReferenceById(id);
            updateData(entity, obj);
            return repository.save(entity);
        } catch (EntityNotFoundException e){
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(Votos entity, Votos obj) {
        entity.setQuant_votos(obj.getQuant_votos());
    }
}
