package cresla.entities.reactor;

public class HeatReactor extends BaseReactor {

    private int heatReductionIndex;

    public HeatReactor(int capacity, int heatReductionIndex) {
        super(capacity);
        this.heatReductionIndex = heatReductionIndex;
    }

    @Override
    public long getTotalEnergyOutput() {
        if (super.getContainer().getTotalEnergyOutput() > this.getTotalHeatAbsorbing()) {
            return 0;
        }

        return super.getContainer().getTotalEnergyOutput();
    }

    @Override
    public long getTotalHeatAbsorbing() {
        return super.getContainer().getTotalHeatAbsorbing() + this.heatReductionIndex;
    }

    public String toString() {
        return String.format("%s - %d\n" +
                        "Energy Output: %d\n" +
                        "Heat Absorbing: %d\n" +
                        "Modules: %d", this.getClass().getSimpleName(), this.getId(),
                this.getTotalEnergyOutput(),
                this.getTotalHeatAbsorbing(),
                this.getModuleCount());
    }
}
