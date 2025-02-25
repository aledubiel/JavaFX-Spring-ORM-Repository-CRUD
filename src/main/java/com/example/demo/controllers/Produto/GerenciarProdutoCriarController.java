package com.example.demo.controllers.Produto;

import com.example.demo.entities.Produto;
import com.example.demo.repositories.ProdutoRepository;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.springframework.stereotype.Controller;

@Controller
public class GerenciarProdutoCriarController {

    @FXML
    private TextField nomeProduto;
    @FXML
    private TextField precoProduto;
    @FXML
    private Label mensagemRetorno;

    private ProdutoRepository produtoRepository;

    public GerenciarProdutoCriarController(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @FXML
    public void adicionarProdutoClick(){
        Produto produto = new Produto();
        produto.setNome(nomeProduto.getText());
        produto.setPreco(Float.parseFloat(precoProduto.getText()));
        produtoRepository.save(produto);
        nomeProduto.clear();
        precoProduto.clear();
        mensagemRetorno.setText("Produto com ID: " + produto.getId() + " cadastrado com sucesso!");
    }
}
