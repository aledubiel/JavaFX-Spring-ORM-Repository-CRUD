package com.example.demo.controllers;

import com.example.demo.entities.Aluno;
import com.example.demo.repositories.AlunoRepository;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.springframework.stereotype.Controller;

@Controller
public class TelaNovoAlunoController {

    @FXML
    private TextField nomeTextField;

    @FXML
    private TextField emailTextField;

    @FXML
    private Label mensagemLabel;

    private AlunoRepository alunoRepository;

    public TelaNovoAlunoController(AlunoRepository alunoRepository){
        this.alunoRepository = alunoRepository;
    }

    @FXML
    protected void onSalvarButtonClick() {
        Aluno aluno = new Aluno();
        aluno.setNome(nomeTextField.getText());
        aluno.setEmail(emailTextField.getText());
        alunoRepository.save(aluno);

        nomeTextField.clear();
        emailTextField.clear();
        mensagemLabel.setText("Aluno salvo com sucesso!");
    }

}
