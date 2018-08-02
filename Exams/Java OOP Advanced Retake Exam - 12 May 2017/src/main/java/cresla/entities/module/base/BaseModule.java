package cresla.entities.module.base;

import cresla.interfaces.Module;
import cresla.util.IdIncrementer;

public abstract class BaseModule implements Module {

    private int id;

    BaseModule() {
        this.id = IdIncrementer.getId();
    }

    @Override
    public int getId() {
        return this.id;
    }
}
