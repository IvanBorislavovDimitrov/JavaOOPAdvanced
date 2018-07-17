public class Coffee {

    private CoffeeSize coffeeSize;
    private CoffeeType coffeeType;

    public Coffee(CoffeeSize coffeeSize, CoffeeType coffeeType) {
        this.coffeeSize = coffeeSize;
        this.coffeeType = coffeeType;
    }

    public CoffeeSize getCoffeeSize() {
        return coffeeSize;
    }

    public void setCoffeeSize(CoffeeSize coffeeSize) {
        this.coffeeSize = coffeeSize;
    }

    public CoffeeType getCoffeeType() {
        return coffeeType;
    }

    public void setCoffeeType(CoffeeType coffeeType) {
        this.coffeeType = coffeeType;
    }

    @Override
    public String toString() {
        return String.format("%s %s", getCoffeeSizeStr(), getCoffeeTypeStr());
    }

    private String getCoffeeTypeStr() {
        return coffeeType.toString().charAt(0) + coffeeType.toString().substring(1).toLowerCase();
    }

    private String getCoffeeSizeStr() {
        return coffeeSize.toString().charAt(0) + coffeeSize.toString().substring(1).toLowerCase();
    }
}
