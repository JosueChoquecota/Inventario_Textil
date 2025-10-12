/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iconex.telservice.web.controller;

import com.iconex.telservice.application.dtos.UsuarioRequestDTO;
import com.iconex.telservice.application.dtos.UsuarioResponseDTO;
import com.iconex.telservice.application.service.AreaService;
import com.iconex.telservice.application.mappers.UsuarioMapper;
import com.iconex.telservice.application.service.CargoService;
import com.iconex.telservice.application.service.EstadoService;
import com.iconex.telservice.application.service.RangoService;
import com.iconex.telservice.application.service.RolService;
import com.iconex.telservice.application.service.SedeService;
import com.iconex.telservice.application.service.TipoContratacionService;
import com.iconex.telservice.application.service.UsuarioService;
import com.iconex.telservice.domain.model.Area;
import com.iconex.telservice.domain.model.Cargo;
import com.iconex.telservice.domain.model.Estado;
import com.iconex.telservice.domain.model.Rango;
import com.iconex.telservice.domain.model.Rol;
import com.iconex.telservice.domain.model.Sede;
import com.iconex.telservice.domain.model.TipoContratacion;
import com.iconex.telservice.domain.model.Usuario;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Diseño
 */
@Controller
@RequestMapping("/register")
public class RegisterController {

    private final UsuarioService usuarioService;
    private final AreaService areaService;
    private final CargoService cargoService;
    private final EstadoService estadoService;
    private final RangoService rangoService;
    private final RolService rolService;
    private final SedeService sedeService;
    private final TipoContratacionService tipoContratacionService;
    private final UsuarioMapper mapper;

    public RegisterController(UsuarioService usuarioService, AreaService areaService, CargoService cargoService, EstadoService estadoService, RangoService rangoService, RolService rolService,
            SedeService sedeService, TipoContratacionService tipoContratacionService, UsuarioMapper mapper) {
        this.usuarioService = usuarioService;
        this.areaService = areaService;
        this.cargoService = cargoService;
        this.estadoService = estadoService;
        this.rangoService = rangoService;
        this.rolService = rolService;
        this.sedeService = sedeService;
        this.tipoContratacionService = tipoContratacionService;
        this.mapper = mapper;
    }

    @GetMapping
    public String mostrarFormulario(Model model) {
        model.addAttribute("usuarioRequestDTO", new UsuarioRequestDTO());
        model.addAttribute("areas", areaService.listarAreas());
        model.addAttribute("cargos", cargoService.listarCargos());
        model.addAttribute("estados", estadoService.listarEstados());
        model.addAttribute("rangos", rangoService.listarRangos());
        model.addAttribute("roles", rolService.listarRoles());
        model.addAttribute("sedes", sedeService.listarSedes());
        model.addAttribute("tipoContrataciones", tipoContratacionService.listarTipoContrataciones());

        List<UsuarioResponseDTO> usuarios = usuarioService.listarUsuarios()
                .stream().map(mapper::toResponseDTO)
                .collect(Collectors.toList());
        model.addAttribute("usuarios", usuarios);

        return "register";
    }

    @PostMapping("/ajax")
    @ResponseBody
    public Map<String, Object> crearUsuarioAjax(@RequestBody UsuarioRequestDTO dto) {
        Map<String, Object> resp = new HashMap<>();
        try {
            Usuario u = usuarioService.crearUsuario(mapper.toEntity(dto));
            resp.put("usuario", u);
        } catch (RuntimeException e) {
            resp.put("error", e.getMessage());
        }
        return resp;
    }

    @PostMapping("/actualizar")
    @ResponseBody
    public Map<String, Object> actualizarUsuarioAjax(@RequestBody UsuarioRequestDTO dto) {
        Map<String, Object> resp = new HashMap<>();
        try {
            Usuario u = usuarioService.editarUsuario(mapper.toEntity(dto));
            resp.put("usuario", u);
        } catch (RuntimeException e) {
            resp.put("error", e.getMessage());
        }
        return resp;
    }

    @GetMapping("/editar/{id}")
    public String editarUsuario(@PathVariable Long id, Model model) {
        Usuario usuario = usuarioService.buscarPorId(id);
        UsuarioRequestDTO dto = new UsuarioRequestDTO();
        dto.setIdUsuario(usuario.getIdUsuario());
        dto.setNombre(usuario.getNombre());
        dto.setCorreo(usuario.getCorreo());
        dto.setDni(usuario.getDni());
        dto.setFechaInicio(usuario.getFechaInicio());
        dto.setAreaId(usuario.getArea() != null ? usuario.getArea().getIdArea() : null);
        dto.setCargoId(usuario.getCargo() != null ? usuario.getCargo().getIdCargo() : null);
        dto.setEstadoId(usuario.getEstado() != null ? usuario.getEstado().getIdEstado() : null);
        dto.setRangoId(usuario.getRango() != null ? usuario.getRango().getIdRango() : null);
        dto.setRolId(usuario.getRol() != null ? usuario.getRol().getIdRol() : null);
        dto.setSedeId(usuario.getSede() != null ? usuario.getSede().getIdSede() : null);
        dto.setTipoContratacionId(usuario.getTipoContratacion() != null ? usuario.getTipoContratacion().getIdTipoContratacion() : null);
        // similar para otros campos

        model.addAttribute("usuarioRequestDTO", dto);
        model.addAttribute("areas", areaService.listarAreas());
        model.addAttribute("cargos", cargoService.listarCargos());
        model.addAttribute("estados", estadoService.listarEstados());
        model.addAttribute("rangos", rangoService.listarRangos());
        model.addAttribute("roles", rolService.listarRoles());
        model.addAttribute("sedes", sedeService.listarSedes());
        model.addAttribute("tipoContrataciones", tipoContratacionService.listarTipoContrataciones());

        List<UsuarioResponseDTO> usuarios = usuarioService.listarUsuarios()
                .stream().map(mapper::toResponseDTO)
                .collect(Collectors.toList());
        model.addAttribute("usuarios", usuarios);

        return "register";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarUsuario(@PathVariable Long id) {
        usuarioService.eliminarUsuario(id); // método que borra el usuario
        return "redirect:/register";
    }

    @GetMapping("/usuarios")
    @ResponseBody
    public Map<String, Object> listarUsuarios(
            @RequestParam int draw,
            @RequestParam int start,
            @RequestParam int length,
            @RequestParam(value = "search[value]", required = false) String search) {

        int page = start / length;

        long totalRecords = usuarioService.countUsuarios(null);
        long filteredRecords = (search == null || search.isBlank())
                ? totalRecords
                : usuarioService.countUsuarios(search);

        List<Usuario> usuarios = usuarioService.getUsuariosPaginated(page, length, search);
        List<UsuarioResponseDTO> data = usuarios.stream()
                .map(mapper::toResponseDTO)
                .toList();

        Map<String, Object> response = new HashMap<>();
        response.put("draw", draw);
        response.put("recordsTotal", (int) totalRecords);
        response.put("recordsFiltered", (int) filteredRecords);
        response.put("data", data);

        return response;
    }

}
