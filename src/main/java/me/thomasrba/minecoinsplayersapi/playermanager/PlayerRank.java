package me.thomasrba.minecoinsplayersapi.playermanager;

import java.util.HashMap;
import java.util.List;

public enum PlayerRank {

    Mineur(1, "§8[Mineur]", List.of("test.test")),
    Admin(2,"§c[Administrateur]", List.of());

    private final int gradeId;
    private final String prefix;

    private final List<String> gradePermissions;

    private static final HashMap <Integer, PlayerRank> rankMap = new HashMap <>();

    PlayerRank(int gradeId, String prefix, List<String> gradePermissions) {
        this.gradeId = gradeId;
        this.prefix = prefix;
        this.gradePermissions = gradePermissions;
    }

    static {
        for (PlayerRank rank : PlayerRank.values()){
            rankMap.put(rank.gradeId, rank);
        }
    }

    public static PlayerRank getRankMap(int gradeId) {
        return rankMap.get(gradeId);
    }

    public String getPrefix() {
        return prefix;
    }

    public String getPrefixById(int gradeId) {
        return rankMap.get(gradeId).getPrefix();
    }

    public List<String> getGradePermissions() {
        return this.gradePermissions;
    }
}
