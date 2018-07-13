public class Person implements Comparable<Person> {

    private String name;
    private int age;
    private String city;

    public Person() {
    }

    public Person(String name, int age, String city) {
        this.name = name;
        this.age = age;
        this.city = city;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Person)) {
            return false;
        }
        return this.compareTo((Person) obj) == 0;
    }

    @Override
    public int compareTo(Person o) {
        if (this.getName().compareTo(o.getName()) == 0) {
            if (Integer.compare(this.getAge(), o.getAge()) == 0) {
                return this.getCity().compareTo(o.getCity());
            } else {
                return Integer.compare(this.getAge(), o.getAge());
            }
        }

        return this.getName().compareTo(o.getName());
    }
}
