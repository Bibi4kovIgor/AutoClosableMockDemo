package edu.lemon.database;

import edu.lemon.database.data.ConnectionData;
import edu.lemon.database.mysql.MySqlDbManager;
import edu.lemon.database.postgres.PostgresDbManager;

public class Launcher {
    public static void main(String[] args) {

        DatabaseManager postgresDatabaseManager = new PostgresDbManager(ConnectorTypes.POSTGRES.getConnectorUrl());
        postgresDatabaseManager.connect();
        System.out.println(postgresDatabaseManager.getStateMessage());
        postgresDatabaseManager.disconnect();
        System.out.println(postgresDatabaseManager.checkConnectionState());

        DatabaseManager mySqlDatabaseManager = new MySqlDbManager(ConnectorTypes.MY_SQL.getConnectorUrl());
        mySqlDatabaseManager.connect();
        System.out.println(mySqlDatabaseManager.getStateMessage());
        mySqlDatabaseManager.disconnect();
        System.out.println(mySqlDatabaseManager.checkConnectionState());


    }
}
