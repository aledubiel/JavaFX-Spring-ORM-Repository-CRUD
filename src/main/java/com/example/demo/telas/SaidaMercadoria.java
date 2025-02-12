package com.example.demo.telas;

import com.example.demo.utils.AbridorJanela;
import org.springframework.stereotype.Component;

@Component
public class SaidaMercadoria {
    static AbridorJanela abridorJanela;

    public SaidaMercadoria(AbridorJanela abridorJanela) {
        this.abridorJanela = abridorJanela;
    }
    public static void abrir() {
        abridorJanela.abrirNovaJanela("/views/saida-mercadoria.fxml", "Saída de Mercadoria", 300, 500);
    }
}
