package edu.lemon.database;


import edu.lemon.database.connection.Connection;
import edu.lemon.database.mysql.MySqlDbManager;
import edu.lemon.database.postgres.PostgresDbManager;

public class Launcher {
  public static void main(String[] args) {


    Connection connection = new Connection(ConnectorTypes.POSTGRES.getConnectorUrl());

    DatabaseManager postgresDatabaseManager = new PostgresDbManager(connection);
    postgresDatabaseManager.connect();
    System.out.println(postgresDatabaseManager.getConnectionStateMessage());
    postgresDatabaseManager.disconnect();
    System.out.println(postgresDatabaseManager.checkConnectionState());

    DatabaseManager mySqlDatabaseManager = new MySqlDbManager(ConnectorTypes.MY_SQL.getConnectorUrl());
    mySqlDatabaseManager.connect();
    System.out.println(mySqlDatabaseManager.getConnectionStateMessage());
    mySqlDatabaseManager.disconnect();
    System.out.println(mySqlDatabaseManager.checkConnectionState());


  }
}
