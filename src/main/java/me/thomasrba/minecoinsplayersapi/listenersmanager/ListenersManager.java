package me.thomasrba.minecoinsplayersapi.listenersmanager;

import me.thomasrba.minecoinsplayersapi.MineCoinsPlayersAPI;
import me.thomasrba.minecoinsplayersapi.listenersmanager.player.ChatEvent;
import me.thomasrba.minecoinsplayersapi.listenersmanager.player.JoinEvent;
import me.thomasrba.minecoinsplayersapi.listenersmanager.player.QuitEvent;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;

public class ListenersManager {

    public MineCoinsPlayersAPI mineCoinsPlayersAPI;
    public PluginManager pluginManager;
    public ListenersManager(MineCoinsPlayersAPI main) {
        this.mineCoinsPlayersAPI = main;
        this.pluginManager = Bukkit.getPluginManager();
    }

    public void registerListener(){
        this.pluginManager.registerEvents(new JoinEvent(this.mineCoinsPlayersAPI), this.mineCoinsPlayersAPI);
        this.pluginManager.registerEvents(new ChatEvent(this.mineCoinsPlayersAPI), this.mineCoinsPlayersAPI);
        this.pluginManager.registerEvents(new QuitEvent(this.mineCoinsPlayersAPI), this.mineCoinsPlayersAPI);
    }
}
