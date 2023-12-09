package edu.lemon.database.data;

public record ConnectionData(boolean connectionState, String connectionString){
    public ConnectionData switchConnectionState(boolean enabled){
        return new ConnectionData(enabled, connectionString);
    }


}