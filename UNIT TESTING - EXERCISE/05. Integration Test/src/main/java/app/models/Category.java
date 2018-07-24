package app.models;

import java.util.HashSet;
import java.util.Set;

public class Category {

    private String name;
    private Set<User> users;
    private Set<Category> subCategories;

    public Category() {
        this(null);
    }

    public Category(String name) {
        this.name = name;
        this.users = new HashSet<>();
        this.subCategories = new HashSet<>();
    }

    public void addSubcategory(Category category) {
        this.subCategories.add(category);
    }

    public void addUser(User user) {
        this.users.add(user);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<User> getUsers() {
        return this.users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public Set<Category> getSubCategories() {
        return this.subCategories;
    }

    public void setSubCategories(Set<Category> subCategories) {
        this.subCategories = subCategories;
    }
}
