package app.model;

public class PersonImpl implements Person {

    private long id;
    private String username;

    public PersonImpl() {
    }

    public PersonImpl(long id, String username) {
        this.id = id;
        this.username = username;
    }

    @Override
    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public int compareTo(Person person) {
        return Long.compare(this.getId(), person.getId());
    }
}
