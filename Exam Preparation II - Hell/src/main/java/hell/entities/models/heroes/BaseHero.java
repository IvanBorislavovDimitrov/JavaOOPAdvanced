package hell.entities.models.heroes;

import hell.entities.miscellaneous.HeroInventory;
import hell.entities.miscellaneous.ItemCollection;
import hell.interfaces.Hero;
import hell.interfaces.Inventory;
import hell.interfaces.Item;
import hell.interfaces.Recipe;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;

public abstract class BaseHero implements Hero {

    private String name;
    private long strength;
    private long agility;
    private long intelligence;
    private long hitPoints;
    private long damage;
    private Inventory inventory;

    protected BaseHero(String name, long strength, long agility, long intelligence, long hitPoints, long damage) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
        this.hitPoints = hitPoints;
        this.damage = damage;
        this.inventory = new HeroInventory();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public long getStrength() {
        return this.strength + this.inventory.getTotalStrengthBonus();
    }

    @Override
    public long getAgility() {
        return this.agility + this.inventory.getTotalAgilityBonus();
    }

    @Override
    public long getIntelligence() {
        return this.intelligence + this.inventory.getTotalIntelligenceBonus();
    }

    @Override
    public long getHitPoints() {
        return this.hitPoints + this.inventory.getTotalHitPointsBonus();
    }

    @Override
    public long getDamage() {
        return this.damage + this.inventory.getTotalDamageBonus();
    }

    @Override
    public Collection<Item> getItems() {
        try {
            Field commonItemsField = null;
            for (Field field : this.inventory.getClass().getDeclaredFields()) {
                if (field.isAnnotationPresent(ItemCollection.class)) {
                    commonItemsField = field;
                }
            }
            if (commonItemsField == null) {
                throw new IllegalArgumentException("Annotation is missing!");
            }
            commonItemsField.setAccessible(true);
            Map<String, Item> commonItems = (Map<String, Item>) commonItemsField.get(this.inventory);
            
            return Collections.unmodifiableCollection(commonItems.values());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void addItem(Item item) {
        this.inventory.addCommonItem(item);
    }

    @Override
    public void addRecipe(Recipe recipe) {
        this.inventory.addRecipeItem(recipe);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Hero: %s, Class: %s", this.getName(), this.getClass().getSimpleName())).append(System.lineSeparator());
        sb.append(String.format("HitPoints: %s, Damage: %d", this.getHitPoints(), this.getDamage())).append(System.lineSeparator());
        sb.append(String.format("Strength: %d", this.getStrength())).append(System.lineSeparator());
        sb.append(String.format("Agility: %d", this.getAgility())).append(System.lineSeparator());
        sb.append(String.format("Intelligence: %d", this.getIntelligence())).append(System.lineSeparator());
        if (this.getItems().size() == 0) {
            sb.append("Items: None");
        } else {
            sb.append("Items:").append(System.lineSeparator());
            this.getItems().forEach(i -> sb.append(i.toString()).append(System.lineSeparator()));
        }

        return sb.toString().trim();
    }
}
