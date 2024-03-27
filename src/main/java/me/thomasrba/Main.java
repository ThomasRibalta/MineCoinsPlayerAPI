package me.thomasrba;

import me.thomasrba.DataBaseManager.DataBaseManagers;
import me.thomasrba.commandManagers.GetStates;
import me.thomasrba.listenersManager.ListenersManager;
import me.thomasrba.playerManager.PlayerManagers;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public class Main extends JavaPlugin {

    public static Main INSTANCE;

    private DataBaseManagers dataBaseManagers;
    public PlayerManagers playerManagers;

    @Override
    public void onEnable() {
        INSTANCE = this;
        this.dataBaseManagers = new DataBaseManagers();
        this.playerManagers = new PlayerManagers(this);
        new ListenersManager(this).RegisterListener();
        Objects.requireNonNull(getCommand("getStates")).setExecutor(new GetStates(this));
    }

    @Override
    public void onDisable() {
        this.dataBaseManagers.close();
    }

    public DataBaseManagers getDataBaseManagers() {
        return dataBaseManagers;
    }
}