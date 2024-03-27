package me.thomasrba.listenersManager.player;

import me.thomasrba.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class QuitEvent implements Listener {

    Main main;

    public QuitEvent(Main main){
        this.main = main;
    }

    @EventHandler
    public void playerQuitEvent(PlayerQuitEvent e){
        this.main.playerManagers.removePlayerState(e.getPlayer().getUniqueId());
    }

}
