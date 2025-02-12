package com.example.demo.telas;

import com.example.demo.utils.AbridorJanela;
import org.springframework.stereotype.Component;

@Component
public class EmitirOrdemVenda {

    AbridorJanela abridorJanela;

    public EmitirOrdemVenda(AbridorJanela abridorJanela) {
        this.abridorJanela = abridorJanela;
    }
    public void abrir() {
        abridorJanela.abrirNovaJanela("/views/emitir-ordem-venda.fxml", "Emitir Ordem de Venda", 300, 500);
    }
}
