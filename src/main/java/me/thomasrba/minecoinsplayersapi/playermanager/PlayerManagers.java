package me.thomasrba.minecoinsplayersapi.playermanager;

import me.thomasrba.minecoinsplayersapi.MineCoinsPlayersAPI;
import me.thomasrba.minecoinsplayersapi.databasemanager.DataBaseManagers;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.UUID;

public class PlayerManagers {

    private final MineCoinsPlayersAPI mineCoinsPlayersAPI;


    private final DataBaseManagers dataBaseManagers;

    private final HashMap<UUID, PlayerGame> playerStates = new HashMap<>();

    public PlayerManagers(MineCoinsPlayersAPI main) {
        this.mineCoinsPlayersAPI = main;
        this.dataBaseManagers = new DataBaseManagers(this.mineCoinsPlayersAPI);
        loadOnlinePLayer();
    }

    public void addPlayerState(UUID uuid){
        playerStates.put(uuid, dataBaseManagers.getPlayer(uuid));
    }

    public void savePlayerState(UUID uuid){
        this.dataBaseManagers.savePlayer(this.playerStates.get(uuid));
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

    public HashMap<UUID, PlayerGame> getPlayerStates() {
        return playerStates;
    }

    public PlayerGame getPlayerState(UUID uuid) {
        PlayerGame playerGame = this.playerStates.get(uuid);
        return playerGame;
    }
}
