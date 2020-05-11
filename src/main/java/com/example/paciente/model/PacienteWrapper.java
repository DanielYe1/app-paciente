package com.example.paciente.model;

public class PacienteWrapper {
    private String status;
    private Paciente paciente;

    public PacienteWrapper(String status, Paciente paciente) {
        this.status = status;
        this.paciente = paciente;
    }
}
