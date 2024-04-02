package me.thomasrba.minecoinsplayersapi;

import me.thomasrba.minecoinsplayersapi.commandmanagers.SetRank;
import me.thomasrba.minecoinsplayersapi.databasemanager.DataBaseManagers;
import me.thomasrba.minecoinsplayersapi.commandmanagers.GetStates;
import me.thomasrba.minecoinsplayersapi.listenersmanager.ListenersManager;
import me.thomasrba.minecoinsplayersapi.playermanager.PlayerManagers;
import me.thomasrba.minecoinsplayersapi.playermanager.PlayerRank;
import me.thomasrba.minecoinsplayersapi.utils.Board;
import me.thomasrba.minecoinsplayersapi.utils.TabList;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;

import javax.swing.*;
import java.util.Objects;

public class MineCoinsPlayersAPI extends JavaPlugin {

    private MineCoinsPlayersAPI mineCoinsPlayersAPI;
    public PlayerManagers playerManagers;

    private BukkitTask task1;

    private BukkitTask task2;
    @Override
    public void onEnable() {
        this.mineCoinsPlayersAPI = this;
        getCommand("getstates").setExecutor(new GetStates(this));
        getCommand("setrank").setExecutor(new SetRank(this));
        getCommand("setrank").setTabCompleter(new SetRank(this));
        this.playerManagers = new PlayerManagers(this);
        new ListenersManager(this).registerListener();

        task1 = getServer().getScheduler().runTaskTimer(this, Board.getInstance(), 20, 1);
        task2 = getServer().getScheduler().runTaskTimer(this, TabList.getInstance(), 20, 1);
    }

    @Override
    public void onDisable() {
        if (task1 != null){
            task1.cancel();
        }
        if (task2 != null){
            task2.cancel();
        }
    }

    public static MineCoinsPlayersAPI getInstance() {
        return getPlugin(MineCoinsPlayersAPI.class);
    }
}