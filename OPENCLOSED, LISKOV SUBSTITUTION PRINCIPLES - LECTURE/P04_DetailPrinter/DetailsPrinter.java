package app.P04_DetailPrinter;

public class DetailsPrinter {

    private Iterable<Person> personIterable;

    public DetailsPrinter(Iterable<Person> personIterable) {
        this.personIterable = personIterable;
    }

    public void printDetails() {
        for (Person person : this.personIterable) {
            this.print(person);
        }
    }

    private void print(Person employee) {
        System.out.println(employee);
    }

}
