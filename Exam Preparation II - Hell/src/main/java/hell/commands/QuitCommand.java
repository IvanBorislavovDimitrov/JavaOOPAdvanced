package hell.commands;

import hell.container.Container;
import hell.interfaces.Item;

import java.util.stream.Collectors;

public class QuitCommand implements Command {

    @Override
    public String execute(Container container, String... params) {
        StringBuilder sb = new StringBuilder();
        int[] cnt = {1};
        container.getHeroes().stream()
                .sorted((h1, h2) -> {
                    long h1Sum = h1.getStrength() + h1.getAgility() + h1.getIntelligence();
                    long h2Sum = h2.getStrength() + h2.getAgility() + h2.getIntelligence();

                    if (h1Sum == h2Sum) {
                        h1Sum = h1.getHitPoints() + h1.getDamage();
                        h2Sum = h2.getHitPoints() + h2.getDamage();

                        return Long.compare(h2Sum, h1Sum);
                    }

                    return Long.compare(h2Sum, h1Sum);
                }).forEach(hero -> {
            sb.append(String.format("%d. %s: %s", cnt[0]++, hero.getClass().getSimpleName(), hero.getName()))
                    .append(System.lineSeparator());
            sb.append(String.format("###HitPoints: %d", hero.getHitPoints())).append(System.lineSeparator());
            sb.append(String.format("###Damage: %d", hero.getDamage())).append(System.lineSeparator());
            sb.append(String.format("###Strength: %d", hero.getStrength())).append(System.lineSeparator());
            sb.append(String.format("###Agility: %d", hero.getAgility())).append(System.lineSeparator());
            sb.append(String.format("###Intelligence: %d", hero.getIntelligence())).append(System.lineSeparator());
            if (hero.getItems().size() == 0) {
                sb.append("###Items: None").append(System.lineSeparator());
            } else {
                sb.append(String.format("###Items: %s", hero.getItems().stream()
                        .map(Item::getName).collect(Collectors.joining(", ")))).append(System.lineSeparator());
            }
        });

        return sb.toString().trim();
    }
}
