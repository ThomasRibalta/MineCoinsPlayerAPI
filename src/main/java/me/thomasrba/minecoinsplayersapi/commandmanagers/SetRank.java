package me.thomasrba.minecoinsplayersapi.commandmanagers;

import me.thomasrba.minecoinsplayersapi.MineCoinsPlayersAPI;
import me.thomasrba.minecoinsplayersapi.playermanager.PlayerState;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class SetRank implements CommandExecutor {
    MineCoinsPlayersAPI mineCoinsPlayersAPI;
    public SetRank(MineCoinsPlayersAPI main){
        this.mineCoinsPlayersAPI = main;
    }
    @Override
    public boolean onCommand(CommandSender sender, Command command, java.lang.String s, java.lang.String[] strings) {
        if (!sender.hasPermission("admin.setrank")) {
            sender.sendMessage("permission");
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
        this.mineCoinsPlayersAPI.playerManagers.getPlayerState(player.getUniqueId()).setGradeId(Integer.parseInt(strings[1]));
        return true;
    }
}
