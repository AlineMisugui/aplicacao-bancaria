package org.example.enums;

public enum EstadoCivil {
    SOLTEIRO(1, "Solteiro(a)") ,
    CASADO(2, "Casado(a)"),
    DIVORCIADO(3, "Divorciado(a)") ,
    VIUVO(4, "Viúvo(a)");

    private int id;
    private String estadoCivil;

    EstadoCivil(int id, String estadoCivil) {
        this.id = id;
        this.estadoCivil = estadoCivil;
    }

    public int getId() {
        return id;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }
}
