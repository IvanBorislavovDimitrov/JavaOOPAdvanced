package app.commands;

import app.contracts.Battlefield;

public class StatParticipants implements Command {
    @Override
    public void execute(Battlefield battlefield, String... params) {
        battlefield.reportParticipants();
    }
}
