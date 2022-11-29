package com.example.javaproject.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;


@Entity
@Getter
@Setter
@AllArgsConstructor
@Table(name = "Odontologos")
public class Odontologo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private Integer matricula;
    @Column
    private String nombre;
    @Column
    private String apellido;

    /*
    //el odontologo tiene varios turnos
    //tiene que estar mapeado por la relacion que tiene con el turno
    @JsonIgnore
    @OneToMany(mappedBy = "odontologo", fetch = FetchType.LAZY)
    private Set<Turno> turnos = new HashSet<>(); */

    //hibernate necesita de un constructor vacío por defecto:
    public Odontologo() {
    }
}

