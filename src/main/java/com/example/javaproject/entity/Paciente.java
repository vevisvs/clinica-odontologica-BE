package com.example.javaproject.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.time.LocalDate;


    @Entity
    @Getter
    @Setter
    @AllArgsConstructor
    @Table(name = "Pacientes")
    public class Paciente {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;
        @Column
        private String nombre;
        @Column
        private String apellido;
        @Column
        private String email;
        @Column
        private String dni;
        @Column
        private LocalDate fechaDeIngreso;

        /*
        //Un paciente tiene un domicilio
        //Se incluye la Cascade porque queremos que cuando se borre un paciente, se borre el domicilio asociado.
        //En join name: Le ponemos el nombre de la columna que mapea en la tabla que vamos a relacionar; la foranea
        //En reference; es decir la otra tabla tambien lo llamamos id
        //El join va a ser donde quede la foranea
        @OneToOne (cascade = CascadeType.ALL, fetch = FetchType.EAGER)
        @JoinColumn(name = "domicilio_id", referencedColumnName = "id")
        private Domicilio domicilio; */

      /*  //Ponemos un json ignore para q no haga un loop infinito por el set
        @JsonIgnore
        //Una persona tiene varios turnos
        @OneToMany(mappedBy = "paciente", fetch = FetchType.LAZY)
        private Set<Turno> turnos = new HashSet<>(); */

        public Paciente(){
        }
}
