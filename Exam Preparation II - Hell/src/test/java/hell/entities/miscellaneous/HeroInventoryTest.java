package hell.entities.miscellaneous;

import hell.interfaces.Item;
import hell.interfaces.Recipe;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HeroInventoryTest {

    private HeroInventory heroInventory;

    @Before
    public void setUp() {
        this.heroInventory = new HeroInventory();
    }

    @Test
    public void getTotalStrengthBonus() {
        Item item = Mockito.mock(Item.class);
        Item item1 = Mockito.mock(Item.class);
        Item item2 = Mockito.mock(Item.class);

        Mockito.when(item.getStrengthBonus()).thenReturn(10);
        Mockito.when(item.getName()).thenReturn("First");

        Mockito.when(item1.getStrengthBonus()).thenReturn(10);
        Mockito.when(item1.getName()).thenReturn("Second");

        Mockito.when(item2.getStrengthBonus()).thenReturn(10);
        Mockito.when(item2.getName()).thenReturn("Third");

        this.heroInventory.addCommonItem(item);
        this.heroInventory.addCommonItem(item1);
        this.heroInventory.addCommonItem(item2);

        Assert.assertEquals(30L, this.heroInventory.getTotalStrengthBonus());
    }

    @Test
    public void getTotalAgilityBonus() {
        Item item = Mockito.mock(Item.class);
        Item item1 = Mockito.mock(Item.class);
        Item item2 = Mockito.mock(Item.class);

        Mockito.when(item.getAgilityBonus()).thenReturn(10);
        Mockito.when(item.getName()).thenReturn("First");

        Mockito.when(item1.getAgilityBonus()).thenReturn(10);
        Mockito.when(item1.getName()).thenReturn("Second");

        Mockito.when(item2.getAgilityBonus()).thenReturn(10);
        Mockito.when(item2.getName()).thenReturn("Third");

        this.heroInventory.addCommonItem(item);
        this.heroInventory.addCommonItem(item1);
        this.heroInventory.addCommonItem(item2);

        Assert.assertEquals(30L, this.heroInventory.getTotalAgilityBonus());
    }

    @Test
    public void getTotalIntelligenceBonus() {
        Item item = Mockito.mock(Item.class);
        Item item1 = Mockito.mock(Item.class);
        Item item2 = Mockito.mock(Item.class);

        Mockito.when(item.getIntelligenceBonus()).thenReturn(10);
        Mockito.when(item.getName()).thenReturn("First");

        Mockito.when(item1.getIntelligenceBonus()).thenReturn(10);
        Mockito.when(item1.getName()).thenReturn("Second");

        Mockito.when(item2.getIntelligenceBonus()).thenReturn(10);
        Mockito.when(item2.getName()).thenReturn("Third");

        this.heroInventory.addCommonItem(item);
        this.heroInventory.addCommonItem(item1);
        this.heroInventory.addCommonItem(item2);

        Assert.assertEquals(30L, this.heroInventory.getTotalIntelligenceBonus());
    }

    @Test
    public void getTotalHitPointsBonus() {
        Item item = Mockito.mock(Item.class);
        Item item1 = Mockito.mock(Item.class);
        Item item2 = Mockito.mock(Item.class);

        Mockito.when(item.getHitPointsBonus()).thenReturn(10);
        Mockito.when(item.getName()).thenReturn("First");

        Mockito.when(item1.getHitPointsBonus()).thenReturn(10);
        Mockito.when(item1.getName()).thenReturn("Second");

        Mockito.when(item2.getHitPointsBonus()).thenReturn(10);
        Mockito.when(item2.getName()).thenReturn("Third");

        this.heroInventory.addCommonItem(item);
        this.heroInventory.addCommonItem(item1);
        this.heroInventory.addCommonItem(item2);

        Assert.assertEquals(30L, this.heroInventory.getTotalHitPointsBonus());
    }

    @Test
    public void getTotalDamageBonus() {
        Item item = Mockito.mock(Item.class);
        Item item1 = Mockito.mock(Item.class);
        Item item2 = Mockito.mock(Item.class);

        Mockito.when(item.getDamageBonus()).thenReturn(Integer.MAX_VALUE);
        Mockito.when(item.getName()).thenReturn("First");

        Mockito.when(item1.getDamageBonus()).thenReturn(Integer.MAX_VALUE);
        Mockito.when(item1.getName()).thenReturn("Second");

        Mockito.when(item2.getDamageBonus()).thenReturn(Integer.MAX_VALUE);
        Mockito.when(item2.getName()).thenReturn("Third");

        this.heroInventory.addCommonItem(item);
        this.heroInventory.addCommonItem(item1);
        this.heroInventory.addCommonItem(item2);

        Assert.assertEquals((long) 3 * Integer.MAX_VALUE, this.heroInventory.getTotalDamageBonus());
    }

    @Test
    public void addCommonItem() throws NoSuchFieldException, IllegalAccessException {
        Item item = Mockito.mock(Item.class);
        Mockito.when(item.getName()).thenReturn("yanko");
        Mockito.when(item.getStrengthBonus()).thenReturn(1);
        Mockito.when(item.getDamageBonus()).thenReturn(1);
        Mockito.when(item.getHitPointsBonus()).thenReturn(1);
        Mockito.when(item.getIntelligenceBonus()).thenReturn(1);
        Mockito.when(item.getAgilityBonus()).thenReturn(1);

        this.heroInventory.addCommonItem(item);

        Field commonItemsField = this.heroInventory.getClass().getDeclaredField("commonItems");
        commonItemsField.setAccessible(true);
        Map<String, Item> commonItems = (Map<String, Item>) commonItemsField.get(this.heroInventory);

        Item searched = commonItems.get("yanko");

        Assert.assertEquals(1, commonItems.size());
        Assert.assertEquals(1, searched.getAgilityBonus());
        Assert.assertEquals(1, searched.getStrengthBonus());
        Assert.assertEquals(1, searched.getDamageBonus());
        Assert.assertEquals(1, searched.getIntelligenceBonus());
        Assert.assertEquals(1, searched.getHitPointsBonus());
    }

    @Test
    public void addRecipeItem() throws NoSuchFieldException, IllegalAccessException {
        Recipe recipe = Mockito.mock(Recipe.class);
        Mockito.when(recipe.getName()).thenReturn("dedovee");
        Mockito.when(recipe.getStrengthBonus()).thenReturn(25);
        Mockito.when(recipe.getAgilityBonus()).thenReturn(10);
        Mockito.when(recipe.getIntelligenceBonus()).thenReturn(10);
        Mockito.when(recipe.getHitPointsBonus()).thenReturn(100);
        Mockito.when(recipe.getDamageBonus()).thenReturn(50);
        List<String> requiredItems = new ArrayList<>() {{
            add("Knife");
            add("Stick");
        }};
        Mockito.when(recipe.getRequiredItems()).thenReturn(requiredItems);
        this.heroInventory.addRecipeItem(recipe);

        Recipe recipe1 = Mockito.mock(Recipe.class);
        Mockito.when(recipe1.getName()).thenReturn("ustata");
        Mockito.when(recipe1.getStrengthBonus()).thenReturn(50);
        Mockito.when(recipe1.getAgilityBonus()).thenReturn(10);
        Mockito.when(recipe1.getIntelligenceBonus()).thenReturn(10);
        Mockito.when(recipe1.getHitPointsBonus()).thenReturn(100);
        Mockito.when(recipe1.getDamageBonus()).thenReturn(50);
        List<String> requiredItems1 = new ArrayList<>() {{
            add("Knife");
            add("Stick");
        }};
        Mockito.when(recipe.getRequiredItems()).thenReturn(requiredItems1);
        this.heroInventory.addRecipeItem(recipe1);

        Field recipeItemsField = this.heroInventory.getClass().getDeclaredField("recipeItems");
        recipeItemsField.setAccessible(true);
        Map<String, Recipe> recipeItems = (Map<String, Recipe>) recipeItemsField.get(this.heroInventory);
        Recipe r = recipeItems.get("ustata");

        Assert.assertEquals(50, r.getStrengthBonus());
        Assert.assertEquals(10, r.getAgilityBonus());
        Assert.assertEquals(10, r.getIntelligenceBonus());
        Assert.assertEquals(100, r.getHitPointsBonus());
        Assert.assertEquals(50, r.getDamageBonus());
        Assert.assertEquals(2, recipeItems.size());
    }

    @Test
    public void checkRecipes() throws NoSuchMethodException, NoSuchFieldException, InvocationTargetException, IllegalAccessException {
        Item knife = Mockito.mock(Item.class);
        Mockito.when(knife.getName()).thenReturn("Knife");
        Mockito.when(knife.getStrengthBonus()).thenReturn(1);
        Mockito.when(knife.getAgilityBonus()).thenReturn(1);
        Mockito.when(knife.getIntelligenceBonus()).thenReturn(1);
        Mockito.when(knife.getHitPointsBonus()).thenReturn(1);
        Mockito.when(knife.getDamageBonus()).thenReturn(1);
        this.heroInventory.addCommonItem(knife);

        Item stick = Mockito.mock(Item.class);
        Mockito.when(stick.getName()).thenReturn("Stick");
        Mockito.when(stick.getStrengthBonus()).thenReturn(1);
        Mockito.when(stick.getAgilityBonus()).thenReturn(1);
        Mockito.when(stick.getIntelligenceBonus()).thenReturn(1);
        Mockito.when(stick.getHitPointsBonus()).thenReturn(1);
        Mockito.when(stick.getDamageBonus()).thenReturn(1);
        this.heroInventory.addCommonItem(stick);

        Recipe recipe = Mockito.mock(Recipe.class);
        Mockito.when(recipe.getName()).thenReturn("dedovee");
        Mockito.when(recipe.getStrengthBonus()).thenReturn(25);
        Mockito.when(recipe.getAgilityBonus()).thenReturn(10);
        Mockito.when(recipe.getIntelligenceBonus()).thenReturn(10);
        Mockito.when(recipe.getHitPointsBonus()).thenReturn(100);
        Mockito.when(recipe.getDamageBonus()).thenReturn(50);
        List<String> requiredItems = new ArrayList<>() {{
            add("Knife");
            add("Stick");
        }};
        Mockito.when(recipe.getRequiredItems()).thenReturn(requiredItems);
        this.heroInventory.addRecipeItem(recipe);


        Method checkRecipes = this.heroInventory.getClass().getDeclaredMethod("checkRecipes");
        checkRecipes.setAccessible(true);

        checkRecipes.invoke(this.heroInventory);

        Field commonItemsField = this.heroInventory.getClass().getDeclaredField("commonItems");
        commonItemsField.setAccessible(true);
        Map<String, Item> commonItems = (Map<String, Item>) commonItemsField.get(this.heroInventory);
        Item item = commonItems.get("dedovee");

        Assert.assertEquals(25, item.getStrengthBonus());
        Assert.assertEquals(10, item.getAgilityBonus());
        Assert.assertEquals(10, item.getIntelligenceBonus());
        Assert.assertEquals(100, item.getHitPointsBonus());
        Assert.assertEquals(50, item.getDamageBonus());
        Assert.assertEquals(1, commonItems.size());
    }

    @Test
    public void combineRecipe() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, NoSuchFieldException {
        Item knife = Mockito.mock(Item.class);
        Mockito.when(knife.getName()).thenReturn("Knife");
        Mockito.when(knife.getStrengthBonus()).thenReturn(1);
        Mockito.when(knife.getAgilityBonus()).thenReturn(1);
        Mockito.when(knife.getIntelligenceBonus()).thenReturn(1);
        Mockito.when(knife.getHitPointsBonus()).thenReturn(1);
        Mockito.when(knife.getDamageBonus()).thenReturn(1);
        this.heroInventory.addCommonItem(knife);

        Item stick = Mockito.mock(Item.class);
        Mockito.when(stick.getName()).thenReturn("Stick");
        Mockito.when(stick.getStrengthBonus()).thenReturn(1);
        Mockito.when(stick.getAgilityBonus()).thenReturn(1);
        Mockito.when(stick.getIntelligenceBonus()).thenReturn(1);
        Mockito.when(stick.getHitPointsBonus()).thenReturn(1);
        Mockito.when(stick.getDamageBonus()).thenReturn(1);
        this.heroInventory.addCommonItem(stick);

        Recipe recipe = Mockito.mock(Recipe.class);
        Mockito.when(recipe.getName()).thenReturn("dedovee");
        Mockito.when(recipe.getStrengthBonus()).thenReturn(25);
        Mockito.when(recipe.getAgilityBonus()).thenReturn(10);
        Mockito.when(recipe.getIntelligenceBonus()).thenReturn(10);
        Mockito.when(recipe.getHitPointsBonus()).thenReturn(100);
        Mockito.when(recipe.getDamageBonus()).thenReturn(50);
        List<String> requiredItems = new ArrayList<>() {{
            add("Knife");
            add("Stick");
        }};
        Mockito.when(recipe.getRequiredItems()).thenReturn(requiredItems);
        this.heroInventory.addRecipeItem(recipe);

        Method combineRecipe = this.heroInventory.getClass().getDeclaredMethod("combineRecipe", Recipe.class);
        combineRecipe.setAccessible(true);

        combineRecipe.invoke(this.heroInventory, recipe);

        Field commonItemsField = this.heroInventory.getClass().getDeclaredField("commonItems");
        commonItemsField.setAccessible(true);
        Map<String, Item> commonItems = (Map<String, Item>) commonItemsField.get(this.heroInventory);
        Item item = commonItems.get("dedovee");

        Assert.assertEquals(25, item.getStrengthBonus());
        Assert.assertEquals(10, item.getAgilityBonus());
        Assert.assertEquals(10, item.getIntelligenceBonus());
        Assert.assertEquals(100, item.getHitPointsBonus());
        Assert.assertEquals(50, item.getDamageBonus());
        Assert.assertEquals(1, commonItems.size());
    }

    @Test
    public void add() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, NoSuchFieldException {
        Item knife = Mockito.mock(Item.class);
        Mockito.when(knife.getName()).thenReturn("Knife");
        Mockito.when(knife.getStrengthBonus()).thenReturn(1);
        Mockito.when(knife.getAgilityBonus()).thenReturn(1);
        Mockito.when(knife.getIntelligenceBonus()).thenReturn(1);
        Mockito.when(knife.getHitPointsBonus()).thenReturn(1);
        Mockito.when(knife.getDamageBonus()).thenReturn(1);
        this.heroInventory.addCommonItem(knife);

        Item stick = Mockito.mock(Item.class);
        Mockito.when(stick.getName()).thenReturn("Stick");
        Mockito.when(stick.getStrengthBonus()).thenReturn(1);
        Mockito.when(stick.getAgilityBonus()).thenReturn(1);
        Mockito.when(stick.getIntelligenceBonus()).thenReturn(1);
        Mockito.when(stick.getHitPointsBonus()).thenReturn(1);
        Mockito.when(stick.getDamageBonus()).thenReturn(1);
        this.heroInventory.addCommonItem(stick);

        Recipe recipe = Mockito.mock(Recipe.class);
        Mockito.when(recipe.getName()).thenReturn("dedovee");
        Mockito.when(recipe.getStrengthBonus()).thenReturn(25);
        Mockito.when(recipe.getAgilityBonus()).thenReturn(10);
        Mockito.when(recipe.getIntelligenceBonus()).thenReturn(10);
        Mockito.when(recipe.getHitPointsBonus()).thenReturn(100);
        Mockito.when(recipe.getDamageBonus()).thenReturn(50);
        List<String> requiredItems = new ArrayList<>() {{
            add("Knife");
            add("Stick");
        }};
        Mockito.when(recipe.getRequiredItems()).thenReturn(requiredItems);
        this.heroInventory.addRecipeItem(recipe);

        Field commonItemsField = this.heroInventory.getClass().getDeclaredField("commonItems");
        commonItemsField.setAccessible(true);
        Map<String, Item> commonItems = (Map<String, Item>) commonItemsField.get(this.heroInventory);

        Field recipeItemsField = this.heroInventory.getClass().getDeclaredField("recipeItems");
        recipeItemsField.setAccessible(true);
        Map<String, Recipe> recipeItems = (Map<String, Recipe>) recipeItemsField.get(this.heroInventory);

        Assert.assertEquals(1, commonItems.size());
        Assert.assertEquals(1, recipeItems.size());
    }

    @Test
    public void add1() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, NoSuchFieldException {
        Item knife = Mockito.mock(Item.class);
        Mockito.when(knife.getName()).thenReturn("Knife");
        Mockito.when(knife.getStrengthBonus()).thenReturn(1);
        Mockito.when(knife.getAgilityBonus()).thenReturn(1);
        Mockito.when(knife.getIntelligenceBonus()).thenReturn(1);
        Mockito.when(knife.getHitPointsBonus()).thenReturn(1);
        Mockito.when(knife.getDamageBonus()).thenReturn(1);
        this.heroInventory.addCommonItem(knife);

        Recipe recipe = Mockito.mock(Recipe.class);
        Mockito.when(recipe.getName()).thenReturn("dedovee");
        Mockito.when(recipe.getStrengthBonus()).thenReturn(25);
        Mockito.when(recipe.getAgilityBonus()).thenReturn(10);
        Mockito.when(recipe.getIntelligenceBonus()).thenReturn(10);
        Mockito.when(recipe.getHitPointsBonus()).thenReturn(100);
        Mockito.when(recipe.getDamageBonus()).thenReturn(50);
        List<String> requiredItems = new ArrayList<>() {{
            add("Knife");
            add("Stick");
        }};
        Mockito.when(recipe.getRequiredItems()).thenReturn(requiredItems);
        this.heroInventory.addRecipeItem(recipe);

        Item stick = Mockito.mock(Item.class);
        Mockito.when(stick.getName()).thenReturn("Stick");
        Mockito.when(stick.getStrengthBonus()).thenReturn(1);
        Mockito.when(stick.getAgilityBonus()).thenReturn(1);
        Mockito.when(stick.getIntelligenceBonus()).thenReturn(1);
        Mockito.when(stick.getHitPointsBonus()).thenReturn(1);
        Mockito.when(stick.getDamageBonus()).thenReturn(1);
        this.heroInventory.addCommonItem(stick);

        Field commonItemsField = this.heroInventory.getClass().getDeclaredField("commonItems");
        commonItemsField.setAccessible(true);
        Map<String, Item> commonItems = (Map<String, Item>) commonItemsField.get(this.heroInventory);

        Field recipeItemsField = this.heroInventory.getClass().getDeclaredField("recipeItems");
        recipeItemsField.setAccessible(true);
        Map<String, Recipe> recipeItems = (Map<String, Recipe>) recipeItemsField.get(this.heroInventory);

        Assert.assertEquals(1, commonItems.size());
        Assert.assertEquals(1, recipeItems.size());
    }
}
