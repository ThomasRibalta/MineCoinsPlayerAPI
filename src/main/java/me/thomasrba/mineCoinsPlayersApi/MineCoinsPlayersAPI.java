package me.thomasrba.mineCoinsPlayersApi;

import me.thomasrba.mineCoinsPlayersApi.DataBaseManager.DataBaseManagers;
import me.thomasrba.mineCoinsPlayersApi.commandManagers.GetStates;
import me.thomasrba.mineCoinsPlayersApi.listenersManager.ListenersManager;
import me.thomasrba.mineCoinsPlayersApi.playerManager.PlayerManagers;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public class MineCoinsPlayersAPI extends JavaPlugin {

    private MineCoinsPlayersAPI mineCoinsPlayersAPI;

    private DataBaseManagers dataBaseManagers;
    public PlayerManagers playerManagers;

    public MineCoinsPlayersAPI getMineCoinsPlayersAPI() {
        return this.mineCoinsPlayersAPI;
    }

    @Override
    public void onEnable() {
        this.mineCoinsPlayersAPI = this;
        this.dataBaseManagers = new DataBaseManagers();
        new ListenersManager(this).RegisterListener();
        this.playerManagers = new PlayerManagers(this);
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