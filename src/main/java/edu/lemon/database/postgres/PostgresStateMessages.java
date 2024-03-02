package edu.lemon.database.postgres;

public enum PostgresStateMessages {
  CONNECTION_TO_POSTGRES_WAS_ESTABLISHED("Connection to Postgres was established"),
  CONNECTION_TO_POSTGRES_WAS_CLOSED("Connection to Postgres was closed"),
  CONNECTION_TO_POSTGRES_WAS_NOT_ESTABLISHED ("Connection to Postgres was not established");

  private String messageText;
  PostgresStateMessages(String messageText) {
    this.messageText = messageText;

  }

  public String messageText() {
    return messageText;
  }
}
