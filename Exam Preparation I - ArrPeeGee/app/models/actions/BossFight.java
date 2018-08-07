package app.models.actions;

import app.contracts.Action;
import app.contracts.Targetable;
import app.models.Config;
import app.models.participants.Boss;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class BossFight implements Action {

    @Override
    public String executeAction(List<Targetable> participants) {
        Targetable boss = participants.get(0);

        if (!(boss instanceof Boss)) {
            throw new IllegalArgumentException("Invalid boss.");
        }

        if (participants.size() <= 2) {
            throw new IllegalArgumentException("There should be at least 1 participant for boss fight!");
        }

        List<Targetable> attackers = participants.stream()
                .skip(1).collect(Collectors.toList());
        int index = 0;
        Targetable last = attackers.get(0);
        while (attackers.stream().anyMatch(Targetable::isAlive) && boss.isAlive()) {
            Targetable attacker = attackers.get(index++);
            if (attacker.isAlive()) {
                attacker.attack(boss);
                last = attacker;
            }
            if (boss.isAlive()) {
                boss.attack(attacker);
            }

            index %= attackers.size();
        }

        StringBuilder sb = new StringBuilder();

        Targetable ls = last;
        if (boss.isAlive()) {
            return "Boss has slain them all!";
        } else {
            attackers.stream().filter(Targetable::isAlive).forEach(p -> p.receiveReward(Config.BOSS_INDIVIDUAL_REWARD));
            sb.append("Boss has been slain by:").append(System.lineSeparator());
            attackers.stream().filter(p -> p != ls).filter(Targetable::isAlive).forEach(Targetable::levelUp);
            attackers.sort(Comparator.comparing(Targetable::getName));
            attackers.stream().filter(Targetable::isAlive).forEach(p -> sb.append(p.toString()).append(System.lineSeparator()));
        }

        return sb.toString().trim();
    }
}
