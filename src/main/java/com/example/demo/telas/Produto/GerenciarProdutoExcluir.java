package com.example.demo.telas.Produto;

import com.example.demo.utils.AbridorJanela;
import org.springframework.stereotype.Component;

@Component
public class GerenciarProdutoExcluir {
    static AbridorJanela abridorJanela;

    public GerenciarProdutoExcluir(AbridorJanela abridorJanela) {
        this.abridorJanela = abridorJanela;
    }

    public static void abrir(){
        abridorJanela.abrirNovaJanela("/views/GerenciarProduto/excluir.fxml", "Excluir Produto", 300, 500);
    }
}
