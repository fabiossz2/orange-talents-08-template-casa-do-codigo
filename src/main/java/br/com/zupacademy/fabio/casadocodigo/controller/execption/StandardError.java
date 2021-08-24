package br.com.zupacademy.fabio.casadocodigo.controller.execption;

import java.time.LocalDateTime;

public class StandardError {
    private LocalDateTime timeError;
    private Integer statusCode;
    private String status;
    private String messageUser;
    private String messageDeveloper;

    public StandardError(LocalDateTime timeError, Integer statusCode, String status, String messageUser) {
        this.timeError = timeError;
        this.statusCode = statusCode;
        this.status = status;
        this.messageUser = messageUser;
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

    public String getMessageUser() {
        return messageUser;
    }

}
