package com.sith.alumnithon.Models.Interest;

import com.sith.alumnithon.Models.User.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;


@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Interest")
@Entity
public class Interest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "interest_id")
    private Long id;

    @Enumerated(EnumType.STRING)
    private TypeInterest type;

    @ManyToMany(mappedBy = "user")
    private Set<User> users = new HashSet<>();

    @ManyToMany(mappedBy = "event")
    private Set<User> events = new HashSet<>();

    //Setters y Getters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TypeInterest getKind() {
        return type;
    }

    public void setKind(TypeInterest type) {
        this.type = type;
    }
}
