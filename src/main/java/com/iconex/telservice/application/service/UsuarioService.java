/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iconex.telservice.application.service;

import com.iconex.telservice.application.dtos.UsuarioResponseDTO;
import com.iconex.telservice.application.port.UsuarioRepositoryPort;
import com.iconex.telservice.domain.model.Usuario;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Servicio de aplicación para manejar Productos. Expone métodos que serán
 * llamados por controladores o WebSockets.
 */
@Service
public class UsuarioService {

    private final UsuarioRepositoryPort repo;
    private final BCryptPasswordEncoder passwordEncoder;
    private final SimpMessagingTemplate messagingTemplate; // <--- WebSocket

    public UsuarioService(UsuarioRepositoryPort repo, SimpMessagingTemplate messagingTemplate) {
        this.repo = repo;
        this.messagingTemplate = messagingTemplate;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    // Crear un nuevo usuario
    public Usuario crearUsuario(Usuario usuario) {

        if (usuario == null) {
            throw new IllegalArgumentException("Usuario es requerido");
        }

        if (dniExisteOtroUsuario(usuario.getDni(), usuario.getIdUsuario())) {
            throw new IllegalArgumentException("El DNI ya existeeeeee");
        }

        if (correoExisteOtroUsuario(usuario.getCorreo(), usuario.getIdUsuario())) {
            throw new IllegalArgumentException("El Correo ya existeee");
        }
        // Encriptar contraseña antes de guardar
        String hashedPassword = passwordEncoder.encode(usuario.getContrasena());
        usuario.setContrasena(hashedPassword);

        Usuario saved = repo.save(usuario);

        // Enviar mensaje WebSocket solo con el usuario creado
        messagingTemplate.convertAndSend("/topic/usuarios", saved);

        return saved;
    }

    public boolean dniExisteOtroUsuario(String dni, Long idUsuario) {
        return repo.findByDni(dni)
                .filter(u -> !u.getIdUsuario().equals(idUsuario))
                .isPresent();
    }

    public boolean correoExisteOtroUsuario(String correo, Long idUsuario) {
        return repo.findByCorreo(correo)
                .filter(u -> !u.getIdUsuario().equals(idUsuario))
                .isPresent();
    }

    // Listar todos los usuarios
    public List<Usuario> listarUsuarios() {
        return repo.findAll();
    }

    // Listar usuarios por paginacion
    public List<Usuario> getUsuariosPaginated(int page, int size, String search) {
        return repo.findAllPaginated(page, size, search);
    }

    // Editar usuario existente
    public Usuario editarUsuario(Usuario usuario) {
        if (usuario == null || usuario.getIdUsuario() == null) {
            throw new IllegalArgumentException("Usuario o ID es requerido");
        }

        if (dniExisteOtroUsuario(usuario.getDni(), usuario.getIdUsuario())) {
            throw new IllegalArgumentException("El DNI ya existeeeee");
        }

        if (correoExisteOtroUsuario(usuario.getCorreo(), usuario.getIdUsuario())) {
            throw new IllegalArgumentException("El Correo ya existe");
        }

        Usuario existing = repo.findById(usuario.getIdUsuario())
                .orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado"));

        // Encriptar contraseña solo si se cambió
        if (usuario.getContrasena() != null && !usuario.getContrasena().isEmpty()) {
            existing.setContrasena(passwordEncoder.encode(usuario.getContrasena()));
        }

        // Actualizar campos
        existing.setCorreo(usuario.getCorreo());
        existing.setDni(usuario.getDni());
        existing.setNombre(usuario.getNombre());
        existing.setArea(usuario.getArea());
        existing.setCargo(usuario.getCargo());
        existing.setEstado(usuario.getEstado());
        existing.setRol(usuario.getRol());
        existing.setRango(usuario.getRango());
        existing.setSede(usuario.getSede());
        existing.setFechaInicio(usuario.getFechaInicio());
        existing.setTipoContratacion(usuario.getTipoContratacion());

        Usuario updated = repo.save(existing);

        // WebSocket
        messagingTemplate.convertAndSend("/topic/usuarios", updated);

        return updated;
    }

    // Borrar usuario por ID
    public void eliminarUsuario(Long id) {
        Usuario u = repo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado"));

        repo.deleteById(id);

        Map<String, Object> msg = new HashMap<>();
        msg.put("id", id);
        msg.put("eliminado", true);

        messagingTemplate.convertAndSend("/topic/usuarios", msg);
    }

    // Buscar usuario por ID
    public Usuario buscarPorId(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado con id: " + id));
    }

    public long countUsuarios(String search) {
        return repo.countAllFiltered(search);
    }
}
