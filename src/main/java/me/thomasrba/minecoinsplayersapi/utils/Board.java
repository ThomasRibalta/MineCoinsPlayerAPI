package me.thomasrba.minecoinsplayersapi.utils;

import me.thomasrba.minecoinsplayersapi.MineCoinsPlayersAPI;
import me.thomasrba.minecoinsplayersapi.playermanager.PlayerRank;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.*;
import org.bukkit.ChatColor;
import org.bukkit.Statistic;

import java.util.UUID;

public final class Board implements Runnable {

    private final static Board instance = new Board();

    private Board() {
    }

    @Override
    public void run() {
        for (Player player : Bukkit.getOnlinePlayers()) {
            if (player.getScoreboard() != null && player.getScoreboard().getObjective(MineCoinsPlayersAPI.getInstance().getName()) != null)
                updateScoreboard(player);
            else
                createNewScoreboard(player);
        }
    }

    private void createNewScoreboard(Player player) {
        Scoreboard scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();
        Objective objective = scoreboard.registerNewObjective(MineCoinsPlayersAPI.getInstance().getName(), "youhou");
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);
        objective.setDisplayName("§6§lMineCoins§f§lMC");

        objective.getScore("§8▶━━━━━━━━━━━━━━━━━◀").setScore(3);
        objective.getScore("§7§l Joueur").setScore(2);

        Team rank = scoreboard.registerNewTeam("rank");
        String teamKey = ChatColor.WHITE.toString();
        rank.addEntry(teamKey);
        rank.setPrefix("§7    Rank: ");
        rank.setSuffix("null");
        objective.getScore(teamKey).setScore(1);

        Team token = scoreboard.registerNewTeam("token");
        String tokenKey = ChatColor.RED.toString();
        token.addEntry(tokenKey);
        token.setPrefix("§7    Token: ");
        token.setSuffix("null");
        objective.getScore(tokenKey).setScore(0);

        player.setScoreboard(scoreboard);
    }

    private void updateScoreboard(Player player) {
        Scoreboard scoreboard = player.getScoreboard();
        Team rank = scoreboard.getTeam("rank");
        assert rank != null;
        rank.setSuffix(PlayerRank.getRankMap(MineCoinsPlayersAPI.getInstance().playerManagers.getPlayerState(player.getUniqueId()).getRankId()).getPrefix());


        Team token = scoreboard.getTeam("token");
        assert token != null;
        token.setSuffix(String.valueOf(MineCoinsPlayersAPI.getInstance().playerManagers.getPlayerState(player.getUniqueId()).getBoutiquePts()));
    }

    public static Board getInstance() {
        return instance;
    }
}