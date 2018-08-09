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

        if (!boss.isAlive()) {
            return boss.getName() + " is dead! Cannot attack.";
        }

        if (participants.size() < 2) {
            throw new IllegalArgumentException("There should be at least 1 participant for boss fight!");
        }

        List<Targetable> attackers = participants.stream()
                .skip(1)
                .collect(Collectors.toList());

        int index = 0;
        Targetable last = attackers.get(0);
        while (attackers.stream().anyMatch(Targetable::isAlive) && boss.isAlive()) {
            Targetable attacker = attackers.get(index++);
            if (attacker.isAlive() && attacker.isAlive()) {
                attacker.attack(boss);
                last = attacker;
            }
            if (boss.isAlive() && attacker.isAlive()) {
                boss.attack(attacker);
            }

            index %= attackers.size();
        }

        if (boss.isAlive()) {
            boss.levelUp();
            return "Boss has slain them all!";
        }

        final Targetable ls = last;

        StringBuilder sb = new StringBuilder();

        attackers.stream().filter(Targetable::isAlive).forEach(p -> p.receiveReward(Config.BOSS_INDIVIDUAL_REWARD));
        sb.append("Boss has been slain by:").append(System.lineSeparator());
        attackers.stream().filter(p -> p != ls).filter(Targetable::isAlive).forEach(Targetable::levelUp);
        attackers.sort(Comparator.comparing(Targetable::getName));
        attackers.stream().filter(Targetable::isAlive).forEach(p -> sb.append(p.toString()));

        return sb.toString();
    }
}
