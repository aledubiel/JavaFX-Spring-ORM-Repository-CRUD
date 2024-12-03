package com.example.demo.telas;

import com.example.demo.utils.AbridorJanela;
import org.springframework.stereotype.Component;

@Component
public class TelaEditarAluno {

    AbridorJanela abridorJanela;

    public TelaEditarAluno(AbridorJanela abridorJanela) {
        this.abridorJanela = abridorJanela;
    }

    public void abrir(){
        abridorJanela.abrirNovaJanela("/views/tela-editar-aluno-view.fxml", "Alterar Aluno", 300, 500);
    }

}
