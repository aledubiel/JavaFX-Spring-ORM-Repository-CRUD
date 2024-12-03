package com.example.demo.controllers;

import com.example.demo.repositories.AlunoRepository;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import org.springframework.stereotype.Controller;

@Controller
public class TelaAlunosController {

    private AlunoRepository alunoRepository;

    @FXML
    private ListView<String> listaAlunos;

    public TelaAlunosController(AlunoRepository alunoRepository){
        this.alunoRepository = alunoRepository;
    }

    @FXML
    protected void onCarregarAlunosButtonClick(){
        alunoRepository.findAll().forEach(aluno -> {
            listaAlunos.getItems().add(aluno.getNome());
        });
    }

}
