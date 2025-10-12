/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iconex.telservice.infraestructure.websocket;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.*;

/**
 * Configuración de WebSockets con STOMP y SockJS.
 */
@Configuration
@EnableWebSocketMessageBroker

public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        //Endpoint al que se conectan los clientes
        registry.addEndpoint("/ws")
                .setAllowedOriginPatterns("*") // en producción restringir
                .withSockJS();                 // fallback si WS no soportado
    }
    
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry){
        // Canal para suscribirse desde el cliente
        registry.enableSimpleBroker("/topic");
        // Prefijo para enviar mensajes desde el cliente
        registry.setApplicationDestinationPrefixes("/app");
    }

}

