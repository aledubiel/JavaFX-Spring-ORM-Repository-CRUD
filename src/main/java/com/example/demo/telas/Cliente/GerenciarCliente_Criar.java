package com.example.demo.telas.Cliente;

import com.example.demo.utils.AbridorJanela;
import org.springframework.stereotype.Component;

@Component
public class GerenciarCliente_Criar {

    static AbridorJanela abridorJanela;

    public GerenciarCliente_Criar(AbridorJanela abridorJanela) {
        this.abridorJanela = abridorJanela;
    }
    public static void abrir(){
        abridorJanela.abrirNovaJanela("/views/GerenciarCliente/criar.fxml", "Criar Cliente", 300, 600);
    }
}
