public class Person implements Comparable<Person> {

    private String name;
    private int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return this.age;
    }

    @Override
    public int hashCode() {
        return this.getName().hashCode() + this.getAge();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj != null) {
            if (obj instanceof Person) {
                return this.compareTo((Person) obj) == 0;
            }
        }

        return false;
    }

    @Override
    public int compareTo(Person o) {
        if (this.getName().equals(o.getName())) {
            return Integer.compare(this.getAge(), o.getAge());
        }

        return this.getName().compareTo(o.getName());
    }

    @Override
    public String toString() {
        return String.format("%s %d", this.getName(), this.getAge());
    }
}
