package com.example.demo.controllers;

import javafx.fxml.FXML;
import org.springframework.stereotype.Controller;
import javafx.scene.control.Label;

import java.awt.*;

@Controller
public class RecebimentoMercadoriaController {

    @FXML
    private Label teste;

    public void ontest(){
        teste.setText("teste");
    }
}
