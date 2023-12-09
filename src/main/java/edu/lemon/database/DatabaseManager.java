package edu.lemon.database;

public interface DatabaseManager {
    void connect();
    void disconnect();
    boolean checkConnectionState();
    String getStateMessage();
}
