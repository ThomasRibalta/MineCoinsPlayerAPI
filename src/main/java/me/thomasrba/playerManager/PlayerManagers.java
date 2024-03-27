package me.thomasrba.playerManager;

import me.thomasrba.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Objects;
import java.util.UUID;

public class PlayerManagers {

    Main main;

    public final HashMap<UUID, PlayerState> PlayerStates = new HashMap<UUID, PlayerState>();
    public PlayerManagers(Main main) {
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
}
