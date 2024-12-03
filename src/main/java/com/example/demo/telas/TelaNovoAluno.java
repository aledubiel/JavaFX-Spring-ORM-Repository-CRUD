package com.example.demo.telas;

import com.example.demo.utils.AbridorJanela;
import org.springframework.stereotype.Component;

@Component
public class TelaNovoAluno {

    AbridorJanela abridorJanela;

    public TelaNovoAluno(AbridorJanela abridorJanela) {
        this.abridorJanela = abridorJanela;
    }

    public void abrir(){
        abridorJanela.abrirNovaJanela("/views/tela-novo-aluno-view.fxml", "Novo Aluno", 500, 400);
    }

}
