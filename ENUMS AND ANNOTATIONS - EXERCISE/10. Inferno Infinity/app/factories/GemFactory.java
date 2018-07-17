package app.factories;

import app.enums.Gem;

public final class GemFactory {

    private GemFactory() {
    }

    public static Gem createGem(String gemType) {
        switch (gemType) {
            case "RUBY":
                return Gem.RUBY;
            case "EMERALD":
                return Gem.EMERALD;
            case "AMETHYST":
                return Gem.AMETHYST;
        }

        return null;
    }
}
