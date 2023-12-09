package edu.lemon.database;

import edu.lemon.database.data.ConnectionData;
import edu.lemon.database.postgres.PostgresDbManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

class PostgresDbManagerTests {

    @Mock
    private static ConnectionData connectionData;

    private static PostgresDbManager databaseManager;
    @BeforeAll
    static void setUp() {
        connectionData = mock(ConnectionData.class);
        databaseManager = new PostgresDbManager(ConnectorTypes.POSTGRES.getConnectorUrl());
    }

    @Test
    void open_ConnectionOpen_ChangesConnectionStatusToOpened() {
        // Arrange
        when(connectionData.switchConnectionState(true)).thenReturn(connectionData);

        // Act
        databaseManager.connect();

        // Assert
        assertTrue(databaseManager.checkConnectionState());
    }

    @Test
    void close_ConnectionClose_ChangesConnectionStatusToClosed() {
    }

    @Test
    void execute_executeSomeRequest_ReturnsString() {
    }

    @Test
    void status_getConnectionStatusMessage_ReturnsString() {
    }
}