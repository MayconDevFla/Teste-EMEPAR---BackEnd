package com.teste.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_votos")
public class Votos implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer quant_votos;

    public Votos (){

    }

    public Votos(Long id, Integer quant_votos) {
        this.id = id;
        this.quant_votos = quant_votos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQuant_votos() {
        return quant_votos;
    }

    public void setQuant_votos(Integer quant_votos) {
        this.quant_votos = quant_votos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Votos votos = (Votos) o;
        return id.equals(votos.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
