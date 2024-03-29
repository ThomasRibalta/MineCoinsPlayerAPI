package me.thomasrba.minecoinsplayersapi.databasemanager;


import java.sql.SQLException;

public class DataBaseManagers {
    private DataBaseConnection dataBaseConnection;

    public DataBaseManagers() {
        this.dataBaseConnection = new DataBaseConnection(new DataBaseInformation("127.0.0.1", "root", null, "MineCoinsBdd", 3306));
    }

    public void close() {
        try{
            this.dataBaseConnection.close();
        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    public DataBaseConnection getDataBaseConnection(){
        return this.dataBaseConnection;
    }
}