package edu.lemon.database.postgres;

import edu.lemon.database.DatabaseManager;
import edu.lemon.database.connection.Connection;
import edu.lemon.database.exception.ConnectionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static edu.lemon.database.postgres.PostgresStateMessages.*;

public class PostgresDbManager implements DatabaseManager {


  private final Logger logger;

  private final Connection connection;

  public PostgresDbManager(Connection connection, Logger logger) {
    this.connection = connection;
    this.logger = logger;
  }

  public PostgresDbManager(Connection connection) {
    this(connection, LoggerFactory.getLogger(PostgresDbManager.class));
  }

  @Override
  public void connect() {
    try {
      connection.connect();
    } catch (ConnectionException e) {
      logger.error(e.getMessage(), e);
      return;
    }
    logger.info(CONNECTION_TO_POSTGRES_WAS_ESTABLISHED.messageText());
  }

  @Override
  public void disconnect() {
    try {
      connection.disconnect();
    } catch (ConnectionException e) {
      logger.error(e.getMessage(), e);
      throw new IllegalStateException(CONNECTION_TO_POSTGRES_WAS_NOT_ESTABLISHED.messageText());
    }
    logger.info(CONNECTION_TO_POSTGRES_WAS_CLOSED.messageText());
  }

  @Override
  public boolean checkConnectionState() {
    return connection.connectionState();
  }

  @Override
  public String getConnectionStateMessage() {
    return connection.connectionStateMessage();
  }
}
