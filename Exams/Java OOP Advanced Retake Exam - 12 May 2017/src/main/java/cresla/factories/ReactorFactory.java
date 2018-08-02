package cresla.factories;

import cresla.entities.reactor.CryoReactor;
import cresla.entities.reactor.HeatReactor;
import cresla.interfaces.Reactor;

public final class ReactorFactory {

    private ReactorFactory() {

    }

    public static Reactor createReactor(String type, int arg1, int arg2) {
        switch (type) {
            case "Cryo":
                return new CryoReactor(arg2, arg1);
            case "Heat":
                return new HeatReactor(arg2, arg1);
        }

        throw new IllegalArgumentException("Dedovee");
    }
}
