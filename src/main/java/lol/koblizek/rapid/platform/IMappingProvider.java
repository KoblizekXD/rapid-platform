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

    default boolean isSupported(Mappings.Format format) {
        for (Mappings.Format supportedFormat : getFormats())
            if (supportedFormat == format)
                return true;
        return false;
    }

    default boolean isSupported(GameVersion version, Mappings.Format format) {
        if (isSupported(version) && isSupported(format)) {
            for (Mappings.Format f : getFormats(version)) {
                if (f == format) return true;
            }
        }
        return false;
    }

    default Mappings get(GameVersion version) {
        return get(version, getPreferredFormat());
    }

    default Mappings get(GameVersion version, Mappings.Format format) {
        return new Mappings(this, version, format);
    }

    Mappings.Format[] getFormats(GameVersion version);
}
