package edu.lemon.database.postgres;

import edu.lemon.database.connection.Connection;
import edu.lemon.database.exception.ConnectionException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.slf4j.Logger;

import static edu.lemon.database.connection.ConnectionStateMessages.DEFAULT_MESSAGE;
import static edu.lemon.database.postgres.PostgresStateMessages.CONNECTION_TO_POSTGRES_WAS_CLOSED;
import static edu.lemon.database.postgres.PostgresStateMessages.CONNECTION_TO_POSTGRES_WAS_ESTABLISHED;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PostgresDbManagerTests {

  private final String DEFAULT_EXCEPTION_CONNECTION_MESSAGE = "Connection was not established";

  @Mock
  private Connection connection;

  @Mock
  private Logger logger;

  private PostgresDbManager postgresDbManager;

  @BeforeEach
  void setUp() {
    connection = mock(Connection.class);
    logger = mock(Logger.class);
    postgresDbManager = new PostgresDbManager(connection, logger);
  }

  @Test
  void connect_ConnectToDatabase_ChangesConnectionStatusToOpened() {
    // Act
    postgresDbManager.connect();

    // Assert
    verify(logger).info(CONNECTION_TO_POSTGRES_WAS_ESTABLISHED.messageText());
  }

  @Test
  void open_ConnectionOpen_ThrowsException() throws ConnectionException {
    // Arrange
    doThrow(new ConnectionException(DEFAULT_EXCEPTION_CONNECTION_MESSAGE))
        .when(connection).connect();

    // Act - emulate exception raising on connection.connect() method call
    postgresDbManager.connect();

    // Assert
    verify(logger).error(eq(DEFAULT_EXCEPTION_CONNECTION_MESSAGE), any(Throwable.class));
  }

  @Test
  void disconnect_ClosingConnectionIfItWasEstablished_CloseConnection() throws ConnectionException {
    // Arrange
    doNothing().when(connection).disconnect();

    // Act
    postgresDbManager.disconnect();

    // Assert
    verify(logger).info(CONNECTION_TO_POSTGRES_WAS_CLOSED.messageText());
  }

  @Test
  void disconnect_ClosingConnectionIfItWasEstablished_ThrowsException() throws ConnectionException {
    // Arrange
    doThrow(new ConnectionException(DEFAULT_EXCEPTION_CONNECTION_MESSAGE)).when(connection).disconnect();

    // Act & Assert
    assertThrows(IllegalStateException.class, () -> postgresDbManager.disconnect());
    verify(logger).error(eq(DEFAULT_EXCEPTION_CONNECTION_MESSAGE), any(Throwable.class));
  }

  @Test
  void checkConnectionState_ChecksConnectionsState_ReturnsTrue() {
    // Arrange
    when(connection.connectionState()).thenReturn(true);

    // Act & Assert
    assertTrue(postgresDbManager.checkConnectionState());
  }

  @Test
  void checkConnectionState_ChecksConnectionsState_ReturnsFalse() {
    // Arrange
    when(connection.connectionState()).thenReturn(false);

    // Act & Assert
    assertFalse(postgresDbManager.checkConnectionState());

  }

  @Test
  void getConnectionStateMessage_ReturnsConnectionString() {
    // Arrange
    when(connection.connectionStateMessage()).thenReturn(DEFAULT_MESSAGE.getValue());

    // Act & Assert
    assertEquals(postgresDbManager.getConnectionStateMessage(), DEFAULT_MESSAGE.getValue());

  }
}