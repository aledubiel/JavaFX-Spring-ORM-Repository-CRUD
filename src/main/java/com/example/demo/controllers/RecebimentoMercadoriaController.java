package com.example.demo.controllers;

import com.example.demo.entities.Produto;
import com.example.demo.repositories.ProdutoRepository;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import org.springframework.stereotype.Controller;
import javafx.scene.control.Label;

import java.awt.*;

import static java.lang.Integer.parseInt;

@Controller
public class RecebimentoMercadoriaController {

    @FXML
    private TextField idProduto;
    @FXML
    private Label descricaoProduto;
    @FXML
    private Label estoqueProduto;
    @FXML
    private TextField quantidade;
    @FXML
    private Label mensagemRetorno;

    private ProdutoRepository produtoRepository;

    private Produto produtoEncontrado;
    public RecebimentoMercadoriaController(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @FXML
    public void onBuscarProdutoClick(){
        produtoRepository.findById(parseInt(idProduto.getText())).ifPresentOrElse(
                produto -> {
                    descricaoProduto.setText("Nome: " + produto.getNome());
                    estoqueProduto.setText("Estoque: " + (produto.getEstoqueTotal()) + " PÇ");
                    produtoEncontrado = produto;
                },
                () -> {
                    mensagemRetorno.setText("Produto não encontrado");
                    produtoEncontrado = null;
                }
        );
    }
    @FXML
    public void onRealizarEntradaClick(){
        if(produtoEncontrado != null){
            produtoEncontrado.setEstoqueTotal(parseInt(quantidade.getText()) + produtoEncontrado.getEstoqueTotal());
            produtoRepository.save(produtoEncontrado);
            mensagemRetorno.setText("Estoque atualizado com sucesso");
            idProduto.clear();
            quantidade.clear();
            estoqueProduto.setText("");
            descricaoProduto.setText("");
        } else {
            mensagemRetorno.setText("Realize uma nova busca");
        }
    }
}
