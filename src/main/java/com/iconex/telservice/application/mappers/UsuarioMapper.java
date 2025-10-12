/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iconex.telservice.application.mappers;

import com.iconex.telservice.application.dtos.UsuarioRequestDTO;
import com.iconex.telservice.application.dtos.UsuarioResponseDTO;
import com.iconex.telservice.application.service.AreaService;
import com.iconex.telservice.application.service.CargoService;
import com.iconex.telservice.application.service.RangoService;
import com.iconex.telservice.application.service.EstadoService;
import com.iconex.telservice.application.service.RolService;
import com.iconex.telservice.application.service.SedeService;
import com.iconex.telservice.application.service.TipoContratacionService;
import com.iconex.telservice.domain.model.Usuario;
import org.springframework.stereotype.Component;

/**
 *
 * @author Diseño
 */
@Component
public class UsuarioMapper {

    private final AreaService areaService;
    private final CargoService cargoService;
    private final EstadoService estadoService;
    private final RangoService rangoService;
    private final RolService rolService;
    private final SedeService sedeService;
    private final TipoContratacionService tipoContratacionService;

    public UsuarioMapper(AreaService areaService, CargoService cargoService, EstadoService estadoService, RangoService rangoService,
            RolService rolService, SedeService sedeService, TipoContratacionService tipoContratacionService) {
        this.areaService = areaService;
        this.cargoService = cargoService;
        this.estadoService = estadoService;
        this.rangoService = rangoService;
        this.rolService = rolService;
        this.sedeService = sedeService;
        this.tipoContratacionService = tipoContratacionService;
    }

    public Usuario toEntity(UsuarioRequestDTO dto) {
        Usuario usuario = new Usuario();
        usuario.setIdUsuario(dto.getIdUsuario());
        usuario.setCorreo(dto.getCorreo());
        usuario.setContrasena(dto.getContrasena());
        usuario.setDni(dto.getDni());
        usuario.setNombre(dto.getNombre());
        usuario.setFechaInicio(dto.getFechaInicio());

        // Convertir IDs a objetos completos
        if (dto.getAreaId() != null) {
            usuario.setArea(areaService.buscarPorId(dto.getAreaId()));
        }
        if (dto.getCargoId() != null) {
            usuario.setCargo(cargoService.buscarPorId(dto.getCargoId()));
        }
        if (dto.getEstadoId() != null) {
            usuario.setEstado(estadoService.buscarPorId(dto.getEstadoId()));
        }
        if (dto.getRangoId() != null) {
            usuario.setRango(rangoService.buscarPorId(dto.getRangoId()));
        }
        if (dto.getRolId() != null) {
            usuario.setRol(rolService.buscarPorId(dto.getRolId()));
        }
        if (dto.getSedeId() != null) {
            usuario.setSede(sedeService.buscarPorId(dto.getSedeId()));
        }
        if (dto.getTipoContratacionId() != null) {
            usuario.setTipoContratacion(tipoContratacionService.buscarPorId(dto.getTipoContratacionId()));
        }

        return usuario;
    }

    public UsuarioResponseDTO toResponseDTO(Usuario usuario) {
        UsuarioResponseDTO dto = new UsuarioResponseDTO();
        dto.setIdUsuario(usuario.getIdUsuario());
        dto.setCorreo(usuario.getCorreo());
        dto.setDni(usuario.getDni());
        dto.setNombre(usuario.getNombre());
        dto.setFechaInicio(usuario.getFechaInicio());

        // Nombres para mostrar en la tabla
        dto.setAreaNombre(usuario.getArea() != null ? usuario.getArea().getNombre() : null);
        dto.setCargoNombre(usuario.getCargo() != null ? usuario.getCargo().getNombre() : null);
        dto.setEstadoNombre(usuario.getEstado() != null ? usuario.getEstado().getNombre() : null);
        dto.setRangoNombre(usuario.getRango() != null ? usuario.getRango().getNombre() : null);
        dto.setRolNombre(usuario.getRol() != null ? usuario.getRol().getNombre() : null);
        dto.setSedeNombre(usuario.getSede() != null ? usuario.getSede().getNombre() : null);
        dto.setTipoContratacionNombre(usuario.getTipoContratacion() != null ? usuario.getTipoContratacion().getNombre() : null);

        // IDs para edición
        dto.setAreaId(usuario.getArea() != null ? usuario.getArea().getIdArea() : null);
        dto.setCargoId(usuario.getCargo() != null ? usuario.getCargo().getIdCargo() : null);
        dto.setRolId(usuario.getRol() != null ? usuario.getRol().getIdRol() : null);
        dto.setRangoId(usuario.getRango() != null ? usuario.getRango().getIdRango() : null);
        dto.setSedeId(usuario.getSede() != null ? usuario.getSede().getIdSede() : null);
        dto.setEstadoId(usuario.getEstado() != null ? usuario.getEstado().getIdEstado() : null);
        dto.setTipoContratacionId(usuario.getTipoContratacion() != null ? usuario.getTipoContratacion().getIdTipoContratacion() : null);

        return dto;
    }
}
