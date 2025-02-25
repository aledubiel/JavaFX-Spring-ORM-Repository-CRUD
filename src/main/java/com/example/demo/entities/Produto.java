package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nome;
    private float preco;
    private int estoqueTotal;
    private int status = 0; // para controle da desativação do produto

    @OneToMany(mappedBy = "produto")
    private List<Itens_Ordem_Venda> itensOrdemVendas;

    @Override
    public String toString() {
        return String.format("Id: %d - Nome: %s - Preço: %.2f - Estoque: %d", id, nome, preco, estoqueTotal);
    }

}
