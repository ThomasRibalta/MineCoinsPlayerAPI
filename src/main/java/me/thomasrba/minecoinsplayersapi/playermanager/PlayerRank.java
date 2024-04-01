package me.thomasrba.minecoinsplayersapi.playermanager;

import java.util.HashMap;
import java.util.List;

public enum PlayerRank {

    Mineur(1, "§7[Mineur]", List.of("test.test")),
    VIP(2, "§b[VIP]", List.of("admin.setrank")),
    VIPPLUS(3, "§b[VIP§e+§b]", List.of("test.test")),
    Youtubeurs(4, "§c[Youtubeur]", List.of("test.test")),
    Moderateur(6, "§2[Moderateur]", List.of("test.test")),
    Builder(5, "§6[Builder]", List.of("test.test")),
    Admin(7,"§4[Administrateur]", List.of("test.test"));

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

    public List<String> getGradePermissions() {
        return this.gradePermissions;
    }
}
