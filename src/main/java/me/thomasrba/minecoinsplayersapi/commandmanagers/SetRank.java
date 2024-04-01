package me.thomasrba.minecoinsplayersapi.commandmanagers;

import me.thomasrba.minecoinsplayersapi.MineCoinsPlayersAPI;
import org.bukkit.Bukkit;
import org.bukkit.command.*;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SetRank implements CommandExecutor, TabCompleter {
    MineCoinsPlayersAPI mineCoinsPlayersAPI;
    public SetRank(MineCoinsPlayersAPI main){
        this.mineCoinsPlayersAPI = main;
    }
    @Override
    public boolean onCommand(CommandSender sender, Command command, java.lang.String s, java.lang.String[] strings) {
        if (!sender.hasPermission("admin.setrank")) {
            sender.sendMessage("you don't permission");
            return false;
        }
        if (strings.length != 2){
            sender.sendMessage("argument" + strings.length);
            return false;
        }
        Player player = Bukkit.getPlayer(strings[0]);
        if (player == null){
            return false;
        }
        this.mineCoinsPlayersAPI.playerManagers.getPlayerState(player.getUniqueId()).setRankId(Integer.parseInt(strings[1]));
        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender commandSender, Command command, String s, String[] strings) {
        return new ArrayList<>();
    }
}
