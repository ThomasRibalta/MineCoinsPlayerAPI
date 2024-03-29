package me.thomasrba.minecoinsplayersapi.playermanager;

import me.thomasrba.minecoinsplayersapi.MineCoinsPlayersAPI;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Objects;
import java.util.UUID;

public class PlayerManagers {

    MineCoinsPlayersAPI mineCoinsPlayersAPI;

    public final HashMap<UUID, PlayerState> playerStates = new HashMap<UUID, PlayerState>();

    public PlayerManagers(MineCoinsPlayersAPI main) {
        this.mineCoinsPlayersAPI = main;
        loadOnlinePLayer();
    }

    public void addPlayerState(UUID uuid){
        playerStates.put(uuid, new PlayerState(this.mineCoinsPlayersAPI, uuid, Objects.requireNonNull(Bukkit.getPlayer(uuid))));
    }

    public void removePlayerState(UUID uuid){
        playerStates.remove(uuid);
    }

    private void loadOnlinePLayer(){
        for (Player p: Bukkit.getOnlinePlayers())
        {
            addPlayerState(p.getUniqueId());
        }
    }

    public HashMap<UUID, PlayerState> getPlayerStates() {
        return playerStates;
    }
}
