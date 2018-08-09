package app.commands;

import app.abilities.Ability;
import app.contracts.Battlefield;

import java.lang.reflect.InvocationTargetException;

public class CreateSpecial implements Command {
    @Override
    public void execute(Battlefield battlefield, String... params) {
        battlefield.createSpecial(params[1], params[2]);
    }
}
