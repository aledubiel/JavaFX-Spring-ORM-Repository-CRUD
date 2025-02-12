package com.example.demo.telas;

import com.example.demo.utils.AbridorJanela;
import org.springframework.stereotype.Component;

@Component
public class GerenciarCliente {

    AbridorJanela abridorJanela;

    public GerenciarCliente(AbridorJanela abridorJanela) {
        this.abridorJanela = abridorJanela;
    }
    public void abrir() {
        abridorJanela.abrirNovaJanela("/views/gerenciar-cliente.fxml", "Gerenciar Cliente", 300, 500);
    }

}
