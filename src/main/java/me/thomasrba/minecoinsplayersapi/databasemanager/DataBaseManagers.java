package me.thomasrba.minecoinsplayersapi.databasemanager;


import me.thomasrba.minecoinsplayersapi.MineCoinsPlayersAPI;
import me.thomasrba.minecoinsplayersapi.playermanager.PlayerGame;
import org.bukkit.Bukkit;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;
import java.util.UUID;

public class DataBaseManagers {
    private DataBaseConnection dataBaseConnection;
    private MineCoinsPlayersAPI mineCoinsPlayersAPI;

    public DataBaseManagers(MineCoinsPlayersAPI mineCoinsPlayersAPI) {
        this.mineCoinsPlayersAPI = mineCoinsPlayersAPI;
        this.dataBaseConnection = new DataBaseConnection(new DataBaseInformation("127.0.0.1", "root", null, "MineCoinsBdd", 3306));
    }

    public void close() {
        try{
            this.dataBaseConnection.close();
        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    public PlayerGame getPlayer(UUID uuid) {
        final DataBaseConnection dataBaseConnection = this.dataBaseConnection;
        PlayerGame playerGame = new PlayerGame(this.mineCoinsPlayersAPI, uuid, Objects.requireNonNull(Bukkit.getPlayer(uuid)));
        try {
            final Connection connection = dataBaseConnection.getConnection();
            final PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Players WHERE uuid = ?");
            preparedStatement.setString(1, uuid.toString());
            final ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                playerGame.setMoney(resultSet.getInt(4));
                playerGame.setBoutiquePts(resultSet.getInt(5));
                playerGame.setRankId(resultSet.getInt(3));
            } else {
                this.addUserDataBase(uuid);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return playerGame;
    }

    public void savePlayer(PlayerGame playerState) {
        final DataBaseConnection dataBaseConnection = this.dataBaseConnection;
        final UUID uuid = playerState.getUuid();
        try {
            final Connection connection = dataBaseConnection.getConnection();
            final PreparedStatement preparedStatement = connection.prepareStatement("UPDATE Players SET grade_id = ?, money = ?, boutique_pts = ? WHERE uuid = ?");
            preparedStatement.setInt(1, playerState.getRankId());
            preparedStatement.setInt(2, playerState.getMoney());
            preparedStatement.setInt(3, playerState.getBoutiquePts());
            preparedStatement.setString(4, uuid.toString());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void addUserDataBase(UUID uuid) {
        try {
            final PreparedStatement preparedStatement = this.dataBaseConnection.getConnection().prepareStatement("INSERT INTO Players VALUES (?,?,?,?,?)");
            preparedStatement.setString(1, uuid.toString());
            preparedStatement.setString(2, Objects.requireNonNull(Bukkit.getPlayer(uuid)).getName());
            preparedStatement.setInt(3, 1);
            preparedStatement.setInt(4, 0);
            preparedStatement.setInt(5, 0);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
