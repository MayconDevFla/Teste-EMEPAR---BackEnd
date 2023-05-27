package com.teste.demo.resources;

import com.teste.demo.entities.Votos;
import com.teste.demo.services.VotosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/votos")
public class VotosResource {

    @Autowired
    private VotosService service;
    @GetMapping
    public ResponseEntity<List<Votos>> findAll(){
        List<Votos> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("{id}")
    public ResponseEntity<Votos> findById(@PathVariable Long id){
        Votos obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Votos> insert(@RequestBody Votos obj){
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Votos> update(@PathVariable Long id, @RequestBody Votos obj){
        obj = service.update(id, obj);
        return ResponseEntity.ok().body(obj);
    }

}
