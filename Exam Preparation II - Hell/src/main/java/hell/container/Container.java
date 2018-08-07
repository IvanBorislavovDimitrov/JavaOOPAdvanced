package hell.container;

import hell.interfaces.Hero;

import java.util.*;

public class Container {

    private Map<String, Hero> heroes;

    public Container() {
        this.heroes = new LinkedHashMap<>();
    }

    public void addHero(Hero hero) {
        this.heroes.put(hero.getName(), hero);
    }

    public Hero getHero(String name) {
        return this.heroes.get(name);
    }

    public Collection<Hero> getHeroes() {
        return Collections.unmodifiableCollection(this.heroes.values());
    }
}
