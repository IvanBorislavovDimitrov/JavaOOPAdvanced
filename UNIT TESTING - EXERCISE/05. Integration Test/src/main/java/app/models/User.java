package app.models;

import java.util.HashSet;
import java.util.Set;

public class User {

    private String name;
    private Set<Category> categories;

    public User() {
        this(null);
    }

    public User(String name) {
        this.name = name;
        this.categories = new HashSet<>();
    }

    public void addCategory(Category category) {
        this.categories.add(category);
    }

    public void removeSubCategoriesByName(String... categoriesNames) {
        for (String categoryName : categoriesNames) {
            removeCategoryByName(categoryName);
        }
    }

    private void removeCategoryByName(Set<Category> categories, String categoryName, Category parent) {
        for (Category category : categories) {
            if (category.getSubCategories().size() != 0) {
                removeCategoryByName(category.getSubCategories(), categoryName, category);
            }
            if (category.getName().equals(categoryName)) {
                if (parent != null) {
                    parent.setUsers(new HashSet<>(category.getUsers()));
                }
                category.getUsers().remove(this);
                categories.remove(category);
                break;
            }
        }
    }

    public void removeCategoryByName(String categoryName) {
        removeCategoryByName(this.categories, categoryName, null);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Category> getCategories() {
        return this.categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }
}
