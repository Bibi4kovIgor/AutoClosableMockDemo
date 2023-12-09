package edu.lemon.database.postgres;

import edu.lemon.database.DatabaseManager;
import edu.lemon.database.data.ConnectionData;

import javax.swing.plaf.PanelUI;

import static edu.lemon.database.postgres.PostgresStateMessage.*;

public class PostgresDbManager implements DatabaseManager {
    private ConnectionData connectionData;
    private String stateMessage;

    public PostgresDbManager(String connectionString) {
        this.connectionData = new ConnectionData(false, connectionString);
        this.stateMessage = DEFAULT_MESSAGE.getValue();
    }

    @Override
    public void connect() {
        connectionData = connectionData.switchConnectionState(true);
        stateMessage = CONNECTION_ESTABLISHED_MESSAGE.getValue();
        stateMessage += connectionData.connectionString();
    }

    @Override
    public void disconnect() {
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
