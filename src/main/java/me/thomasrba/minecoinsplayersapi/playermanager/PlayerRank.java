package me.thomasrba.minecoinsplayersapi.playermanager;

import java.util.HashMap;

public enum PlayerRank {

    Mineur(1, "§8[Mineur]"),
    Admin(2,"§c[Administrateur]");

    private final int gradeId;
    private final String prefix;

    public static final HashMap <Integer, PlayerRank> rankMap = new HashMap <>();

    PlayerRank(int gradeId, String prefix) {
        this.gradeId = gradeId;
        this.prefix = prefix;
    }

    static {
        for (PlayerRank rank : PlayerRank.values()){
            rankMap.put(rank.gradeId, rank);
        }
    }

    public String getPrefix() {
        return prefix;
    }

    public String getPrefixById(int gradeId) {
        return rankMap.get(gradeId).getPrefix();
    }
}
