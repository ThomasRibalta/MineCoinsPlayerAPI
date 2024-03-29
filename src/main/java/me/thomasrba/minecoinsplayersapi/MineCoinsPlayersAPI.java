package me.thomasrba.minecoinsplayersapi;

import me.thomasrba.minecoinsplayersapi.commandmanagers.SetRank;
import me.thomasrba.minecoinsplayersapi.databasemanager.DataBaseManagers;
import me.thomasrba.minecoinsplayersapi.commandmanagers.GetStates;
import me.thomasrba.minecoinsplayersapi.listenersmanager.ListenersManager;
import me.thomasrba.minecoinsplayersapi.playermanager.PlayerManagers;
import me.thomasrba.minecoinsplayersapi.playermanager.PlayerRank;
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
        new ListenersManager(this).registerListener();
        this.playerManagers = new PlayerManagers(this);

        Objects.requireNonNull(getCommand("getStates")).setExecutor(new GetStates(this));
        Objects.requireNonNull(getCommand("setRank")).setExecutor(new SetRank(this));
    }

    @Override
    public void onDisable() {
        this.dataBaseManagers.close();
    }

    public DataBaseManagers getDataBaseManagers() {
        return dataBaseManagers;
    }
}