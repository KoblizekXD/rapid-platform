package lol.koblizek.rapid.platform;

public final class Mappings {

    private Mappings() {}

    // TODO - Ranging versions are only temporary, they should be replaced with proper version ranges,
    // actually corrected
    public enum Provider implements IMappingProvider {
        MOJANG(GameVersion.from(GameVersion.V1_14), Format.PROGUARD),
        FORGE(GameVersion.from(GameVersion.V1_1), Format.SRG, Format.TSRG, Format.TSRG2),
        NEOFORGE(GameVersion.from(GameVersion.V1_12_2), Format.TSRG2),
        FABRIC(GameVersion.from(GameVersion.V1_14), Format.TINYV2, Format.TINY, Format.ENIGMA);

        private final GameVersion[] versions;
        private final Format[] formats;

        Provider(GameVersion[] versions, Format... formats) {
            this.versions = versions;
            this.formats = formats;
        }

        @Override
        public Format[] getFormats() {
            return formats;
        }

        @Override
        public Format getPreferredFormat() {
            return formats[0];
        }

        @Override
        public GameVersion[] getSupportedVersions() {
            return versions;
        }

        // TODO: Implement for each of the supported providers
        @Override
        public Format[] getFormats(GameVersion version) {
            return new Format[0];
        }
    }

    public enum Format {
        ENIGMA,
        PROGUARD,
        SRG,
        TINY,
        TINYV2,
        TSRG,
        TSRG2
    }
}
