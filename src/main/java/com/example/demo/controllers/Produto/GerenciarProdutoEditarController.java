package com.example.demo.controllers.Produto;

import com.example.demo.entities.Produto;
import com.example.demo.repositories.ProdutoRepository;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.springframework.stereotype.Controller;

@Controller
public class GerenciarProdutoEditarController {
    @FXML
    private TextField idProduto;
    @FXML
    private TextField nomeProduto;
    @FXML
    private Label mensagemRetorno;
    @FXML
    private TextField precoProduto;

    private ProdutoRepository produtoRepository;

    Produto produtoEncontrado = null;

    public GerenciarProdutoEditarController(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }
    public void buscarProdutoClick() {
        produtoRepository.findById(Integer.parseInt(idProduto.getText())).ifPresentOrElse(
                produto -> {
                    nomeProduto.setText(produto.getNome());
                    precoProduto.setText(String.valueOf(produto.getPreco()));
                    produtoEncontrado = produto;
                },
                () -> {
                    mensagemRetorno.setText("Produto não encontrado");
                    produtoEncontrado = null;
                }
        );

    }
    public void editarProdutoClick(){
        produtoEncontrado.setNome(nomeProduto.getText());
        produtoEncontrado.setPreco(Float.parseFloat(precoProduto.getText()));
        produtoRepository.save(produtoEncontrado);
        mensagemRetorno.setText("Produto salvo com sucesso");
    }
}
