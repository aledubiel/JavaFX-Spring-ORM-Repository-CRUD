package com.example.demo.telas;

import com.example.demo.utils.AbridorJanela;
import org.springframework.stereotype.Component;

@Component
public class RecebimentoMercadoria {

    static AbridorJanela abridorJanela;

    public RecebimentoMercadoria(AbridorJanela abridorJanela) {
        this.abridorJanela = abridorJanela;
    }
    public static void abrir() {
        abridorJanela.abrirNovaJanela("/views/recebimento-mercadoria.fxml", "Recebimento de Mercadoria", 400, 500);
    }
}
