package com.example.paciente.controller;

import com.example.paciente.model.Paciente;
import com.example.paciente.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/paciente")
public class PacienteController {

    @Autowired
    PacienteService service;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity listAll(){
        return new ResponseEntity(service.findAll(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity savePaciente(@RequestBody Paciente paciente) {
        Paciente added = service.add(paciente);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity searchPaciente(@PathVariable("id") String pacienteId) {
        Optional<Paciente> paciente = service.findById(pacienteId);
        if (paciente.isPresent()) {
            return new ResponseEntity<Paciente>(paciente.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<Paciente>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity updatePaciente(@PathVariable("id") String id, @RequestBody Paciente paciente) {
        if (service.update(id, paciente)) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deletePaciente(@PathVariable("id") String pacienteId) {
        if (service.delete(pacienteId)) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

}

