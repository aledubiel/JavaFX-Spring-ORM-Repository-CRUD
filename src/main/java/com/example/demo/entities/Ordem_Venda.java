package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.*;
import java.time.format.DateTimeFormatter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity @Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Ordem_Venda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private Date data;
    private float valorTotal;
    private String formaPagamento;

    @OneToMany(mappedBy = "ordem_venda",fetch = FetchType.EAGER)
    private List<Itens_Ordem_Venda> itensOrdemVendas;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @Override
    public String toString() {
        return String.format("Id: %d - Data: %s - Cliente: %s - Valor Total: %.2f - Forma de Pagamento: %s", id, data, cliente.getNome(), valorTotal, formaPagamento);
    }
}
