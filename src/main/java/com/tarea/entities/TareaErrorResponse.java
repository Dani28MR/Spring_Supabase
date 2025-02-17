package com.tarea.entities;

public class TareaErrorResponse {
    private String mensaje;
    public TareaErrorResponse(String mensaje) {
        this.mensaje = mensaje;
    }

    // Getter
    public String getMensaje() {
        return mensaje;
    }

    // Setter
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
