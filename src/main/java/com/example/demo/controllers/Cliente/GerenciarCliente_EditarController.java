package com.example.demo.controllers.Cliente;

import com.example.demo.entities.Cliente;
import com.example.demo.repositories.ClienteRepository;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.springframework.stereotype.Controller;

@Controller
public class GerenciarCliente_EditarController {

    @FXML
    private TextField idCliente;
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

    private Cliente clienteEditando;

    public GerenciarCliente_EditarController(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @FXML
    public void buscarClienteClick(){
        clienteRepository.findById(Integer.parseInt(idCliente.getText())).ifPresentOrElse(
                cliente -> {
                    nomeCliente.setText(cliente.getNome());
                    cpfCliente.setText(cliente.getCPF());
                    telefoneCliente.setText(cliente.getTelefone());
                    enderecoCliente.setText(cliente.getEndereco());
                    clienteEditando = cliente;
                },
                () -> {
                    mensagemRetorno.setText("Cliente não encontrado");
                    clienteEditando = null;
                }
        );
    }
    @FXML
    public void editarClienteClick(){
        if(clienteEditando != null){
            clienteEditando.setNome(nomeCliente.getText());
            clienteEditando.setCPF(cpfCliente.getText());
            clienteEditando.setTelefone(telefoneCliente.getText());
            clienteEditando.setEndereco(enderecoCliente.getText());
            clienteRepository.save(clienteEditando);
            mensagemRetorno.setText("Cliente editado com sucesso");
            nomeCliente.clear();
            cpfCliente.clear();
            telefoneCliente.clear();
            enderecoCliente.clear();
        }else{
            mensagemRetorno.setText("Faça uma nova busca por ID");
        }
    }
}
