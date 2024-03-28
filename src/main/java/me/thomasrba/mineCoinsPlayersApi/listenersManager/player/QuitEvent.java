package me.thomasrba.mineCoinsPlayersApi.listenersManager.player;

import me.thomasrba.mineCoinsPlayersApi.MineCoinsPlayersAPI;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class QuitEvent implements Listener {

    MineCoinsPlayersAPI main;

    public QuitEvent(MineCoinsPlayersAPI main){
        this.main = main;
    }

    @EventHandler
    public void playerQuitEvent(PlayerQuitEvent e){
        this.main.playerManagers.removePlayerState(e.getPlayer().getUniqueId());
    }

}
