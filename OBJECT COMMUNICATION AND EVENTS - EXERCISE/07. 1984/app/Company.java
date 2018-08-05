package app;

public class Company extends Id {

    private String name;
    private int turnover;
    private int revenue;

    public Company(String id) {
        super(id);
    }

    public Company(String id, String name, int turnover, int revenue) {
        super(id);
        this.name = name;
        this.turnover = turnover;
        this.revenue = revenue;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTurnover() {
        return this.turnover;
    }

    public void setTurnover(int turnover) {
        this.turnover = turnover;
    }

    public int getRevenue() {
        return this.revenue;
    }

    public void setRevenue(int revenue) {
        this.revenue = revenue;
    }
}
