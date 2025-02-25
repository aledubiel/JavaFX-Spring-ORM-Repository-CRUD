package com.example.demo.telas.Produto;

import com.example.demo.utils.AbridorJanela;
import org.springframework.stereotype.Component;

@Component
public class GerenciarProdutoEditar {

    static AbridorJanela abridorJanela;

    public GerenciarProdutoEditar(AbridorJanela abridorJanela) {
        this.abridorJanela = abridorJanela;
    }

    public static void abrir(){
        abridorJanela.abrirNovaJanela("/views/GerenciarProduto/editar.fxml", "Editar Produto", 300, 550);
    }

}
