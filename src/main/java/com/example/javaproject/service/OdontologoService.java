package com.example.javaproject.service;

import com.example.javaproject.entity.Odontologo;
import com.example.javaproject.exception.ResourceNotFoundException;
import com.example.javaproject.repository.OdontologoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class OdontologoService {

    private OdontologoRepository or;

    public List<Odontologo> listar(){
        return or.findAll();
    }

    public Optional<Odontologo> getByMatricula(int id){
        return or.findById(id);
    }

    public void agregar(Odontologo odontologo){ //será que debe retornar un odontologo????
        or.save(odontologo);
    }


    public Odontologo actualizar(Odontologo odontologo){
        if(getByMatricula(odontologo.getId()).isPresent())
            return or.save(odontologo);
        else
            return null;
    }

    public void eliminar(int id) throws ResourceNotFoundException {
        Optional<Odontologo> odontologoBuscado = getByMatricula(id);
        if(odontologoBuscado.isPresent())
            or.deleteById(id);
        else
            throw new ResourceNotFoundException("Ingrese una matricula válida");
    }

}
