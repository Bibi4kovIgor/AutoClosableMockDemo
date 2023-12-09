package edu.lemon.database;

public enum ConnectorTypes {
    POSTGRES("jdbc:postgres"), MY_SQL("jdbc:mysql");

    private final String connectorUrl;
    ConnectorTypes(String connectorUrl) {
        this.connectorUrl = connectorUrl;
    }

    public String getConnectorUrl() {
        return connectorUrl;
    }
}
