package com.example.javaproject.service;

import com.example.javaproject.entity.Paciente;
import com.example.javaproject.repository.PacienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PacienteService {

    private PacienteRepository pr;

    //listar todos los pacientes
    public List<Paciente> listar(){
        return pr.findAll();
    }

    //buscar paciente por id
    public Optional<Paciente> getById(int id){
        return pr.findById(id);
    }

    //Agregar paciente
    public void agregar(Paciente paciente){
        pr.save(paciente);
    }

    //Actualiza datos del paciente
    public Paciente actualizar(Paciente paciente){
        if(getById(paciente.getId()).isPresent()) //validación extra
            return pr.save(paciente);
        else
            return null;
    }

    //Eliminar paciente
    public void eliminar(int id){
        pr.deleteById(id);
    }
}
