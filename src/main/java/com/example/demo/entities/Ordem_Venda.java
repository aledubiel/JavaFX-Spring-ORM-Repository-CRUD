package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity @Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Ordem_Venda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    private Date data;
    private float valorTotal;
    private String formaPagamento;

    @OneToMany(mappedBy = "ordem_venda")
    private List<Itens_Ordem_Venda> itensOrdemVendas;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
}
