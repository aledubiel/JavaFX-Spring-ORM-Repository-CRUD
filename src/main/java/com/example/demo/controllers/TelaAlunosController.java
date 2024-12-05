package com.example.demo.controllers;

import com.example.demo.repositories.AlunoRepository;
import com.example.demo.services.AlunoService;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import org.springframework.stereotype.Controller;

@Controller
public class TelaAlunosController {

    private AlunoService alunoService;

    @FXML
    private ListView<String> listaAlunos;

    @FXML
    private Label mediaIdadeAlunosLabel;

    public TelaAlunosController(AlunoService alunoService){
        this.alunoService = alunoService;
    }

    @FXML
    protected void onCarregarAlunosButtonClick(){
        alunoService.buscarTodos().forEach(aluno -> {
            listaAlunos.getItems().add(aluno.getNome());
        });
        mediaIdadeAlunosLabel.setText("Média de idade dos alunos: " + alunoService.mediaIdade());
    }

}
