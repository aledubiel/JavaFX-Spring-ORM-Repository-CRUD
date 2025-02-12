package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity @Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Itens_Ordem_Venda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "ordem_venda_id")
    private Ordem_Venda ordem_venda;

    private float subtotal;
    private int quantidade;

    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;


}
