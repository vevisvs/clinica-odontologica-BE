package com.example.javaproject.service;

import com.example.javaproject.entity.Turno;
import com.example.javaproject.exception.ResourceNotFoundException;
import com.example.javaproject.repository.TurnoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.lang.module.ResolutionException;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TurnoService {

    private TurnoRepository tr;
    private PacienteService ps;
    private OdontologoService os;

    public List<Turno> listar(){
        return tr.findAll();}

    public Optional<Turno> getById(int id){
        return tr.findById(id);
    }

    public void agregar(Turno turno){
        if(turno.getOdontologo() != null && turno.getPaciente() != null){
            ps.agregar(turno.getPaciente());
            os.agregar(turno.getOdontologo());
        }
        this.tr.save(turno);
    }

    public Turno actualizar(Turno turno){
        if(getById(turno.getId()).isPresent())
            return tr.save(turno);
        else
            return null;
    }

    public void eliminar(int id) throws ResourceNotFoundException {
      Optional<Turno> turnoBuscado = getById(id);
      if(turnoBuscado.isPresent())
          tr.deleteById(id);
      else
          throw new ResolutionException("No existe el turno seleccionado. Ingrese un id correcto");
    }
}
