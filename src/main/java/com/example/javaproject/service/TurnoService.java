package com.example.javaproject.service;

import com.example.javaproject.entity.Turno;
import com.example.javaproject.repository.TurnoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
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
        tr.save(turno);
    }

    public Turno actualizar(Turno turno){
        if(getById(turno.getId()).isPresent())
            return tr.save(turno);
        else
            return null;
    }

    public void eliminar(int id){
        tr.deleteById(id);
    }
}
