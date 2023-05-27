package com.teste.demo.repositories;

import com.teste.demo.entities.Votos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VotosRepository extends JpaRepository<Votos, Long> {

}
