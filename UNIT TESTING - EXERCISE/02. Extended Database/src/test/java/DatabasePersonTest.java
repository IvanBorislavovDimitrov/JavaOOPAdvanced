import app.database.DatabasePerson;
import app.model.Person;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mockito;

import javax.naming.OperationNotSupportedException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Type;

public class DatabasePersonTest {

    @Rule
    public final ExpectedException expectedException = ExpectedException.none();

    private DatabasePerson<Person> peopleDatabase;

    @Before
    public void initDatabase() throws OperationNotSupportedException {
        this.peopleDatabase = new DatabasePerson<>(16);
    }

    @Test
    public void peopleDatabase_testAdd_expectTwoAdded() throws OperationNotSupportedException {
        Person person = Mockito.mock(Person.class);
        Mockito.when(person.getId()).thenReturn(1L);
        Mockito.when(person.getUsername()).thenReturn("Pesho");

        Person person1 = Mockito.mock(Person.class);
        Mockito.when(person1.getId()).thenReturn(2L);
        Mockito.when(person1.getUsername()).thenReturn("Kondio");

        this.peopleDatabase.add(person);
        this.peopleDatabase.add(person1);

        Assert.assertEquals("Wrong size of database!", 2, this.peopleDatabase.getLength());
    }

    @Test
    public void peopleDatabase_testAddWithSameId_expectException() throws OperationNotSupportedException {
        Person person = Mockito.mock(Person.class);
        Mockito.when(person.getId()).thenReturn(1L);
        Mockito.when(person.getUsername()).thenReturn("Pesho");

        Person person1 = Mockito.mock(Person.class);
        Mockito.when(person1.getId()).thenReturn(1L);
        Mockito.when(person1.getUsername()).thenReturn("Kondio");

        expectedException.expect(OperationNotSupportedException.class);
        expectedException.expectMessage("Id is taken");

        this.peopleDatabase.add(person);
        this.peopleDatabase.add(person1);
    }

    @Test
    public void peopleDatabase_testAddWithSameUsername_expectException() throws OperationNotSupportedException {
        Person person = Mockito.mock(Person.class);
        Mockito.when(person.getId()).thenReturn(1L);
        Mockito.when(person.getUsername()).thenReturn("Pesho");

        Person person1 = Mockito.mock(Person.class);
        Mockito.when(person1.getId()).thenReturn(2L);
        Mockito.when(person1.getUsername()).thenReturn("Pesho");

        expectedException.expect(OperationNotSupportedException.class);
        expectedException.expectMessage("Username is taken");

        this.peopleDatabase.add(person);
        this.peopleDatabase.add(person1);
    }

    @Test
    public void peopleDatabase_testAddCapacityReached_expectException() throws OperationNotSupportedException {
        expectedException.expect(OperationNotSupportedException.class);
        expectedException.expectMessage("Capacity reached!");

        for (int i = 0; i < 117; i++) {
            Person person = Mockito.mock(Person.class);
            Mockito.when(person.getId()).thenReturn((long) i + 1);
            Mockito.when(person.getUsername()).thenReturn("Pesho" + i);

            this.peopleDatabase.add(person);
        }
    }

    @Test
    public void peopleDatabase_testForInvalidPersonUsername_expectException() throws OperationNotSupportedException {
        Person person = Mockito.mock(Person.class);
        Mockito.when(person.getId()).thenReturn(1L);
        Mockito.when(person.getUsername()).thenReturn(null);

        expectedException.expect(OperationNotSupportedException.class);
        expectedException.expectMessage("Not a valid person!");

        this.peopleDatabase.add(person);
    }

    @Test
    public void peopleDatabase_testRemove_expectedZeroPeople() throws OperationNotSupportedException {
        Person person = Mockito.mock(Person.class);
        Mockito.when(person.getId()).thenReturn(12L);
        Mockito.when(person.getUsername()).thenReturn("Kondio");

        this.peopleDatabase.add(person);

        Person expected = this.peopleDatabase.remove();

        Assert.assertEquals(expected, person);
    }

    @Test
    public void peopleDatabase_testRemove_exceptionExpected() throws OperationNotSupportedException {
        Person person = Mockito.mock(Person.class);
        Mockito.when(person.getId()).thenReturn(12L);
        Mockito.when(person.getUsername()).thenReturn("Kondio");

        this.peopleDatabase.add(person);

        expectedException.expect(OperationNotSupportedException.class);
        expectedException.expectMessage("No people!");

        Person expected = this.peopleDatabase.remove();
        expected = this.peopleDatabase.remove();
    }

    @Test
    public void peopleDatabase_testFindByUsername_mustFindUser() throws OperationNotSupportedException {
        Person person = Mockito.mock(Person.class);
        Mockito.when(person.getId()).thenReturn(12L);
        Mockito.when(person.getUsername()).thenReturn("Kondio");

        this.peopleDatabase.add(person);

        Person expected = this.peopleDatabase.findByUsername("Kondio");

        Assert.assertEquals(expected, person);
    }

    @Test
    public void peopleDatabase_testFindById_mustFindUser() throws OperationNotSupportedException {
        Person person = Mockito.mock(Person.class);
        Mockito.when(person.getId()).thenReturn(12L);
        Mockito.when(person.getUsername()).thenReturn("Kondio");

        this.peopleDatabase.add(person);

        Person expected = this.peopleDatabase.findById(12);

        Assert.assertEquals(expected, person);
    }

    @Test
    public void peopleDatabase_testFindByUsernameNull_exceptionExpected() throws OperationNotSupportedException {
        Person person = Mockito.mock(Person.class);
        Mockito.when(person.getId()).thenReturn(12L);
        Mockito.when(person.getUsername()).thenReturn("Kondio");

        this.peopleDatabase.add(person);

        expectedException.expect(OperationNotSupportedException.class);
        expectedException.expectMessage("Username cannot be null");

        Person expected = this.peopleDatabase.findByUsername(null);
    }

    @Test
    public void peopleDatabase_testFindByUsernameMissing_exceptionExpected() throws OperationNotSupportedException {
        Person person = Mockito.mock(Person.class);
        Mockito.when(person.getId()).thenReturn(12L);
        Mockito.when(person.getUsername()).thenReturn("Kondio");

        this.peopleDatabase.add(person);

        expectedException.expect(OperationNotSupportedException.class);
        expectedException.expectMessage("User not found!");

        Person expected = this.peopleDatabase.findByUsername("Pedro");
    }

    @Test
    public void peopleDatabase_testFindByIdMissing_exceptionExpected() throws OperationNotSupportedException {
        Person person = Mockito.mock(Person.class);
        Mockito.when(person.getId()).thenReturn(12L);
        Mockito.when(person.getUsername()).thenReturn("Kondio");

        this.peopleDatabase.add(person);

        expectedException.expect(OperationNotSupportedException.class);
        expectedException.expectMessage("User not found!");

        Person expected = this.peopleDatabase.findById(14);
    }


    @Test
    public void database_testConstructors_mustBeOneWithOneParameter() {
        Constructor<?>[] constructors = this.peopleDatabase.getClass().getConstructors();
        Assert.assertEquals("Database must have only 1 constructor!",1, constructors.length);

        Constructor<?> constructor = constructors[0];
        Class<?>[] parameterTypes = constructor.getParameterTypes();
        Assert.assertEquals("Constructor must have only 1 parameter!",1, parameterTypes.length);

        Type type = parameterTypes[0];
        Assert.assertEquals("Parameter must be of type int!", int.class, type);
    }
}
