package com.example.paciente.service;

import com.example.paciente.messaging.PacienteSender;
import com.example.paciente.model.Paciente;
import com.example.paciente.model.PacienteWrapper;
import com.example.paciente.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {

    @Autowired
    PacienteRepository pacienteRepository;

    @Autowired
    PacienteSender pacienteSender;

    public Paciente add(Paciente paciente) {
        Paciente inserted = pacienteRepository.insert(paciente);
        pacienteSender.send(new PacienteWrapper("create", inserted));
        return inserted;
    }

    public boolean delete(String id) {
        boolean exists = pacienteRepository.existsById(id);
        if (exists) {
            pacienteSender.send(new PacienteWrapper("delete", new Paciente(id)));
            pacienteRepository.deleteById(id);
        }
        return exists;
    }

    public boolean update(String id, Paciente paciente) {
        boolean exists = pacienteRepository.existsById(id);
        if (exists) {
            paciente.setId(id);
            pacienteRepository.save(paciente);
            pacienteSender.send(new PacienteWrapper("update", paciente));
        }
        return exists;
    }

    public Optional<Paciente> findById(String id) {
        return pacienteRepository.findById(id);
    }

    public List<Paciente> findAll() {
        return pacienteRepository.findAll();
    }

}
