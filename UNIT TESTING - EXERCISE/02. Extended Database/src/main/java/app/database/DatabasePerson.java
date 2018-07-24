package app.database;

import app.model.Person;

import javax.naming.OperationNotSupportedException;

public class DatabasePerson<T extends Person> {

    private Object[] people;
    private int length;

    @SuppressWarnings("unchecked")
    public DatabasePerson(int capacity) throws OperationNotSupportedException {
        if (capacity != 16) {
            throw new OperationNotSupportedException("Capacity must be 16!");
        }

        this.people = new Object[capacity];
    }

    @SuppressWarnings("unchecked")
    public T findById(long id) throws OperationNotSupportedException {
        for (Object person : this.people) {
            if (person == null) {
                break;
            }
            if (((T) person).getId() == id) {
                return (T) person;
            }
        }

        throw new OperationNotSupportedException("User not found!");
    }


    @SuppressWarnings("unchecked")
    public T findByUsername(String username) throws OperationNotSupportedException {
        if (username == null) {
            throw new OperationNotSupportedException("Username cannot be null!");
        }
        for (Object person : this.people) {
            if (person == null) {
                break;
            }
            if (((T) person).getUsername().equals(username)) {
                return (T) person;
            }
        }

        throw new OperationNotSupportedException("User not found!");
    }

    public T remove() throws OperationNotSupportedException {
        if (this.length == 0) {
            throw new OperationNotSupportedException("No people!");
        }
        T person = (T) this.people[this.length - 1];
        this.people[this.length - 1] = null;
        this.length--;

        return person;
    }

    public void add(T person) throws OperationNotSupportedException {
        if (!isPersonValid(person)) {
            throw new OperationNotSupportedException("Not a valid person!");
        }
        if (isIdTaken(person.getId())) {
            throw new OperationNotSupportedException("Id is taken");
        }
        if (isUsernameTaken(person.getUsername())) {
            throw new OperationNotSupportedException("Username is taken");
        }
        if (this.length == this.people.length) {
            throw new OperationNotSupportedException("Capacity reached!");
        }
        this.people[this.length] = person;
        this.length++;
    }

    private boolean isIdTaken(long id) {
        for (Object person : this.people) {
            if (person == null) {
                break;
            }
            if (((T) person).getId() == id) {
                return true;
            }
        }

        return false;
    }

    private boolean isUsernameTaken(String username) {
        for (Object person : this.people) {
            if (person == null) {
                break;
            }
            if (((T) person).getUsername().equals(username)) {
                return true;
            }
        }

        return false;
    }

    public Object[] toArray() {
        return this.people;
    }

    public int getLength() {
        return this.length;
    }

    private boolean isPersonValid(Person person) {
        return person.getId() > 0 && person.getUsername() != null;
    }
}
