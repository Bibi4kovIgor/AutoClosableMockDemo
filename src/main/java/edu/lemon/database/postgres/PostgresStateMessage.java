package edu.lemon.database.postgres;

public enum PostgresStateMessage {
    CONNECTION_ESTABLISHED_MESSAGE("Connection to Postgres server was established "),
    CONNECTION_CLOSED_MESSAGE("Connection to Postgres server was closed "),
    DEFAULT_MESSAGE("No connection to Postgres server was established ");
    private final String value;

    PostgresStateMessage(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}