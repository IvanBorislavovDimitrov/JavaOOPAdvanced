package app.waste_disposal.dto;

import app.waste_disposal.contracts.ProcessingData;

public class Info {

    private String log;
    private ProcessingData processingData;
    private String typeOfForbidden;
    private double energyBalance;
    private double capotalBalance;

    public Info(String log, ProcessingData processingData) {
        this.log = log;
        this.processingData = processingData;
    }

    public String getLog() {
        return this.log;
    }

    public void setLog(String log) {
        this.log = log;
    }

    public ProcessingData getProcessingData() {
        return this.processingData;
    }

    public void setProcessingData(ProcessingData processingData) {
        this.processingData = processingData;
    }

    public String getTypeOfForbidden() {
        return this.typeOfForbidden;
    }

    public void setTypeOfForbidden(String typeOfForbidden) {
        this.typeOfForbidden = typeOfForbidden;
    }

    public double getEnergyBalance() {
        return this.energyBalance;
    }

    public void setEnergyBalance(double energyBalance) {
        this.energyBalance = energyBalance;
    }

    public double getCapotalBalance() {
        return this.capotalBalance;
    }

    public void setCapotalBalance(double capotalBalance) {
        this.capotalBalance = capotalBalance;
    }
}
