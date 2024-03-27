package me.thomasrba.listenersManager.player;

import me.thomasrba.DataBaseManager.DataBaseConnection;
import me.thomasrba.Main;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;
import java.util.UUID;

public class JoinEvent implements Listener {

    Main main;
    public JoinEvent(Main main) {
        this.main = main;
    }

    @EventHandler
    public void playerJoinEvent(PlayerJoinEvent ev){
        ev.setJoinMessage("+ 1");
        final UUID uuid = ev.getPlayer().getUniqueId();
        final DataBaseConnection dataBaseConnection = this.main.getDataBaseManagers().getDataBaseConnection();
        try{
            final Connection connection = dataBaseConnection.getConnection();
            final PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Players WHERE uuid = ?");
            preparedStatement.setString(1,uuid.toString());
            final ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                ev.getPlayer().sendMessage("Tu es deja dans nos donné hahahahaha");
            }else{
                this.addUserDataBase(connection, uuid);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void addUserDataBase(Connection connection, UUID uuid){
        try{
            final PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Players VALUES (?,?,?,?,?)");
            preparedStatement.setString(1,uuid.toString());
            preparedStatement.setString(2, Objects.requireNonNull(Bukkit.getPlayer(uuid)).getName());
            preparedStatement.setInt(3, 1);
            preparedStatement.setInt(4, 0);
            preparedStatement.setInt(5, 0);
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
