package com.AutoMaster.MS_Repuestos.exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class RepuestoException extends RuntimeException {
    public RepuestoException(String mensaje) {
        super(mensaje);
    }
}