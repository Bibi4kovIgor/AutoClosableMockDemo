package edu.lemon.database.mysql;

public enum MySqlStateMessage {
    CONNECTION_ESTABLISHED_MESSAGE("Connection to MySQL server was established "),
    CONNECTION_CLOSED_MESSAGE("Connection to MySQL server was closed"),
    DEFAULT_MESSAGE("No connection to MySQL server was established");
    private final String value;

    MySqlStateMessage(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}