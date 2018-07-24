import app.Database;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import javax.naming.OperationNotSupportedException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Type;

public class DatabaseTest {

    @Rule
    public final ExpectedException expectedException = ExpectedException.none();

    private Database<Integer> database;

    @Before
    public void initDatabase() throws OperationNotSupportedException {
        this.database = new Database<>(16);
    }

    @Test
    public void database_checkCreating_with16Elements() throws OperationNotSupportedException {
    }

    @Test
    public void database_checkCreating_withNumberDifferentThan16() throws OperationNotSupportedException {
        expectedException.expect(OperationNotSupportedException.class);
        expectedException.expectMessage("Capacity must be 16!");
        Database<Integer> database = new Database<>(10);

    }

    @Test
    public void database_checkAdding_lessThan16Elements() throws OperationNotSupportedException {
        database.add(1);
        database.add(2);
        database.add(3);
        database.add(4);

        Integer[] expectedNumbers = {1, 2, 3, 4};

        Assert.assertArrayEquals("toArray method doesn't work correctly!", expectedNumbers, database.toArray());

        Assert.assertEquals("Length is not valid!", 4, database.getLength());
    }

    @Test
    public void database_checkAdding_moreThen16Elements() throws OperationNotSupportedException {
        expectedException.expect(OperationNotSupportedException.class);
        expectedException.expectMessage("Capacity reached!");
        for (int i = 0; i < 20; i++) {
            database.add(i);
        }
    }

    @Test
    public void database_checkAdding_nullElement() throws OperationNotSupportedException {
        expectedException.expect(OperationNotSupportedException.class);
        expectedException.expectMessage("Element cannot be null!");
        database.add(null);
    }

    @Test
    public void database_checkRemoving_oneElement() throws OperationNotSupportedException {
        database.add(1);
        database.add(2);
        database.add(3);

        Integer element = database.remove();

        Assert.assertEquals("Remove method doesn't work correctly!", java.util.Optional.of(3).get(), element);

        Assert.assertEquals("Length is not valid!", 2, database.getLength());
    }

    @Test
    public void database_checkRemoving_removeManyElements() throws OperationNotSupportedException {
        database.add(1);
        database.add(2);
        database.add(3);

        Integer element = database.remove();
        element = database.remove();
        element = database.remove();
        expectedException.expect(OperationNotSupportedException.class);
        expectedException.expectMessage("No elements!");
        element = database.remove();
    }

    @Test
    public void database_testConstructors_mustBeOneWithOneParameter() {
        Constructor<?>[] constructors = database.getClass().getConstructors();
        Assert.assertEquals("Database must have only 1 constructor!",1, constructors.length);

        Constructor<?> constructor = constructors[0];
        Class<?>[] parameterTypes = constructor.getParameterTypes();
        Assert.assertEquals("Constructor must have only 1 parameter!",1, parameterTypes.length);

        Type type = parameterTypes[0];
        Assert.assertEquals("Parameter must be of type int!", int.class, type);
    }
}
