package app.models;

import app.models.Category;
import app.models.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.HashSet;
import java.util.Set;

public class CategoryTest {

    private Category category;

    @Before
    public void init() {
        this.category = new Category("Sladko");
        Category poison = new Category("Poison");
        this.category.getSubCategories().add(poison);
    }

    @Test
    public void addSubcategory() {
        this.category.getSubCategories().add(new Category("Beer"));
        Assert.assertEquals(2, this.category.getSubCategories().size());
    }

    @Test
    public void addUser() {
        User user = Mockito.mock(User.class);
        this.category.addUser(user);
        Assert.assertEquals(1, this.category.getUsers().size());
    }
}
