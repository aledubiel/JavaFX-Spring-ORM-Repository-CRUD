package com.example.demo.controllers;

import com.example.demo.telas.GerenciarCliente_Criar;
import org.springframework.stereotype.Controller;

@Controller
public class GerenciarClienteController {
    public void onAbrirCriarClienteClick(){
        GerenciarCliente_Criar.abrir();}

}
