package com.messagesystem.backend.contants;

public enum Constants {

    HTTP_SESSION_ID("HTTP_SESSION_ID");

    private final String value;

    Constants(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
