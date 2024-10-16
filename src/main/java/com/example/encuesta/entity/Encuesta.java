package com.example.encuesta.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="encuestas")
public class Encuesta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre es obligatorio")
    @Size(min = 2, message = "El nombre debe tener al menos 2 caracteres")
    private String nombre;

    @NotBlank(message = "Los apellidos son obligatorios")
    @Size(min = 2, message = "Los apellidos deben tener al menos 2 caracteres")
    private String apellidos;

    @NotBlank(message = "El email es obligatorio")
    @Email(message = "El formato del email no es válido")
    private String email;

    @NotNull(message = "La edad es obligatoria")
    @Min(value = 18, message = "Debes tener al menos 18 años")
    private Integer edad;

    @NotBlank(message = "El teléfono es obligatorio")
    private String telefono;

    @NotNull(message = "La fecha de inicio es obligatoria")
    @PastOrPresent(message = "La fecha de inicio no puede ser futura")
    private LocalDate fechaInicio;

    @NotBlank(message = "El motivo de la visita es obligatorio")
    private String motivoVisita;

    @ElementCollection
    private List<String> serviciosUsados;

    @NotBlank(message = "El nivel de satisfacción es obligatorio")
    private String nivelSatisfaccion;

    private String otrosComentarios;

    public Encuesta() {
    }

    public Encuesta(Long id, String nombre, String apellidos, String email, Integer edad, String telefono, LocalDate fechaInicio, String motivoVisita, List<String> serviciosUsados, String nivelSatisfaccion, String otrosComentarios) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.edad = edad;
        this.telefono = telefono;
        this.fechaInicio = fechaInicio;
        this.motivoVisita = motivoVisita;
        this.serviciosUsados = serviciosUsados;
        this.nivelSatisfaccion = nivelSatisfaccion;
        this.otrosComentarios = otrosComentarios;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotBlank(message = "El nombre es obligatorio") @Size(min = 2, message = "El nombre debe tener al menos 2 caracteres") String getNombre() {
        return nombre;
    }

    public void setNombre(@NotBlank(message = "El nombre es obligatorio") @Size(min = 2, message = "El nombre debe tener al menos 2 caracteres") String nombre) {
        this.nombre = nombre;
    }

    public @NotBlank(message = "Los apellidos son obligatorios") @Size(min = 2, message = "Los apellidos deben tener al menos 2 caracteres") String getApellidos() {
        return apellidos;
    }

    public void setApellidos(@NotBlank(message = "Los apellidos son obligatorios") @Size(min = 2, message = "Los apellidos deben tener al menos 2 caracteres") String apellidos) {
        this.apellidos = apellidos;
    }

    public @NotBlank(message = "El email es obligatorio") @Email(message = "El formato del email no es válido") String getEmail() {
        return email;
    }

    public void setEmail(@NotBlank(message = "El email es obligatorio") @Email(message = "El formato del email no es válido") String email) {
        this.email = email;
    }

    public @NotNull(message = "La edad es obligatoria") @Min(value = 18, message = "Debes tener al menos 18 años") Integer getEdad() {
        return edad;
    }

    public void setEdad(@NotNull(message = "La edad es obligatoria") @Min(value = 18, message = "Debes tener al menos 18 años") Integer edad) {
        this.edad = edad;
    }

    public @NotBlank(message = "El teléfono es obligatorio") String getTelefono() {
        return telefono;
    }

    public void setTelefono(@NotBlank(message = "El teléfono es obligatorio") String telefono) {
        this.telefono = telefono;
    }

    public @NotNull(message = "La fecha de inicio es obligatoria") @PastOrPresent(message = "La fecha de inicio no puede ser futura") LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(@NotNull(message = "La fecha de inicio es obligatoria") @PastOrPresent(message = "La fecha de inicio no puede ser futura") LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public @NotBlank(message = "El motivo de la visita es obligatorio") String getMotivoVisita() {
        return motivoVisita;
    }

    public void setMotivoVisita(@NotBlank(message = "El motivo de la visita es obligatorio") String motivoVisita) {
        this.motivoVisita = motivoVisita;
    }

    public List<String> getServiciosUsados() {
        return serviciosUsados;
    }

    public void setServiciosUsados(List<String> serviciosUsados) {
        this.serviciosUsados = serviciosUsados;
    }

    public @NotBlank(message = "El nivel de satisfacción es obligatorio") String getNivelSatisfaccion() {
        return nivelSatisfaccion;
    }

    public void setNivelSatisfaccion(@NotBlank(message = "El nivel de satisfacción es obligatorio") String nivelSatisfaccion) {
        this.nivelSatisfaccion = nivelSatisfaccion;
    }

    public String getOtrosComentarios() {
        return otrosComentarios;
    }

    public void setOtrosComentarios(String otrosComentarios) {
        this.otrosComentarios = otrosComentarios;
    }

    @Override
    public String toString() {
        return "Encuesta{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", email='" + email + '\'' +
                ", edad=" + edad +
                ", telefono='" + telefono + '\'' +
                ", fechaInicio=" + fechaInicio +
                ", motivoVisita=" + motivoVisita +
                ", serviciosUsados=" + serviciosUsados +
                ", nivelSatisfaccion=" + nivelSatisfaccion +
                ", otrosComentarios='" + otrosComentarios + '\'' +
                '}';
    }
    }




