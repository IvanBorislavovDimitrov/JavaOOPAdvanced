import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CoffeeMachine {

    private List<Coin> coins;
    private List<Coffee> coffees;

    public CoffeeMachine() {
        this.coffees = new ArrayList<>();
        this.coins = new ArrayList<>();
    }

    public void insertCoin(String coinStr) {
        Coin coin = Coin.valueOf(coinStr);
        this.coins.add(coin);
    }

    public void buyCoffee(String coffeeSize, String coffeeType) {
        CoffeeSize coffeeSizeEnum = Enum.valueOf(CoffeeSize.class, coffeeSize.toUpperCase());
        CoffeeType coffeeTypeEnum = Enum.valueOf(CoffeeType.class, coffeeType.toUpperCase());
        Coffee coffee = new Coffee(coffeeSizeEnum, coffeeTypeEnum);
        if (coffee.getCoffeeSize().getPrice() <= sumCoins()) {
            this.coffees.add(coffee);
            this.coins.clear();
        }
    }

    public Iterable<Coffee> coffeesSold() {
        return Collections.unmodifiableCollection(coffees);
    }

    private int sumCoins() {
        return this.coins.stream().mapToInt(Coin::getValue).sum();
    }
}
