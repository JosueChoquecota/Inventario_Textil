/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iconex.telservice.application.service;

import com.iconex.telservice.application.port.UsuarioRepositoryPort;
import com.iconex.telservice.domain.model.Usuario;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UsuarioRepositoryPort repo;

    public CustomUserDetailsService(UsuarioRepositoryPort repo) {
        this.repo = repo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("Intentando login con correo: " + username);

        Usuario usuario = repo.findByCorreoConRol(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));

        System.out.println("Usuario encontrado: " + usuario.getCorreo() + ", password: " + usuario.getContrasena());

        // Aquí no accedas a relaciones lazy como usuario.getArea().getNombre()
        return User.builder()
                .username(usuario.getCorreo())
                .password(usuario.getContrasena()) // bcrypt
                .build();
    }
}
