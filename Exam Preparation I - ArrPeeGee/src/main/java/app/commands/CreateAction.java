package app.commands;

import app.contracts.Battlefield;

import java.util.Arrays;

public class CreateAction implements Command {
    @Override
    public void execute(Battlefield battlefield, String... params) {
        battlefield.createAction(params[1],
                Arrays.copyOf(Arrays.stream(params).skip(2).toArray(),
                        Arrays.stream(params).skip(2).toArray().length, String[].class));
    }
}
