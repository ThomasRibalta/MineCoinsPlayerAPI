package me.thomasrba.mineCoinsPlayersApi.commandManagers;

import me.thomasrba.mineCoinsPlayersApi.MineCoinsPlayersAPI;
import me.thomasrba.mineCoinsPlayersApi.playerManager.PlayerState;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class GetStates implements CommandExecutor {

    MineCoinsPlayersAPI main;
    public GetStates(MineCoinsPlayersAPI main){
        this.main = main;
    }
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, java.lang.String s, java.lang.String[] strings) {
        for (PlayerState playerState: this.main.playerManagers.PlayerStates.values()){
            commandSender.sendMessage(String.valueOf(playerState.getUuid()));
            commandSender.sendMessage(String.valueOf(playerState.getPsuedo()));
            commandSender.sendMessage(String.valueOf(playerState.getPlayerRank_id()));
            commandSender.sendMessage(String.valueOf(playerState.getMoney()));
            commandSender.sendMessage(String.valueOf(playerState.getBoutique_pts()));
        }
        return false;
    }
}
