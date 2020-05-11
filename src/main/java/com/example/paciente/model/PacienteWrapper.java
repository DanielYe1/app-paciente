package com.example.paciente.model;

import java.io.Serializable;

public class PacienteWrapper implements Serializable {
    private String status;
    private Paciente paciente;

    public PacienteWrapper(String status, Paciente paciente) {
        this.status = status;
        this.paciente = paciente;
    }

    public String getStatus() {
        return status;
    }

    public Paciente getPaciente() {
        return paciente;
    }
}
