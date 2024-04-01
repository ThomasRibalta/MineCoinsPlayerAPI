package me.thomasrba.minecoinsplayersapi.listenersmanager.player;

import me.thomasrba.minecoinsplayersapi.MineCoinsPlayersAPI;
import me.thomasrba.minecoinsplayersapi.databasemanager.DataBaseConnection;
import me.thomasrba.minecoinsplayersapi.playermanager.PlayerRank;
import me.thomasrba.minecoinsplayersapi.utils.Board;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.permissions.PermissionAttachment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;
import java.util.UUID;

public class JoinEvent implements Listener {

    MineCoinsPlayersAPI mineCoinsPlayersAPI;

    public JoinEvent(MineCoinsPlayersAPI main) {
        this.mineCoinsPlayersAPI = main;
    }

    @EventHandler
    public void playerJoinEvent(PlayerJoinEvent ev) {
        final Player player = ev.getPlayer();
        final UUID uuid = player.getUniqueId();
        this.mineCoinsPlayersAPI.playerManagers.addPlayerState(uuid);
        String prefix = PlayerRank.getRankMap(this.mineCoinsPlayersAPI.playerManagers.getPlayerState(uuid).getRankId()).getPrefix();
        player.updateCommands();
        player.sendMessage("test");
    }
}
