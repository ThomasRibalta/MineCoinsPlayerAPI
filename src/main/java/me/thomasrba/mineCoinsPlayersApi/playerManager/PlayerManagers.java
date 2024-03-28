package me.thomasrba.mineCoinsPlayersApi.playerManager;

import me.thomasrba.mineCoinsPlayersApi.MineCoinsPlayersAPI;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Objects;
import java.util.UUID;

public class PlayerManagers {

    MineCoinsPlayersAPI main;

    public final HashMap<UUID, PlayerState> PlayerStates = new HashMap<UUID, PlayerState>();

    public PlayerManagers(MineCoinsPlayersAPI main) {
        this.main = main;
        loadOnlinePLayer();
    }

    public void addPlayerState(UUID uuid){
        PlayerStates.put(uuid, new PlayerState(this.main, uuid, Objects.requireNonNull(Bukkit.getPlayer(uuid))));
    }

    public void removePlayerState(UUID uuid){
        PlayerStates.remove(uuid);
    }

    private void loadOnlinePLayer(){
        for (Player p: Bukkit.getOnlinePlayers())
        {
            addPlayerState(p.getUniqueId());
        }
    }

    public HashMap<UUID, PlayerState> getPlayerStates() {
        return PlayerStates;
    }
}
