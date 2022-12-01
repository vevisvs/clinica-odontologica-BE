package com.example.javaproject.controller;

import com.example.javaproject.entity.Paciente;
import com.example.javaproject.exception.ResourceNotFoundException;
import com.example.javaproject.service.PacienteService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class PacienteController {

    private final PacienteService pacienteService;

    //Listar pacientes (GET)
    @GetMapping("/pacientes")
    public ResponseEntity<List<Paciente>> listar(){
        return ResponseEntity.ok(pacienteService.listar());
    }

    //Buscar paciente por id (GET)
    @GetMapping("/pacientes/{id}")
    public ResponseEntity <Optional<Paciente>> getById(@PathVariable int id){
        return ResponseEntity.ok(pacienteService.getById(id));
    }

    //Agregar paciente (POST)
    @PostMapping("/nuevosPaciente")
    public ResponseEntity<Paciente> agregar(@RequestBody Paciente paciente)  {
        try {
            pacienteService.agregar(paciente);
            return new ResponseEntity<>(paciente, HttpStatus.CREATED);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    //Actualizar paciente (PUT)
    @PutMapping("/modificarPaciente")
    public ResponseEntity<Paciente> actualizar(@RequestBody Paciente paciente){
        return ResponseEntity.ok(pacienteService.actualizar(paciente));
    }

    //Eliminar paciente (DELETE)
    @DeleteMapping("/eliminarPaciente")
    public ResponseEntity<?> eliminar(@PathVariable int id) throws ResourceNotFoundException {
        ResponseEntity response = null;
        if (pacienteService.getById(id) == null) {
            response = new ResponseEntity(HttpStatus.NOT_FOUND);
        } else {
            pacienteService.eliminar(id);
            response = new ResponseEntity(HttpStatus.OK);
        }
        return response;
    }

}
