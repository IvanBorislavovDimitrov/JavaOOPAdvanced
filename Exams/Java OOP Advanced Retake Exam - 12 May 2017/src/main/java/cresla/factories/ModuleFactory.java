package cresla.factories;

import cresla.entities.module.impl.CooldownSystem;
import cresla.entities.module.impl.CryogenRod;
import cresla.entities.module.impl.HeatProcessor;
import cresla.interfaces.Module;

public final class ModuleFactory {

    private ModuleFactory() {

    }

    public static Module createModule(String type, int arg) {
        switch (type) {
            case "CryogenRod":
                return new CryogenRod(arg);
            case "CooldownSystem":
                return new CooldownSystem(arg);
            case "HeatProcessor":
                return new HeatProcessor(arg);
        }

        throw new IllegalArgumentException("Dedovee");
    }
}
