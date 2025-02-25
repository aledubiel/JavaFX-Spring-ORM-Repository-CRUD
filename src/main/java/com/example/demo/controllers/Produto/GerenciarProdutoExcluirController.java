package com.example.demo.controllers.Produto;

import com.example.demo.entities.Produto;
import com.example.demo.repositories.ProdutoRepository;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.springframework.stereotype.Controller;

@Controller
public class GerenciarProdutoExcluirController {
    @FXML
    private TextField idProduto;
    @FXML
    private Label nomeProduto;
    @FXML
    private Label estoqueProduto;
    @FXML
    private Label mensagemRetorno;

    private ProdutoRepository produtoRepository;

    Produto produtoEncontrado = null;

    public GerenciarProdutoExcluirController(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @FXML
    public void buscarProdutoClick(){
        produtoRepository.findById(Integer.parseInt(idProduto.getText())).ifPresentOrElse(
                produto -> {
                    nomeProduto.setText(produto.getNome());
                    estoqueProduto.setText(String.valueOf(produto.getEstoqueTotal()));
                    produtoEncontrado = produto;
                },
                () -> {
                    mensagemRetorno.setText("Produto não encontrado");
                    produtoEncontrado = null;
                }
        );
    }

    //Pretendia fazer algo que validasse se fosse 0=Ativado 1=desativado
    // não é dificil só não deu tempo =(

    @FXML
    public void excluirProdutoClick(){
        if (produtoEncontrado != null)
            if(produtoEncontrado.getEstoqueTotal() == 0) {
                mensagemRetorno.setText("Produto Desativado com sucesso");
                produtoRepository.delete(produtoEncontrado);
            }else{
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Erro");
                alert.setHeaderText("Produto possui estoque");
                alert.setContentText("Gentileza contator o Operador de Estoque");
                alert.showAndWait();

        }else{
            mensagemRetorno.setText("Faça uma nova busca por ID");
        }
    }
}
