package me.thomasrba.minecoinsplayersapi.listenersmanager.player;

import me.thomasrba.minecoinsplayersapi.MineCoinsPlayersAPI;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class QuitEvent implements Listener {

    MineCoinsPlayersAPI mineCoinsPlayersAPI;

    public QuitEvent(MineCoinsPlayersAPI main){
        this.mineCoinsPlayersAPI = main;
    }

    @EventHandler
    public void playerQuitEvent(PlayerQuitEvent e){
        this.mineCoinsPlayersAPI.playerManagers.savePlayerState(e.getPlayer().getUniqueId());
        this.mineCoinsPlayersAPI.playerManagers.removePlayerState(e.getPlayer().getUniqueId());
    }

}
