package app.models.actions;

import app.contracts.Action;
import app.contracts.Targetable;
import app.models.Config;
import app.models.participants.Boss;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BossFight implements Action {

    @Override
    public String executeAction(List<Targetable> participants) {
        if (participants.size() < 1) {
            throw new IllegalArgumentException("There should be at least 1 participant for boss fight!");
        }

        Targetable boss = participants.get(0);
        if (!(boss instanceof Boss)) {
            throw new IllegalArgumentException("Invalid boss.");
        }
        int cnt = 1;
        int index = 1;

        while (participants.stream().skip(1).anyMatch(Targetable::isAlive)) {
            Targetable participant = participants.get(cnt++);
            if (participant.isAlive()) {
                participant.attack(boss);
                if (boss.isAlive()) {
                    boss.attack(participant);
                } else {
                    index = cnt;
                    break;
                }
            }
            if (cnt >= participants.size()) {
                cnt = 1;
            }
        }

        index--;
        if (index == 0) {
            index = participants.size() - 1;
        }

        List<Targetable> aliveParticipants = new ArrayList<>();

        for (int i = 1; i < participants.size(); i++) {
            if (participants.get(i).isAlive()) {
                if (i != index) {
                    participants.get(i).levelUp();
                }
                participants.get(i).receiveReward(Config.BOSS_INDIVIDUAL_REWARD);
                aliveParticipants.add(participants.get(i));
            }
        }

        if (aliveParticipants.isEmpty()) {
            return "Boss has slain them all!";
        }
        aliveParticipants.sort(Comparator.comparing(Targetable::getName));
        StringBuilder sb = new StringBuilder();
        sb.append("Boss has been slain by: ").append(System.lineSeparator());
        aliveParticipants.forEach(p -> sb.append(p).append(System.lineSeparator()));

        return sb.toString().trim();
    }
}
