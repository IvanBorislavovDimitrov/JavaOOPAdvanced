package app.models.employees;

public class PartTimeEmployee extends BaseEmployee {


    private static final int STANDARD_HOURS_PER_WEEK = 20;

    public PartTimeEmployee(String name) {
        super(name, STANDARD_HOURS_PER_WEEK);
    }


}
