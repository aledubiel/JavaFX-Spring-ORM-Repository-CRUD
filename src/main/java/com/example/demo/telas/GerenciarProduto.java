package com.example.demo.telas;

import com.example.demo.utils.AbridorJanela;
import org.springframework.stereotype.Component;

@Component
public class GerenciarProduto {

    AbridorJanela abridorJanela;

    public GerenciarProduto(AbridorJanela abridorJanela) {
        this.abridorJanela = abridorJanela;
    }
    public void abrir(){
        abridorJanela.abrirNovaJanela("/views/gerenciar-produto.fxml", "Gerenciar Produto", 300, 500);
    }
}
