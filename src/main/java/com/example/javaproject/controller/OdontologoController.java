package com.example.javaproject.controller;


import com.example.javaproject.entity.Odontologo;
import com.example.javaproject.service.OdontologoService;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class OdontologoController {

    Logger log = LogManager.getLogger();


    private final OdontologoService odontologoService;

    //Listar odontologos (GET)
    @GetMapping("/odontologos")
    public ResponseEntity<List<Odontologo>> listar(){
        return ResponseEntity.ok(odontologoService.listar());
    }


    //Buscar odontologo por matricula (GET)
    @GetMapping("/odontologos/{id}")
    public ResponseEntity <Optional<Odontologo>>  getByMatricula(@PathVariable int id) {
        return ResponseEntity.ok(odontologoService.getByMatricula(id));
    }


    //Agregar un odontologo (POST)
    @PostMapping("/agregarOdontologos")
    public ResponseEntity<Odontologo> agregar(@RequestBody Odontologo odontologo)  {
        try {
            odontologoService.agregar(odontologo);
            return new ResponseEntity<>(odontologo, HttpStatus.CREATED);
        }catch(Exception exception){
            log.info(exception);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


    //Modificar odontologo (PUT)
    @PutMapping("/actualizarOdontologo")
    public ResponseEntity<Odontologo> actualizar(@RequestBody Odontologo odontologo){
        return ResponseEntity.ok(odontologoService.actualizar(odontologo));
    }


    //Eliminar odontologo (DELETE)
    @DeleteMapping("/eliminarOdontologo")
    public ResponseEntity<?> eliminarOdontologo (@PathVariable int id) {
        ResponseEntity response = null;
        if (odontologoService.getByMatricula(id) == null) {
            response = new ResponseEntity(HttpStatus.NOT_FOUND);
        } else {
            odontologoService.eliminar(id);
            response = new ResponseEntity(HttpStatus.OK);
        }
        return response;
    }


}
