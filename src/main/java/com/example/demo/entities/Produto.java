package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nome;
    private float preco;
    private int estoqueTotal;

    @OneToMany(mappedBy = "produto")
    private List<Itens_Ordem_Venda> itensOrdemVendas;
}
