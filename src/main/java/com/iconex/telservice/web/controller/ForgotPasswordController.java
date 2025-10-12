/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iconex.telservice.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Diseño
 */
@Controller
public class ForgotPasswordController {

    // Mostrar la página de login
    @GetMapping("/forgot-password")
    public String mostrarForgotPassword() {
        return "forgot-password"; // Thymeleaf buscará forgot-password.html en templates/
    }

   
}