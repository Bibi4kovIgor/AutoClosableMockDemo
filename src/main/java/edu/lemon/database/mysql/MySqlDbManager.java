package edu.lemon.database.mysql;

import edu.lemon.database.DatabaseManager;
import edu.lemon.database.data.ConnectionData;
import edu.lemon.database.exception.ConnectionException;

import static edu.lemon.database.mysql.MySqlStateMessage.*;

public class MySqlDbManager implements DatabaseManager {

    private static final String CONNECTION_ESTABLISHED_EXCEPTION = "Connection to MySQL was already established";
    private static final String CONNECTION_NOT_ESTABLISHED_EXCEPTION = "Connection to MySQL was not established";
    private ConnectionData connectionData;
    private String stateMessage;

    public MySqlDbManager(String stateMessage) {
        this.connectionData = new ConnectionData(false, stateMessage);
        this.stateMessage = DEFAULT_MESSAGE.getValue();
    }

    @Override
    public void connect() {
        if (connectionData.connectionState()) {
            throw new ConnectionException(CONNECTION_ESTABLISHED_EXCEPTION);
        }
        connectionData = connectionData.switchConnectionState(true);
        stateMessage = CONNECTION_ESTABLISHED_MESSAGE.getValue();
        stateMessage += connectionData.connectionString();
    }

    @Override
    public void disconnect() {
        if (!connectionData.connectionState()) {
            throw new ConnectionException(CONNECTION_NOT_ESTABLISHED_EXCEPTION);
        }
        connectionData = connectionData.switchConnectionState(false);
        stateMessage = CONNECTION_CLOSED_MESSAGE.getValue();
    }

    @Override
    public boolean checkConnectionState() {
        return connectionData.connectionState();
    }

    @Override
    public String getStateMessage() {
        return stateMessage;
    }
}
