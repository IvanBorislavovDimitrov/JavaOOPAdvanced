package app;

import app.models.Category;
import app.models.User;

public class Main {

    public static void main(String[] args) {
        User user = new User();
        Category category = new Category("kur");
        Category subCategory = new Category("dedovee");
        category.getSubCategories().add(subCategory);
        user.addCategory(category);

        subCategory.getUsers().add(user);

        user.removeCategoryByName("dedovee");
        System.out.println(category.getUsers());
    }
}
