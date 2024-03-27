package me.thomasrba.DataBaseManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

public class DataBaseConnection {

    private final DataBaseInformation dataBaseInformation;
    private Connection connection;

    public DataBaseConnection(DataBaseInformation dataBaseInformation) {
        this.dataBaseInformation = dataBaseInformation;
        this.Connect();
    }

    private void Connect(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection(this.dataBaseInformation.MakeURI(),
                    this.dataBaseInformation.getUser(), this.dataBaseInformation.getPass());
            Logger.getLogger("Minecraft").info("Succes to connect db");
        } catch (SQLException | ClassNotFoundException e ){
            e.printStackTrace();
        }
    }

    public void Close() throws SQLException {
        if (this.connection != null && !this.connection.isClosed()){
            this.connection.close();
        }
    }

    public Connection getConnection() throws SQLException {
        if (this.connection != null && !this.connection.isClosed()){
            return  this.connection;
        }

        this.Connect();
        return this.connection;
    }
}

