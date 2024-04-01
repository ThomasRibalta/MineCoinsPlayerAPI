package me.thomasrba.minecoinsplayersapi.playermanager;

import me.thomasrba.minecoinsplayersapi.MineCoinsPlayersAPI;
import org.bukkit.entity.Player;
import org.bukkit.permissions.PermissionAttachment;

import java.util.List;
import java.util.UUID;

public class PlayerGame {
    private final MineCoinsPlayersAPI main;
    private final UUID uuid;
    private final String psuedo;
    private final Player player;
    private int money;
    private int rankId;
    private int boutiquePts;

    private final PermissionAttachment permissionAttachment;

    public PlayerGame(MineCoinsPlayersAPI main, UUID uuid, Player p) {
        this.main = main;
        this.uuid = uuid;
        this.psuedo = p.getName();
        this.player = p;
        this.rankId = 1;
        this.money = 0;
        this.boutiquePts = 0;
        this.permissionAttachment = this.player.addAttachment(this.main);
        addPlayerPermission(PlayerRank.getRankMap(this.rankId).getGradePermissions());
    }

    public void addPlayerPermission(List<String> gradePermission){
        for (String permission : gradePermission) {
            this.permissionAttachment.setPermission(permission, true);
        }
        player.recalculatePermissions();
        player.updateCommands();
    }

    public void removePlayerPermission(List<String> gradePermission){
        for (String permission : gradePermission) {
            this.permissionAttachment.unsetPermission(permission);
        }
        player.recalculatePermissions();
        player.updateCommands();
    }

    public UUID getUuid() {
        return uuid;
    }

    public String getPsuedo() {
        return psuedo;
    }

    public Player getPlayer() {
        return player;
    }

    public int getMoney() {
        return this.money;
    }

    public int getRankId() {
        return this.rankId;
    }

    public int getBoutiquePts() {
        return this.boutiquePts;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void setBoutiquePts(int boutiquePts) {
        this.boutiquePts = boutiquePts;
    }

    public void setRankId(int gradeId) {
        this.removePlayerPermission(PlayerRank.getRankMap(this.rankId).getGradePermissions());
        this.rankId = gradeId;
        this.addPlayerPermission(PlayerRank.getRankMap(this.rankId).getGradePermissions());
    }
}