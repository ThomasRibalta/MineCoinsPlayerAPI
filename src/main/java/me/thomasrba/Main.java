package me.thomasrba;

import me.thomasrba.DataBaseManager.DataBaseManagers;
import me.thomasrba.listenersManager.ListenersManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    public static Main INSTANCE;

    private DataBaseManagers dataBaseManagers;

    @Override
    public void onEnable() {
        INSTANCE = this;
        this.dataBaseManagers = new DataBaseManagers();
        new ListenersManager(this).RegisterListener();
    }

    @Override
    public void onDisable() {
        this.dataBaseManagers.close();
    }

    public DataBaseManagers getDataBaseManagers() {
        return dataBaseManagers;
    }
}