package com.sith.alumnithon.Evento;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "evento")
public class Evento {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false)
    private String descripcion;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Tipo tipo;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Pais pais;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Estado estado;

    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;

    @PrePersist
    public void prePersist() {
        this.fechaCreacion = LocalDateTime.now();
    }

    @Column(name = "fecha_evento")
    private LocalDateTime fechaEvento;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public LocalDateTime getFechaEvento() {
        return fechaEvento;
    }

    public void setFechaEvento(LocalDateTime fechaEvento) {
        this.fechaEvento = fechaEvento;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }
}
