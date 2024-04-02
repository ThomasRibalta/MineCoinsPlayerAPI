package me.thomasrba.minecoinsplayersapi.utils;

import me.thomasrba.minecoinsplayersapi.MineCoinsPlayersAPI;
import me.thomasrba.minecoinsplayersapi.playermanager.PlayerRank;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

public class TabList implements Runnable{
    private final static TabList instance = new TabList();

    private TabList() {
    }

    @Override
    public void run() {
        for (Player player : Bukkit.getOnlinePlayers()) {
                manageTabList(player);
        }
    }

    private void manageTabList(Player player) {
        player.setPlayerListHeader("Ligne du haut pour s'en souvenir\n");
        player.setPlayerListFooter("\nLigne du bas pour s'en souvenir");
        player.setPlayerListName(PlayerRank.getRankMap(MineCoinsPlayersAPI.getInstance().playerManagers.getPlayerState(player.getUniqueId()).getRankId()).getPrefix() + player.getName());
    }

    public static TabList getInstance() {
        return instance;
    }
}
