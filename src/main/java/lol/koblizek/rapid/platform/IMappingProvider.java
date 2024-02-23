package lol.koblizek.rapid.platform;

public interface IMappingProvider {
    Mappings.Format[] getFormats();
    Mappings.Format getPreferredFormat();
    GameVersion[] getSupportedVersions();
    default boolean isSupported(GameVersion version) {
        for (GameVersion supportedVersion : getSupportedVersions())
            if (supportedVersion == version)
                return true;
        return false;
    }

    Mappings.Format[] getFormats(GameVersion version);
}
