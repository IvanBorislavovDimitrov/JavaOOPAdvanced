package app.models;

import app.models.Category;
import app.models.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.HashSet;
import java.util.Set;

public class UserTest {

    private User user;

    @Before
    public void init() {
        this.user = new User("Pesho");

        Category category = Mockito.mock(Category.class);
        Mockito.when(category.getName()).thenReturn("Chocolate");
        Set<Category> subCategories = new HashSet<>();
        Category category1 = Mockito.mock(Category.class);
        Mockito.when(category1.getName()).thenReturn("Cacao");

        Category category2 = Mockito.mock(Category.class);
        Mockito.when(category2.getName()).thenReturn("Cacao");

        subCategories.add(category1);
        subCategories.add(category2);

        Mockito.when(category.getSubCategories()).thenReturn(subCategories);

        this.user.addCategory(category);
    }

    @Test
    public void testAddingCategories() {
        Assert.assertEquals("Category isn't added to the user", 1, user.getCategories().size());
    }

    @Test
    public void testRemoveCategory() {

        user.removeCategoryByName("Chocolate");

        Assert.assertEquals("Category isn't removed to the user", 0, user.getCategories().size());
    }

    @Test
    public void removeSubcategory() {
        user.removeCategoryByName("Cacao");
        Assert.assertEquals(1, user.getCategories().size());
    }
}
