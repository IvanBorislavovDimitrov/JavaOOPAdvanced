package panzer.entities.parts;

import panzer.contracts.Part;

import java.math.BigDecimal;

public abstract class AbstractPart implements Part {

    private String model;
    private double weight;
    private BigDecimal price;

    public AbstractPart(String model, double weight, BigDecimal price) {
        this.model = model;
        this.weight = weight;
        this.price = price;
    }

    @Override
    public double getWeight() {
        return this.weight;
    }

    @Override
    public BigDecimal getPrice() {
        return this.price;
    }

    @Override
    public String getModel() {
        return this.model;
    }

    @Override
    public String toString() {
        return String.format("%s Part - %s", this.getClass().getSimpleName()
                .substring(0, this.getClass().getSimpleName().indexOf('P')), this.model);
    }
}
