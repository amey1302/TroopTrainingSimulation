package org.amaap.troopsimulationgame.controller.dto;

public class Response {
    private HttpStatus status;
    private String message;
    private int count;

    public Response(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }

    public Response(HttpStatus status, String message, int count) {
        this.status = status;
        this.message = message;
        this.count = count;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public int getCount() {
        return count;
    }

    @Override
    public String toString() {
        return message + ": " + count;
    }
}
