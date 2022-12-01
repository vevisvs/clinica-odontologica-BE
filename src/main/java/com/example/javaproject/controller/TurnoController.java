package com.example.javaproject.controller;

import com.example.javaproject.entity.Turno;
import com.example.javaproject.exception.ResourceNotFoundException;
import com.example.javaproject.service.TurnoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public class TurnoController {

    private TurnoService turnoService;


    //Listar los turnos (GET)
    @GetMapping("/turnos")
    public ResponseEntity<List<Turno>> listar(){
        return ResponseEntity.ok(turnoService.listar());
    }

    //Buscar turno por id (GET)
    @GetMapping("/turnos/{id}")
    public ResponseEntity <Optional<Turno>> getById(@PathVariable int id) {
        return ResponseEntity.ok(turnoService.getById(id));
    }

    //Agregar turno (POST)
    @PostMapping("/nuevosTurno")
    public ResponseEntity<Turno> agregar(@RequestBody Turno turno)  {
        try {
            turnoService.agregar(turno);
            return new ResponseEntity<>(turno, HttpStatus.CREATED);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    //Actualizar dato del turno (PUT)
    @PutMapping("/modificarTurno")
    public ResponseEntity<Turno> actualizar(@RequestBody Turno turno){
        return ResponseEntity.ok(turnoService.actualizar(turno));}


    //Eliminar turno (DELETE)
    @DeleteMapping("/eliminarTurno")
    public ResponseEntity<?> eliminarTurno (@PathVariable int id) throws ResourceNotFoundException {
        ResponseEntity response = null;
        if (turnoService.getById(id) == null) {
            response = new ResponseEntity(HttpStatus.NOT_FOUND);
        } else {
            turnoService.eliminar(id);
            response = new ResponseEntity(HttpStatus.OK);
        }
        return response;
    }
}
