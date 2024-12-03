package com.example.demo.telas;

import com.example.demo.utils.AbridorJanela;
import org.springframework.stereotype.Component;

@Component
public class TelaAlunos {

    AbridorJanela abridorJanela;

    public TelaAlunos(AbridorJanela abridorJanela) {
        this.abridorJanela = abridorJanela;
    }

    public void abrir(){
        abridorJanela.abrirNovaJanela("/views/tela-alunos-view.fxml", "Alunos", 700, 500);
    }

}
