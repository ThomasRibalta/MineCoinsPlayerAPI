package me.thomasrba.minecoinsplayersapi.listenersmanager.player;

import me.thomasrba.minecoinsplayersapi.MineCoinsPlayersAPI;
import me.thomasrba.minecoinsplayersapi.playermanager.PlayerRank;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.UUID;

public class ChatEvent implements Listener {

    MineCoinsPlayersAPI mineCoinsPlayersAPI;
    public ChatEvent(MineCoinsPlayersAPI main) {
        this.mineCoinsPlayersAPI = main;
    }

    @EventHandler
    public void onChatEvent(AsyncPlayerChatEvent ev){
        Player player = ev.getPlayer();
        UUID uuid = player.getUniqueId();
        PlayerRank playerRank = PlayerRank.rankMap.get(this.mineCoinsPlayersAPI.playerManagers.playerStates.get(uuid).getGradeId());
        ev.setFormat(playerRank.getPrefix() + " " + player.getName() + "§f " + ev.getMessage());

    }
}
