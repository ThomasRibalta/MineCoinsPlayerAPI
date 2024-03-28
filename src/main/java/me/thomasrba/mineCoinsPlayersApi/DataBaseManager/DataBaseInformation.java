package me.thomasrba.mineCoinsPlayersApi.DataBaseManager;

public class DataBaseInformation {
    private String host;
    private String user;
    private String pass;
    private String databaseName;
    private int port;

    public DataBaseInformation(String host, String user, String pass, String databaseName, int port){
        this.host = host;
        this.user = user;
        this.pass = pass;
        this.databaseName = databaseName;
        this.port = port;
    }

    public String MakeURI(){
        final StringBuilder sb = new StringBuilder();

        sb.append("jdbc:mysql://")
                .append(host)
                .append(":")
                .append(port)
                .append("/")
                .append(databaseName);

        return sb.toString();
    }

    public String getUser() {
        return user;
    }

    public String getPass() {
        return pass;
    }
}