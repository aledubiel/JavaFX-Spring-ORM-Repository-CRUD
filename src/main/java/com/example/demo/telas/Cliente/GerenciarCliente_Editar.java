package com.example.demo.telas.Cliente;

import com.example.demo.utils.AbridorJanela;
import org.springframework.stereotype.Component;

@Component
public class GerenciarCliente_Editar {

    static AbridorJanela abridorJanela;

    public GerenciarCliente_Editar(AbridorJanela abridorJanela) {
        this.abridorJanela = abridorJanela;
    }
    public static void abrir(){
        abridorJanela.abrirNovaJanela("/views/GerenciarCliente/editar.fxml", "Editar Cliente", 400, 700);
    }

}
