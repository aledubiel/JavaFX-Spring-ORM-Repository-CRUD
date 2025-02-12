package com.example.demo.controllers;

import com.example.demo.telas.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import org.springframework.stereotype.Controller;

@Controller
public class TelaInicialController {

    private TelaAlunos telaAlunos;
    private TelaNovoAluno telaNovoAluno;
    private TelaExcluirAluno telaExcluirAluno;
    private TelaEditarAluno telaEditarAluno;

    private GerenciarCliente telaGerenciarCliente;
    private GerenciarProduto telaGerenciarProduto;
    private EmitirOrdemVenda telaOrdemVenda;
    private RecebimentoMercadoria telaRecebimentoMercadoria;
    private SaidaMercadoria telaSaidaMercadoria;

    public TelaInicialController(TelaAlunos telaAlunos,
                                 TelaNovoAluno telaNovoAluno,
                                 TelaExcluirAluno telaExcluirAluno,
                                 TelaEditarAluno telaEditarAluno,
                                 GerenciarCliente telaGerenciarCliente,
                                 GerenciarProduto telaGerenciarProduto,
                                 EmitirOrdemVenda telaOrdemVenda,
                                 RecebimentoMercadoria telaRecebimentoMercadoria,
                                 SaidaMercadoria telaSaidaMercadoria) {
        this.telaAlunos = telaAlunos;
        this.telaNovoAluno = telaNovoAluno;
        this.telaExcluirAluno = telaExcluirAluno;
        this.telaEditarAluno = telaEditarAluno;

        this.telaGerenciarCliente = telaGerenciarCliente;
        this.telaGerenciarProduto = telaGerenciarProduto;
        this.telaOrdemVenda = telaOrdemVenda;
        this.telaRecebimentoMercadoria = telaRecebimentoMercadoria;
        this.telaSaidaMercadoria = telaSaidaMercadoria;
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

    @FXML
    public void onAbrirGerenciarClienteButtonClick() { telaGerenciarCliente.abrir();  }

    @FXML
    public void onAbrirGerenciarProdutoClick(){telaGerenciarProduto.abrir(); }

    @FXML
    public void onAbrirOrdemVendaClick() { telaOrdemVenda.abrir(); }

    @FXML
    public void onAbrirRecebimentoMercadoriaClick() {telaRecebimentoMercadoria.abrir(); }

    @FXML
    public void onAbrirSaidaMercadoriaClick() { SaidaMercadoria.abrir(); }
}
