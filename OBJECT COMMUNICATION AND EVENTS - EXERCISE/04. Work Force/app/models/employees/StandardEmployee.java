package app.models.employees;

public class StandardEmployee extends BaseEmployee {

    private static final int STANDARD_HOURS_PER_WEEK = 40;

    public StandardEmployee(String name) {
        super(name, STANDARD_HOURS_PER_WEEK);
    }

}
