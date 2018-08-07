package hell.entities.models.items;

import hell.interfaces.Recipe;

import java.util.ArrayList;
import java.util.List;

public class RecipeItem extends BaseItem implements Recipe {

    private List<String> commonItems;

    public RecipeItem(String name, int strengthBonus, int agilityBonus, int intelligenceBonus, int hitPointsBonus, int damageBonus) {
        super(name, strengthBonus, agilityBonus, intelligenceBonus, hitPointsBonus, damageBonus);
        this.commonItems = new ArrayList<>();
    }

    @Override
    public List<String> getRequiredItems() {
        return this.commonItems;
    }
}
