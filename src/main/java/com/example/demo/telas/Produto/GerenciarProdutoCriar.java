package com.example.demo.telas.Produto;

import com.example.demo.utils.AbridorJanela;
import org.springframework.stereotype.Component;

@Component
public class GerenciarProdutoCriar {
    static AbridorJanela abridorJanela;

    public GerenciarProdutoCriar(AbridorJanela abridorJanela) {
        this.abridorJanela = abridorJanela;
    }

    public static void abrir(){
        abridorJanela.abrirNovaJanela("/views/GerenciarProduto/criar.fxml", "Criar Produto", 400, 400);
    }

}
