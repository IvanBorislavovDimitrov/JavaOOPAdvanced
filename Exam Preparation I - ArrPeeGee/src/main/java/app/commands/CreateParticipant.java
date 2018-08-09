package app.commands;

import app.contracts.Battlefield;

public class CreateParticipant implements Command {
    @Override
    public void execute(Battlefield battlefield, String... params) {
        battlefield.createParticipant(params[1], params[2]);
    }
}
