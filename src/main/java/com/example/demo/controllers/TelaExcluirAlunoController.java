package com.example.demo.controllers;

import com.example.demo.entities.Aluno;
import com.example.demo.repositories.AlunoRepository;
import com.example.demo.services.AlunoService;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.springframework.stereotype.Controller;

@Controller
public class TelaExcluirAlunoController {

    @FXML
    private TextField idAlunoTextField;

    @FXML
    private Label nomeAlunoLabel;

    @FXML
    private Label mensagemLabel;

    private AlunoService alunoService;

    public TelaExcluirAlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    private Aluno alunoSelecionadoParaExclusao;

    @FXML
    protected void onBuscarAlunoButtonClick() {
        alunoService.buscarPorId(Integer.parseInt(idAlunoTextField.getText())).ifPresentOrElse(
                aluno -> {
                    nomeAlunoLabel.setText(aluno.getNome());
                    mensagemLabel.setText("");
                    alunoSelecionadoParaExclusao = aluno;
                },
                () -> {
                    nomeAlunoLabel.setText("");
                    mensagemLabel.setText("Aluno não encontrado");
                    alunoSelecionadoParaExclusao = null;
                }
        );
    }

    @FXML
    protected void onExcluirAlunoButtonClick(){
        if(alunoSelecionadoParaExclusao != null){
            alunoService.excluir(alunoSelecionadoParaExclusao);
            mensagemLabel.setText("Aluno excluído com sucesso");
            nomeAlunoLabel.setText("");
            idAlunoTextField.setText("");
        } else {
            mensagemLabel.setText("Nenhum aluno selecionado para exclusão");
        }
    }

}
