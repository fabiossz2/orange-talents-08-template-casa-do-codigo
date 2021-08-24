package br.com.zupacademy.fabio.casadocodigo.controller.execption;

import java.time.LocalDateTime;

public class StandardError {
    private LocalDateTime timeError;
    private Integer statusCode;
    private String status;
    private String field;
    private String message;


    public StandardError(LocalDateTime timeError, Integer statusCode, String status, String field, String message) {
        this.timeError = timeError;
        this.statusCode = statusCode;
        this.status = status;
        this.field = field;
        this.message = message;
    }

    public LocalDateTime getTimeError() {
        return timeError;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public String getStatus() {
        return status;
    }

    public String getField() {
        return field;
    }

    public String getMessage() {
        return message;
    }
}
