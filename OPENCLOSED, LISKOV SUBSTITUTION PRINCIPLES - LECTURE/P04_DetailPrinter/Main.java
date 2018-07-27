package app.P04_DetailPrinter;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Person employee = new Employee("Pesho");
        Constructor<Manager> employeeConstructor = Manager.class.getDeclaredConstructor(String.class, Iterable.class);
        employeeConstructor.setAccessible(true);
        Person manager = employeeConstructor.newInstance("Ivo", new ArrayList<String>());
        DetailsPrinter detailsPrinter = new DetailsPrinter(new ArrayList<>() {{
            add(employee);
            add(manager);
        }});
        detailsPrinter.printDetails();
    }
}
