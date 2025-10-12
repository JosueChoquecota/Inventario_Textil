/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iconex.telservice.infraestructure.websocket;

import com.iconex.telservice.domain.model.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
/**
 * Controlador que recibe y envía mensajes WebSocket.
 */
public class NotificacionController {
    

    // Recibe mensajes de clientes en /app/notification
    @MessageMapping("/notification")
    // Envia mensajes a todos los suscritos a /topic/alertas
    @SendTo("/topic/alertas")
    public String enviar(String mensaje){
        return mensaje; //aqui puedes enviar eventos reales del dominio
    }
    
    @Autowired
    private SimpMessagingTemplate messagingTemplate;
    
    public void notificarProductoCreado(Producto producto){
        messagingTemplate.convertAndSend(
        "/topic/productos",
        "Se creó un nuevo producto: "+ producto.getNombre()
        );
    }
    
}
