package me.thomasrba.mineCoinsPlayersApi.listenersManager;

import me.thomasrba.mineCoinsPlayersApi.MineCoinsPlayersAPI;
import me.thomasrba.mineCoinsPlayersApi.listenersManager.player.JoinEvent;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;

public class ListenersManager {

    public MineCoinsPlayersAPI main;
    public PluginManager pluginManager;
    public ListenersManager(MineCoinsPlayersAPI main) {
        this.main = main;
        this.pluginManager = Bukkit.getPluginManager();
    }

    public void RegisterListener(){
        this.pluginManager.registerEvents(new JoinEvent(this.main), this.main);
//        this.pluginManager.registerEvents(new LeaveEvent(this.main), this.main);
    }
}
