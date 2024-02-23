package lol.koblizek.rapid.platform.util;

import lol.koblizek.rapid.platform.GameVersion;
import lol.koblizek.rapid.platform.Mappings;

public final class Preconditions {
    public static boolean checkSupport(Mappings.Provider provider, GameVersion version, Mappings.Format format) {
        return provider.isSupported(version, format);
    }
}
