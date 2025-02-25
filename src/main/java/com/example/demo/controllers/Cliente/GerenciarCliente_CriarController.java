package com.example.demo.controllers.Cliente;

import com.example.demo.entities.Cliente;
import com.example.demo.entities.Produto;
import com.example.demo.repositories.ClienteRepository;
import com.example.demo.repositories.ProdutoRepository;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.springframework.stereotype.Controller;

@Controller
public class GerenciarCliente_CriarController {

    @FXML
    private TextField nomeCliente;
    @FXML
    private TextField cpfCliente;
    @FXML
    private TextField telefoneCliente;
    @FXML
    private TextField enderecoCliente;
    @FXML
    private Label mensagemRetorno;

    private ClienteRepository clienteRepository;

    public GerenciarCliente_CriarController(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @FXML
    public void adicionarClienteClick(){
        Cliente cliente = new Cliente();
        cliente.setNome(nomeCliente.getText());
        cliente.setCPF(cpfCliente.getText());
        cliente.setTelefone(telefoneCliente.getText());
        cliente.setEndereco(enderecoCliente.getText());
        clienteRepository.save(cliente);
        nomeCliente.clear();
        cpfCliente.clear();
        telefoneCliente.clear();
        enderecoCliente.clear();
        mensagemRetorno.setText("Cliente com ID: " + cliente.getId() + " criado com sucesso!");
    }

}
