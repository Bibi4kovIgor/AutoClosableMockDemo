package edu.lemon.database.connection;

public enum ConnectionStateMessages {
  CONNECTION_ESTABLISHED_MESSAGE("Connection was established "),
  CONNECTION_CLOSED_MESSAGE("Connection was closed"),
  DEFAULT_MESSAGE("No connection was established");

  private final String value;

  ConnectionStateMessages(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }

}
