package com.example.demo.controllers;

import com.example.demo.entities.Cliente;
import com.example.demo.entities.Itens_Ordem_Venda;
import com.example.demo.entities.Ordem_Venda;
import com.example.demo.entities.Produto;
import com.example.demo.repositories.ClienteRepository;
import com.example.demo.repositories.Itens_Ordem_Venda_Repository;
import com.example.demo.repositories.Ordem_Venda_Repository;
import com.example.demo.repositories.ProdutoRepository;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.springframework.stereotype.Controller;

import java.sql.Date;
import java.time.LocalDate;

import static java.lang.Integer.parseInt;

@Controller
public class EmitirOrdemVendaController {

    @FXML
    private TextField codProduto;
    @FXML
    private TextField codCliente;
    @FXML
    private Label informaçõesCliente;
    @FXML
    private TextField quantidadeProduto;
    @FXML
    private Label descriçãoPrecoProduto;
    @FXML
    private ListView<Itens_Ordem_Venda> listaProdutos = new ListView<>();
    @FXML
    private Label totalPedido;
    @FXML
    private TextField valorRecebido;
    @FXML
    private Label trocoLabel;
    @FXML
    private Label estoqueProduto;

    @FXML
    private ComboBox<String> formaPagamento;

    private Produto produtoEncontrado = null;
    private Cliente clienteEncontrado = null;
    private ProdutoRepository produtoRepository;

    private ClienteRepository clienteRepository;

    private Itens_Ordem_Venda_Repository itens_OV_Repository;

    private Ordem_Venda_Repository ordem_Venda_Repository;

    Ordem_Venda ordem_Venda = new Ordem_Venda();

    public EmitirOrdemVendaController(ProdutoRepository produtoRepository, ClienteRepository clienteRepository, Ordem_Venda_Repository ordem_Venda_Repository, Itens_Ordem_Venda_Repository itens_Ordem_Venda_Repository) {
        this.produtoRepository = produtoRepository;
        this.clienteRepository = clienteRepository;
        this.ordem_Venda_Repository = ordem_Venda_Repository;
        this.itens_OV_Repository = itens_Ordem_Venda_Repository;
    }

    @FXML
    public void onInsereCodigoCliente() {
        clienteRepository.findById(parseInt(codCliente.getText())).ifPresentOrElse(
                cliente -> {
                    informaçõesCliente.setText("Nome: " + cliente.getNome() + " - CPF: " + cliente.getCPF());
                    clienteEncontrado = cliente;
                    ordem_Venda.setCliente(clienteEncontrado);
                },
                () -> {
                    informaçõesCliente.setText("Código Inválido");
                }
        );
    }

    @FXML
    public void onInsereCodigoProduto() {
        produtoRepository.findById(parseInt(codProduto.getText())).ifPresentOrElse(
                produto -> {
                    descriçãoPrecoProduto.setText("Descrição: " + produto.getNome() + " - Preço: " + produto.getPreco());
                    estoqueProduto.setText("Estoque Total: " + produto.getEstoqueTotal());
                    produtoEncontrado = produto;
                },
                () -> {
                    descriçãoPrecoProduto.setText("Código Inválido");
                }
        );
    }

    @FXML
    public void buttonAdicionarLista() {
        if (produtoEncontrado != null && clienteEncontrado != null) {
            if (quantidadeProduto.getText() != null && !quantidadeProduto.getText().isEmpty()) {
                if (produtoEncontrado.getEstoqueTotal() >= Float.parseFloat(quantidadeProduto.getText())) {
                    Itens_Ordem_Venda novoItem = new Itens_Ordem_Venda();
                    novoItem.setProduto(produtoEncontrado);
                    novoItem.setQuantidade(parseInt(quantidadeProduto.getText()));
                    novoItem.setSubtotal(parseInt(quantidadeProduto.getText()) * produtoEncontrado.getPreco());
                    listaProdutos.getItems().add(novoItem);
                    if (totalPedido.getText() != null) {
                        totalPedido.setText(String.valueOf(novoItem.getSubtotal() + Float.parseFloat(totalPedido.getText())));
                    } else {
                        totalPedido.setText(String.valueOf(novoItem.getSubtotal()));
                    }
                }else{
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Atenção");
                    alert.setHeaderText("Produto sem Estoque Suficiente");
                    alert.setContentText("Por favor, procure o Operador de Estoque.");
                    alert.showAndWait();
                }
            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Atenção");
                alert.setHeaderText("Quantidade inválida");
                alert.setContentText("Por favor, insira uma quantidade válida.");
                alert.showAndWait();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Atenção");
            alert.setHeaderText("Dados incompletos");
            alert.setContentText("Certifique-se de que o cliente e o produto foram selecionados.");
            alert.showAndWait();
        }
    }

    @FXML
    public void buttonExcluirItemLista() {
        if (listaProdutos.getSelectionModel().getSelectedItem() != null) {
            Itens_Ordem_Venda itemSelecionadoExcluir = listaProdutos.getSelectionModel().getSelectedItem();
            listaProdutos.getItems().remove(itemSelecionadoExcluir);
            totalPedido.setText(String.valueOf(Float.parseFloat(totalPedido.getText()) - itemSelecionadoExcluir.getSubtotal()));

        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Erro");
            alert.setHeaderText("Selecione um item para excluir");
            alert.showAndWait();
        }
    }

    @FXML
    public void onAtualizaTroco() {
        if (valorRecebido.getText() != null && !valorRecebido.getText().isEmpty()) {
            trocoLabel.setText(Float.toString(Float.parseFloat(valorRecebido.getText()) - Float.parseFloat(totalPedido.getText())));
        }
    }

    @FXML
    public void onFinalizarOrdemVendaClick() {
        if (clienteEncontrado == null || listaProdutos.getItems().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Atenção");
            alert.setHeaderText("Dados incompletos");
            alert.setContentText("Certifique-se de que o cliente foi selecionado e a lista de produtos não está vazia.");
            alert.showAndWait();
            return;
        }

        if (formaPagamento.getValue() == null || formaPagamento.getValue().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Atenção");
            alert.setHeaderText("Forma de pagamento não selecionada");
            alert.setContentText("Por favor, selecione uma forma de pagamento antes de finalizar a ordem de venda.");
            alert.showAndWait();
            return;
        }

        ordem_Venda.setValorTotal(Float.parseFloat(totalPedido.getText()));
        ordem_Venda.setData(Date.valueOf(LocalDate.now()));
        ordem_Venda.setFormaPagamento(formaPagamento.getValue());

        Ordem_Venda ordemSalva = ordem_Venda_Repository.save(ordem_Venda);

        // Salvando Itens no Banco
        ObservableList<Itens_Ordem_Venda> itens = listaProdutos.getItems();
        for (Itens_Ordem_Venda item : itens) {
            item.getProduto().setEstoqueTotal(item.getProduto().getEstoqueTotal() - item.getQuantidade());
            item.setOrdem_venda(ordemSalva);
            itens_OV_Repository.save(item);
            produtoRepository.save(item.getProduto());
        }

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Sucesso");
        alert.setHeaderText("Ordem de Venda Finalizada");
        alert.setContentText("A ordem de venda foi finalizada");
        alert.showAndWait();

        listaProdutos.getItems().clear();
        informaçõesCliente.setText("");
        descriçãoPrecoProduto.setText("");
        estoqueProduto.setText("");
        totalPedido.setText("0.00");
        valorRecebido.clear();
        trocoLabel.setText("");
        codProduto.clear();
        codCliente.clear();
        quantidadeProduto.clear();
        formaPagamento.setValue(null); // Limpa o ComboBox
        clienteEncontrado = null;
        produtoEncontrado = null;
        ordem_Venda = new Ordem_Venda();
    }
}
