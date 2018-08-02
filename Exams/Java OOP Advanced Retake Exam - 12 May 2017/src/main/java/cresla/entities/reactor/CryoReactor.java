package cresla.entities.reactor;

public class CryoReactor extends BaseReactor {

    private int	cryoProductionIndex;

    public CryoReactor(int capacity, int cryoProductionIndex) {
        super(capacity);
        this.cryoProductionIndex = cryoProductionIndex;
    }

    @Override
    public long getTotalEnergyOutput() {
        if (super.getContainer().getTotalEnergyOutput() * this.cryoProductionIndex > this.getTotalHeatAbsorbing()) {
            return 0;
        }

        return super.getContainer().getTotalEnergyOutput() * this.cryoProductionIndex;
    }

    @Override
    public long getTotalHeatAbsorbing() {
        return super.getContainer().getTotalHeatAbsorbing();
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
