package com.example.demo.controllers;

import com.example.demo.telas.TelaAlunos;
import com.example.demo.telas.TelaEditarAluno;
import com.example.demo.telas.TelaExcluirAluno;
import com.example.demo.telas.TelaNovoAluno;
import javafx.fxml.FXML;
import org.springframework.stereotype.Controller;

@Controller
public class TelaInicialController {

    private TelaAlunos telaAlunos;
    private TelaNovoAluno telaNovoAluno;
    private TelaExcluirAluno telaExcluirAluno;
    private TelaEditarAluno telaEditarAluno;

    public TelaInicialController(TelaAlunos telaAlunos,
                                 TelaNovoAluno telaNovoAluno,
                                 TelaExcluirAluno telaExcluirAluno,
                                 TelaEditarAluno telaEditarAluno) {
        this.telaAlunos = telaAlunos;
        this.telaNovoAluno = telaNovoAluno;
        this.telaExcluirAluno = telaExcluirAluno;
        this.telaEditarAluno = telaEditarAluno;
    }

    @FXML
    protected void onAbrirAlunosButtonClick() {
        telaAlunos.abrir();
    }

    @FXML
    protected void onNovoAlunoButtonClick(){
        telaNovoAluno.abrir();
    }

    @FXML
    protected void onExcluirAlunoButtonClick(){
        telaExcluirAluno.abrir();
    }

    @FXML
    protected void onEditarAlunoButtonClick(){
        telaEditarAluno.abrir();
    }

}
