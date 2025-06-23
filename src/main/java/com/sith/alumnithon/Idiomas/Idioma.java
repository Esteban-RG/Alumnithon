package com.sith.alumnithon.Idiomas;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "Language")
public class Idioma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

}
