package com.example.javaproject.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Table(name = "Domicilio")
public class Domicilio {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    @Column
    private String calleYNumero;
    @Column
    private String localidad;
    @Column
    private String provincia;

  /*  @OneToOne(mappedBy = "domicilio")
    private Paciente paciente; */


    public Domicilio() {
    }

}