package com.example.demo.controllers;

import com.example.demo.entities.Ordem_Venda;
import com.example.demo.entities.Produto;
import com.example.demo.repositories.Ordem_Venda_Repository;
import com.example.demo.repositories.ProdutoRepository;
import com.example.demo.telas.*;
import com.example.demo.telas.Cliente.GerenciarCliente_Criar;
import com.example.demo.telas.Cliente.GerenciarCliente_Editar;
import com.example.demo.telas.Produto.GerenciarProdutoCriar;
import com.example.demo.telas.Produto.GerenciarProdutoEditar;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import org.springframework.stereotype.Controller;

@Controller
public class TelaInicialController {

    private GerenciarCliente_Criar gerenciarClienteCriar;
    private GerenciarCliente_Editar telaGerenciarCliente_Editar;
    private GerenciarProdutoCriar telaGerenciarProduto;
    private GerenciarProdutoEditar telaGerenciarProdutoEditar;
    private EmitirOrdemVenda telaOrdemVenda;
    private RecebimentoMercadoria telaRecebimentoMercadoria;
    private SaidaMercadoria telaSaidaMercadoria;

    @FXML
    private ListView<Ordem_Venda> listaVendas = new ListView<>();

    @FXML
    private ListView<Produto> listaEstoque = new ListView<>();

    private ProdutoRepository produtoRepository;

    private Ordem_Venda_Repository ordem_Venda_Repository;



    public TelaInicialController(
                                 GerenciarProdutoCriar telaGerenciarProduto,
                                 GerenciarCliente_Criar gerenciarClienteCriar,
                                 GerenciarCliente_Editar telaGerenciarCliente_Editar,
                                 GerenciarProdutoEditar telaGerenciarProdutoEditar,
                                 EmitirOrdemVenda telaOrdemVenda,
                                 RecebimentoMercadoria telaRecebimentoMercadoria,
                                 SaidaMercadoria telaSaidaMercadoria,
                                 ProdutoRepository produtoRepository,
                                 Ordem_Venda_Repository ordem_Venda_Repository) {

        this.telaGerenciarProduto = telaGerenciarProduto;
        this.gerenciarClienteCriar = gerenciarClienteCriar;
        this.telaGerenciarProdutoEditar = telaGerenciarProdutoEditar;
        this.telaGerenciarCliente_Editar = telaGerenciarCliente_Editar;
        this.telaOrdemVenda = telaOrdemVenda;
        this.telaRecebimentoMercadoria = telaRecebimentoMercadoria;
        this.telaSaidaMercadoria = telaSaidaMercadoria;
        this.produtoRepository = produtoRepository;
        this.ordem_Venda_Repository = ordem_Venda_Repository;
    }

    @FXML
    public void onAbrirGerenciarClienteButtonClick() { gerenciarClienteCriar.abrir();  }

    @FXML
    public void aoAbrirEditarCliente(){telaGerenciarCliente_Editar.abrir(); }

    @FXML
    public void onAbrirGerenciarProdutoClick(){telaGerenciarProduto.abrir(); }

    @FXML
    public void onAbrirGerenciarProdutoEditarClick(){telaGerenciarProdutoEditar.abrir(); }

    @FXML
    public void onAbrirOrdemVendaClick() { telaOrdemVenda.abrir(); }

    @FXML
    public void onAbrirRecebimentoMercadoriaClick() {telaRecebimentoMercadoria.abrir(); }

    @FXML
    public void onAbrirSaidaMercadoriaClick() { telaSaidaMercadoria.abrir(); }

    @FXML
    public void onAtualizarRelatorio() {
        listaEstoque.getItems().clear();
        listaVendas.getItems().clear();
        produtoRepository.findAll().forEach(produto -> listaEstoque.getItems().add(produto));
        ordem_Venda_Repository.findAll().forEach(ordem_Venda -> listaVendas.getItems().add(ordem_Venda));
    }



}
