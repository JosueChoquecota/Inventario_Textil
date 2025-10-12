/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iconex.telservice.infraestructure.persistence;

import com.iconex.telservice.application.dtos.UsuarioResponseDTO;
import com.iconex.telservice.domain.model.Usuario;
import com.iconex.telservice.domain.model.Cargo;
import com.iconex.telservice.domain.model.Area;
import com.iconex.telservice.application.port.UsuarioRepositoryPort;
import com.iconex.telservice.domain.model.Estado;
import com.iconex.telservice.domain.model.Rango;
import com.iconex.telservice.domain.model.Rol;
import com.iconex.telservice.domain.model.Sede;
import com.iconex.telservice.domain.model.TipoContratacion;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;

// Spring Data Repository para JPA
// Spring Data JPA Repository
interface UsuarioJpaRepository extends JpaRepository<UsuarioJpa, Long> {

    // Consulta con JOIN FETCH para traer relaciones cuando realmente las necesitamos
    @Query("""
        SELECT u FROM UsuarioJpa u
        JOIN FETCH u.area
        JOIN FETCH u.cargo
        JOIN FETCH u.estado
        JOIN FETCH u.rol
        JOIN FETCH u.rango
        JOIN FETCH u.sede
        JOIN FETCH u.tipoContratacion
    """)
    List<UsuarioJpa> findAllWithRelations();

    Optional<UsuarioJpa> findByDni(String dni);

    Optional<UsuarioJpa> findByCorreo(String correo);
    //-----------------------------------------------------------------------------------

    // Consulta con JOIN FETCH para traer el rol cuando necesitamos
    @Query("SELECT u FROM UsuarioJpa u JOIN FETCH u.rol WHERE u.correo = :correo")
    Optional<UsuarioJpa> findByCorreoWithRol(@Param("correo") String correo);
    //-----------------------------------------------------------------------------------

    // NUEVO: paginación con búsqueda por nombre (podemos agregar más filtros después)
    @EntityGraph(attributePaths = {
        "area", "cargo", "estado", "rol", "rango", "sede", "tipoContratacion"
    })
    Page<UsuarioJpa> findByNombreContainingIgnoreCase(String nombre, Pageable pageable);

    @Query("""
        SELECT COUNT(u) FROM UsuarioJpa u
        WHERE LOWER(u.nombre) LIKE LOWER(CONCAT('%', :search, '%'))
    """)
    long countByNombreLike(@Param("search") String search);
    //-----------------------------------------------------------------------------------

}

// Adaptador que implementa el puerto del dominio
@Component
public class UsuarioRepositoryAdapter implements UsuarioRepositoryPort {

    private final UsuarioJpaRepository repo;
    private final EntityManager em;

    public UsuarioRepositoryAdapter(UsuarioJpaRepository repo, EntityManager em) {
        this.repo = repo;
        this.em = em;
    }

    // ---- Convertidores ----
    private Usuario mapToDomain(UsuarioJpa jpa) {
        if (jpa == null) {
            return null;
        }

        Area area = jpa.getArea() == null ? null
                : new Area(jpa.getArea().getIdArea(), jpa.getArea().getNombre());

        Cargo cargo = jpa.getCargo() == null ? null
                : new Cargo(jpa.getCargo().getIdCargo(), jpa.getCargo().getNombre());

        Estado estado = jpa.getEstado() == null ? null
                : new Estado(jpa.getEstado().getIdEstado(), jpa.getEstado().getNombre());

        Rol rol = jpa.getRol() == null ? null
                : new Rol(jpa.getRol().getIdRol(), jpa.getRol().getNombre());

        Rango rango = jpa.getRango() == null ? null
                : new Rango(jpa.getRango().getIdRango(), jpa.getRango().getNombre(), jpa.getRango().getFoto());

        Sede sede = jpa.getSede() == null ? null
                : new Sede(jpa.getSede().getIdSede(), jpa.getSede().getNombre());

        TipoContratacion tipoContratacion = jpa.getTipoContratacion() == null ? null
                : new TipoContratacion(jpa.getTipoContratacion().getIdTipoContratacion(),
                        jpa.getTipoContratacion().getNombre());

        return new Usuario(
                jpa.getIdUsuario(),
                jpa.getCorreo(),
                jpa.getContrasena(),
                jpa.getDni(),
                jpa.getNombre(),
                area,
                cargo,
                estado,
                rol,
                rango,
                sede,
                jpa.getFechaInicio(),
                tipoContratacion
        );
    }

    private Usuario mapToDomainForLogin(UsuarioJpa jpa) {
        return new Usuario(
                jpa.getIdUsuario(),
                jpa.getCorreo(),
                jpa.getContrasena(),
                null, // dni
                null, // nombre
                null, // area
                null, // cargo
                null, // estado
                jpa.getRol() != null ? new Rol(jpa.getRol().getIdRol(), jpa.getRol().getNombre()) : null,
                null, // rango
                null, // sede
                null, // fechaInicio
                null // tipoContratacion
        );
    }

    @Transactional
    private UsuarioJpa mapToJpa(Usuario usuario) {
        if (usuario == null) {
            return null;
        }

        UsuarioJpa jpa = new UsuarioJpa();

        if (usuario.getIdUsuario() != null) {
            jpa.setIdUsuario(usuario.getIdUsuario());
        }

        jpa.setCorreo(usuario.getCorreo());
        jpa.setContrasena(usuario.getContrasena());
        jpa.setDni(usuario.getDni());
        jpa.setNombre(usuario.getNombre());

        // Relaciones usando getReference para no cargar la entidad completa
        jpa.setArea(em.getReference(AreaJpa.class, usuario.getArea().getIdArea()));
        jpa.setCargo(em.getReference(CargoJpa.class, usuario.getCargo().getIdCargo()));
        jpa.setEstado(em.getReference(EstadoJpa.class, usuario.getEstado().getIdEstado()));
        jpa.setRol(em.getReference(RolJpa.class, usuario.getRol().getIdRol()));
        jpa.setRango(em.getReference(RangoJpa.class, usuario.getRango().getIdRango()));
        jpa.setSede(em.getReference(SedeJpa.class, usuario.getSede().getIdSede()));
        jpa.setTipoContratacion(em.getReference(TipoContratacionJpa.class,
                usuario.getTipoContratacion().getIdTipoContratacion()));

        jpa.setFechaInicio(usuario.getFechaInicio());

        return jpa;
    }

    // ---- Implementación del puerto ----
    @Override
    public Usuario save(Usuario usuario) {
        UsuarioJpa jpa = mapToJpa(usuario);
        UsuarioJpa saved = repo.save(jpa);
        return mapToDomain(saved);
    }

    @Override
    public Optional<Usuario> findById(Long id) {
        return repo.findById(id).map(this::mapToDomain);
    }

    @Override
    public Optional<Usuario> findByDni(String dni) {
        return repo.findByDni(dni).map(this::mapToDomain);
    }

    @Override
    public Optional<Usuario> findByCorreo(String correo) {
        return repo.findByCorreo(correo).map(this::mapToDomain);
    }

    @Override
    public Optional<Usuario> findByCorreoConRol(String correo) {
        return repo.findByCorreoWithRol(correo)
                .map(this::mapToDomainForLogin); // Mapeo solo lo que necesitas
    }

    @Override
    public List<Usuario> findAll() {
        return repo.findAllWithRelations().stream()
                .map(this::mapToDomain)
                .toList();
    }

    @Override
    public List<Usuario> findAllPaginated(int page, int size, String search) {
        Pageable pageable = PageRequest.of(page, size);

        Page<UsuarioJpa> jpas = (search == null || search.isBlank())
                ? repo.findAll(pageable) // Page<UsuarioJpa>
                : repo.findByNombreContainingIgnoreCase(search, pageable);

        return jpas.stream()
                .map(this::mapToDomain)
                .toList();
    }

    @Override
    public long countAllFiltered(String search) {
        return (search == null || search.isBlank())
                ? repo.count()
                : repo.countByNombreLike(search);
    }

    @Override
    public void deleteById(Long id) {
        repo.deleteById(id);
    }
}
