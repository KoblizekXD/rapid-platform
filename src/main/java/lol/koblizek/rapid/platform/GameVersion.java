package lol.koblizek.rapid.platform;

public enum GameVersion {
    V1_0,
    V1_1,
    V1_2,
    V1_3,
    V1_4,
    V1_5,
    V1_6,
    V1_7,
    V1_7_10,
    V1_8,
    V1_8_8,
    V1_8_9,
    V1_9,
    V1_10,
    V1_11,
    V1_12,
    V1_12_1,
    V1_12_2,
    V1_13,
    V1_14,
    V1_15,
    V1_16,
    V1_17,
    V1_18,
    V1_19,
    V1_20,
    V1_20_1,
    V1_20_2,
    V1_20_3,
    V1_20_4;

    private final String version;

    GameVersion() {
        this.version = name().substring(1).replace('_', '.');
    }

    GameVersion(String version) {
        this.version = version;
    }

    public String getVersion() {
        return version;
    }

    @Override
    public String toString() {
        return version;
    }

    public static GameVersion[] ranging(GameVersion begin, GameVersion end) {
        int beginIndex = begin.ordinal();
        int endIndex = end.ordinal();
        if (beginIndex > endIndex) {
            throw new IllegalArgumentException("parameter begin must be less than or equal to parameter end");
        }
        GameVersion[] versions = new GameVersion[endIndex - beginIndex + 1];
        System.arraycopy(values(), beginIndex, versions, 0, versions.length);
        return versions;
    }

    public static GameVersion latest() {
        return values()[values().length - 1];
    }

    public static GameVersion[] from(GameVersion begin) {
        return ranging(begin, latest());
    }
}
