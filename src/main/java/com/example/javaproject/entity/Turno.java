package com.example.javaproject.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor //Hibernate necesita un constructor vacio
@Table(name = "Turnos")

public class Turno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    //tenemos las foráneas de pacientes y odontologos
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "odontologo_id", nullable = false)
    private Odontologo odontologo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;

    @Column
    private LocalDate fechaYHora;



}

