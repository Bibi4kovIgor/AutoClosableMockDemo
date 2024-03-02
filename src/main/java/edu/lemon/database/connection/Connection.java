package edu.lemon.database.connection;

import edu.lemon.database.ConnectorTypes;
import edu.lemon.database.exception.ConnectionException;

import java.util.Arrays;
import java.util.Objects;

import static edu.lemon.database.connection.ConnectionStateMessages.*;

public final class Connection {

  private boolean connectionState;
  private String connectionStateMessage;
  private final String connectionString;

  public Connection(String connectionString) {
    this.connectionState = false;
    this.connectionString = connectionString;
    connectionStateMessage = DEFAULT_MESSAGE.getValue();
  }

  public boolean connectionState() {
    return connectionState;
  }

  public String connectionStateMessage() {
    return connectionStateMessage;
  }

  public void connect() throws ConnectionException {
    if(!checkConnectionString()) {
      throw new ConnectionException();
    }

    if (!connectionState) {
      this.connectionState = true;
    }

    connectionStateMessage = CONNECTION_ESTABLISHED_MESSAGE.getValue();
  }

  public void disconnect() throws ConnectionException {
    if (!connectionState) {
      throw new ConnectionException(DEFAULT_MESSAGE.getValue());
    }
    this.connectionState = false;
    connectionStateMessage = CONNECTION_CLOSED_MESSAGE.getValue();
  }

  public boolean checkConnectionString() {
    return Arrays.stream(ConnectorTypes.values())
        .anyMatch(element -> element.getConnectorUrl().equals(connectionString));
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Connection that)) return false;
    return connectionState == that.connectionState
        && Objects.equals(connectionStateMessage, that.connectionStateMessage)
        && Objects.equals(connectionString, that.connectionString);
  }

  @Override
  public int hashCode() {
    return Objects.hash(connectionState, connectionStateMessage, connectionString);
  }

  @Override
  public String toString() {
    return "Connection{" +
        "connectionState=" + connectionState +
        ", connectionStateMessage='" + connectionStateMessage + '\'' +
        ", connectionString='" + connectionString + '\'' +
        '}';
  }
}