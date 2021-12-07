package com.proyecto.lair.response;

public class Respuesta {
    int code;
    String message;
    Object prueba;

    public Respuesta(int code, String message, Object prueba) {
        this.code = code;
        this.message = message;
        this.prueba = prueba;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getPrueba() {
        return prueba;
    }

    public void setPrueba(Object prueba) {
        this.prueba = prueba;
    }
}
