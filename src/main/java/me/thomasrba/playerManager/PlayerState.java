package me.thomasrba.playerManager;

import me.thomasrba.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class PlayerState {
    private final Main main;
    private final UUID uuid;
    private final String psuedo;
    private final Player player;
    private int money;
    private int PlayerRank_id;
    private int boutique_pts;

    public PlayerState(Main main, UUID uuid, Player p) {
        this.main = main;
        this.uuid = uuid;
        this.psuedo = p.getName();
        this.player = p;
        this.money = this.getSQLMoney(uuid);
        this.PlayerRank_id = this.getSQLRankID(uuid);
        this.boutique_pts = this.getSQLBoutique_pts(uuid);

    }

    private int getSQLMoney(UUID uuid){
        try {
            Connection connection = this.main.getDataBaseManagers().getDataBaseConnection().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT money FROM Players WHERE UUID = ?");
            preparedStatement.setString(1, uuid.toString());
            ResultSet resultSet  = preparedStatement.executeQuery();
            if (resultSet.next()){
                return resultSet.getInt(1);
            }else{
                return (1000);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return 0;
    }

    private int getSQLRankID(UUID uuid){
        try {
            Connection connection = this.main.getDataBaseManagers().getDataBaseConnection().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT grade_id FROM Players WHERE UUID = ?");
            preparedStatement.setString(1, uuid.toString());
            ResultSet resultSet  = preparedStatement.executeQuery();
            if (resultSet.next()){
                return resultSet.getInt(1);
            }else{
                return (1000);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return 1;
    }

    private int getSQLBoutique_pts(UUID uuid){
        try {
            Connection connection = this.main.getDataBaseManagers().getDataBaseConnection().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT boutique_pts FROM Players WHERE UUID = ?");
            preparedStatement.setString(1, uuid.toString());
            ResultSet resultSet  = preparedStatement.executeQuery();
            if (resultSet.next()){
                return resultSet.getInt(1);
            }else{
                return (1000);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return 1;
    }

    public UUID getUuid() {
        return uuid;
    }

    public String getPsuedo() {
        return psuedo;
    }

    public Player getPlayer() {
        return player;
    }

    public int getMoney() {
        return this.money;
    }

    public int getPlayerRank_id() {
        return this.PlayerRank_id;
    }

    public int getBoutique_pts() {
        return this.boutique_pts;
    }
}
