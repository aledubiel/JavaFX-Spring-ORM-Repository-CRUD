package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity @Getter @Setter @AllArgsConstructor @NoArgsConstructor @ToString

public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String CPF;
    private String nome;
    private String telefone;
    private String endereco;

    @OneToMany(mappedBy = "cliente")
    private List<Ordem_Venda> ordemVendas;
}
