package edu.lemon.database.mysql;

import edu.lemon.database.DatabaseManager;
import edu.lemon.database.connection.Connection;
import edu.lemon.database.exception.ConnectionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MySqlDbManager implements DatabaseManager {

  private final static Logger logger = LoggerFactory.getLogger(MySqlDbManager.class);

  private static final String CONNECTION_ESTABLISHED = "Connection to MySQL was established";
  private static final String CONNECTION_CLOSED = "Connection to MySQL was closed";
  private final Connection connection;

  public MySqlDbManager(String stateMessage) {
    this.connection = new Connection(stateMessage);
  }

  @Override
  public void connect() {
    try {
      connection.connect();
    } catch (ConnectionException e) {
      logger.error(e.getMessage());
    }
    logger.info(CONNECTION_ESTABLISHED);
  }

  @Override
  public void disconnect() {
    try {
      connection.disconnect();
    } catch (ConnectionException e) {
      logger.error(e.getMessage());
    }
    logger.info(CONNECTION_CLOSED);
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
