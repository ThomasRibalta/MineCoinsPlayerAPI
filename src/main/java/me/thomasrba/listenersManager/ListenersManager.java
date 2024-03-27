package me.thomasrba.listenersManager;

import me.thomasrba.Main;
import me.thomasrba.listenersManager.player.JoinEvent;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;

public class ListenersManager {

    public Main main;
    public PluginManager pluginManager;
    public ListenersManager(Main main) {
        this.main = main;
        this.pluginManager = Bukkit.getPluginManager();
    }

    public void RegisterListener(){
        this.pluginManager.registerEvents(new JoinEvent(this.main), this.main);
//        this.pluginManager.registerEvents(new LeaveEvent(this.main), this.main);
    }
}
