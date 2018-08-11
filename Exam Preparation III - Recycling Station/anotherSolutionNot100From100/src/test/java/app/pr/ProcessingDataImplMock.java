package app.pr;

import app.waste_disposal.contracts.ProcessingData;

public class ProcessingDataImplMock implements ProcessingData {

    private double a;
    private double b;

    public ProcessingDataImplMock(double a, double b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public double getEnergyBalance() {
        return a;
    }

    @Override
    public double getCapitalBalance() {
        return b;
    }
}
