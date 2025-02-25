package com.example.demo.controllers;

import com.example.demo.entities.Produto;
import com.example.demo.repositories.ProdutoRepository;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.springframework.stereotype.Controller;

import static java.lang.Integer.parseInt;

@Controller
public class SaidaMercadoriaController {

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

    public SaidaMercadoriaController(ProdutoRepository produtoRepository) {
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
    public void onRealizarSaidaClick(){
        int quantidadeInt = parseInt(String.valueOf(quantidade.getText()));
        if(produtoEncontrado != null && quantidadeInt < produtoEncontrado.getEstoqueTotal()){
            produtoEncontrado.setEstoqueTotal(produtoEncontrado.getEstoqueTotal() - quantidadeInt);
            produtoRepository.save(produtoEncontrado);
            mensagemRetorno.setText("Estoque atualizado com sucesso");
            idProduto.clear();
            quantidade.clear();
            estoqueProduto.setText("");
            descricaoProduto.setText("");
        }else {
            mensagemRetorno.setText("Digite uma quantidade menor que o estoque disponivel");
        }
    }
}
