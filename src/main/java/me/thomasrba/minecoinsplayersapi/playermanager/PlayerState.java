package me.thomasrba.minecoinsplayersapi.playermanager;

import me.thomasrba.minecoinsplayersapi.MineCoinsPlayersAPI;
import org.bukkit.entity.Player;
import org.bukkit.permissions.PermissionAttachment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

public class PlayerState {
    private final MineCoinsPlayersAPI main;
    private final UUID uuid;
    private final String psuedo;
    private final Player player;
    private int money;
    private int gradeId;
    private int boutiquePts;

    private final PermissionAttachment permissionAttachment;

    public PlayerState(MineCoinsPlayersAPI main, UUID uuid, Player p) {
        this.main = main;
        this.uuid = uuid;
        this.psuedo = p.getName();
        this.player = p;
        this.gradeId = 0;
        this.money = 0;
        this.boutiquePts = 0;
        this.permissionAttachment = this.player.addAttachment(this.main);
        addPlayerPermission(PlayerRank.getRankMap(this.gradeId).getGradePermissions());
    }

    public void addPlayerPermission(List<String> gradePermission){
        for (String permission : gradePermission) {
            System.out.println(permission);
            this.permissionAttachment.setPermission(permission, true);
        }
    }

    public void removePlayerPermission(List<String> gradePermission){
        for (String permission : gradePermission) {
            System.out.println(permission);
            this.permissionAttachment.unsetPermission(permission);
        }
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

    public int getGradeId() {
        return this.gradeId;
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

    public void setGradeId(int gradeId) {
        this.removePlayerPermission(PlayerRank.getRankMap(this.gradeId).getGradePermissions());
        this.gradeId = gradeId;
        this.addPlayerPermission(PlayerRank.getRankMap(this.gradeId).getGradePermissions());
    }
}