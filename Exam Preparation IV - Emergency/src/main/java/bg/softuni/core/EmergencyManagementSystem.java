package bg.softuni.core;

import bg.softuni.contracts.Centre;
import bg.softuni.contracts.Emergency;
import bg.softuni.contracts.ManagementSystem;
import bg.softuni.enums.EmergencyLevel;
import bg.softuni.models.centres.FiremanServiceCenter;
import bg.softuni.models.centres.MedicalServiceCenter;
import bg.softuni.models.centres.PoliceServiceCenter;
import bg.softuni.models.emergencies.PublicHealthEmergency;
import bg.softuni.models.emergencies.PublicOrderEmergency;
import bg.softuni.models.emergencies.PublicPropertyEmergency;
import bg.softuni.utils.RegistrationTime;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.LinkedList;

public class EmergencyManagementSystem implements ManagementSystem {

    private LinkedList<Emergency> emergencies;
    private LinkedList<Centre> centres;
    private LinkedList<Centre> retiredCenters;

    public EmergencyManagementSystem() {
        this.emergencies = new LinkedList<>();
        this.centres = new LinkedList<>();
        this.retiredCenters = new LinkedList<>();
    }

    @Override
    public String registerPropertyEmergency(String description, EmergencyLevel emergencyLevel, RegistrationTime registrationTime, int damage) {
        Emergency emergency = new PublicPropertyEmergency(description, emergencyLevel, registrationTime, damage);

        this.emergencies.add(emergency);

        return String.format("Registered Public Property Emergency of level %s at %s.", emergencyLevel, registrationTime);
    }

    @Override
    public String registerHealthEmergency(String description, EmergencyLevel emergencyLevel, RegistrationTime registrationTime, int casualties) {
        Emergency emergency = new PublicHealthEmergency(description, emergencyLevel, registrationTime, casualties);

        this.emergencies.add(emergency);

        return String.format("Registered Public Health Emergency of level %s at %s.", emergencyLevel, registrationTime);
    }

    @Override
    public String registerOrderEmergency(String description, EmergencyLevel emergencyLevel, RegistrationTime registrationTime, boolean isSpecial) {
        Emergency emergency = new PublicOrderEmergency(description, emergencyLevel, registrationTime, isSpecial);

        this.emergencies.add(emergency);

        return String.format("Registered Public Order Emergency of level %s at %s.", emergencyLevel, registrationTime);
    }

    @Override
    public String registerFireServiceCenter(String name, int amountOfEmergencies) {
        Centre center = new FiremanServiceCenter(name, amountOfEmergencies);

        this.centres.add(center);

        return String.format("Registered Fire Service Emergency Center - %s.", name);
    }

    @Override
    public String registerMedicalServiceCenter(String name, int amountOfEmergencies) {
        Centre center = new MedicalServiceCenter(name, amountOfEmergencies);

        this.centres.add(center);

        return String.format("Registered Medical Service Emergency Center - %s.", name);
    }

    @Override
    public String registerPoliceServiceCenter(String name, int amountOfEmergencies) {
        Centre center = new PoliceServiceCenter(name, amountOfEmergencies);

        this.centres.add(center);

        return String.format("Registered Police Service Emergency Center - %s.", name);
    }

    @Override
    public String processEmergencies(String type) {
        String methodName = "process" + type + "Emergencies";
        try {
            Method method = this.getClass().getDeclaredMethod(methodName, String.class);
            return (String) method.invoke(this, type);

        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        return null;
    }

    private String processOrderEmergencies(String type) {
        while (this.getSizeOfOrderEmergencies() != 0 && this.getSizeOfPoliceCentres() != 0) {

            Emergency orderEmergency = this.getFirstOrderEmergency();
            Centre policeCentre = this.getFirstPoliceCentre();
            this.emergencies.remove(orderEmergency);
            policeCentre.getEmergencyRegister().enqueueEmergency(orderEmergency);
            this.centres.remove(policeCentre);
            if (!policeCentre.isForRetirement()) {
                this.centres.addLast(policeCentre);
            } else {
                this.retiredCenters.addLast(policeCentre);
            }
        }

        if (this.getSizeOfOrderEmergencies() == 0) {
            return String.format("Successfully responded to all %s emergencies.", type);
        }

        return String.format("%s Emergencies left to process: %d.", type, this.getSizeOfOrderEmergencies());
    }

    private String processHealthEmergencies(String type) {
        while (this.getSizeOfHealthEmergencies() != 0 && this.getSizeOfMedicalCentres() != 0) {

            Emergency healthEmergency = this.getFirstHealthEmergency();
            Centre healthCentre = this.getFirstMedicalCentre();
            this.emergencies.remove(healthEmergency);
            healthCentre.getEmergencyRegister().enqueueEmergency(healthEmergency);
            this.centres.remove(healthCentre);
            if (!healthCentre.isForRetirement()) {
                this.centres.addLast(healthCentre);
            } else {
                this.retiredCenters.addLast(healthCentre);
            }
        }

        if (this.getSizeOfHealthEmergencies() == 0) {
            return String.format("Successfully responded to all %s emergencies.", type);
        }

        return String.format("%s Emergencies left to process: %d.", type, this.getSizeOfHealthEmergencies());
    }

    private String processPropertyEmergencies(String type) {
        while (this.getSizeOfPropertyEmergencies() != 0 && this.getSizeOfFireCentres() != 0) {

            Emergency propertyEmergency = this.getFirstPropertyEmergency();
            Centre policeCentre = this.getFirstFireCentre();
            this.emergencies.remove(propertyEmergency);
            policeCentre.getEmergencyRegister().enqueueEmergency(propertyEmergency);
            this.centres.remove(policeCentre);
            if (!policeCentre.isForRetirement()) {
                this.centres.addLast(policeCentre);
            } else {
                this.retiredCenters.addLast(policeCentre);
            }
        }

        if (this.getSizeOfPropertyEmergencies() == 0) {
            return String.format("Successfully responded to all %s emergencies.", type);
        }

        return String.format("%s Emergencies left to process: %d.", type, this.getSizeOfPropertyEmergencies());
    }

    private int getSizeOfFireCentres() {
        return (int) this.centres.stream().filter(x -> x instanceof FiremanServiceCenter).count();
    }

    private int getSizeOfMedicalCentres() {
        return (int) this.centres.stream().filter(x -> x instanceof MedicalServiceCenter).count();
    }

    private int getSizeOfPoliceCentres() {
        return (int) this.centres.stream().filter(x -> x instanceof PoliceServiceCenter).count();
    }

    private int getSizeOfOrderEmergencies() {
        return (int) this.emergencies.stream().filter(x -> x instanceof PublicOrderEmergency).count();
    }

    private int getSizeOfHealthEmergencies() {
        return (int) this.emergencies.stream().filter(x -> x instanceof PublicHealthEmergency).count();
    }

    private int getSizeOfPropertyEmergencies() {
        return (int) this.emergencies.stream().filter(x -> x instanceof PublicPropertyEmergency).count();
    }

    private Emergency getFirstPropertyEmergency() {
        return this.emergencies.stream().filter(x -> x instanceof PublicPropertyEmergency).findFirst().orElse(null);
    }

    private Emergency getFirstOrderEmergency() {
        return this.emergencies.stream().filter(x -> x instanceof PublicOrderEmergency).findFirst().orElse(null);
    }

    private Emergency getFirstHealthEmergency() {
        return this.emergencies.stream().filter(x -> x instanceof PublicHealthEmergency).findFirst().orElse(null);
    }

    private Centre getFirstPoliceCentre() {
        return this.centres.stream().filter(x -> x instanceof PoliceServiceCenter).findFirst().orElse(null);
    }

    private Centre getFirstMedicalCentre() {
        return this.centres.stream().filter(x -> x instanceof MedicalServiceCenter).findFirst().orElse(null);
    }

    private Centre getFirstFireCentre() {
        return this.centres.stream().filter(x -> x instanceof FiremanServiceCenter).findFirst().orElse(null);
    }

    private int getSizeOfTotalProcessedEmergencies() {
        return this.centres.stream().mapToInt(c -> c.getEmergencyRegister().getCurrentSize()).sum()
                + this.retiredCenters.stream().mapToInt(c -> c.getEmergencyRegister().getCurrentSize()).sum();
    }

    private int totalPropertyDamageFixed() {
        return this.centres.stream().filter(c -> c instanceof FiremanServiceCenter)
                .mapToInt(c -> c.getEmergencyRegister().getTotalEmergencies().stream()
                        .mapToInt(e -> ((PublicPropertyEmergency) e).getDamage()).sum()).sum() +
                this.retiredCenters.stream().filter(c -> c instanceof FiremanServiceCenter)
                        .mapToInt(c -> c.getEmergencyRegister().getTotalEmergencies().stream()
                                .mapToInt(e -> ((PublicPropertyEmergency) e).getDamage()).sum()).sum();
    }

    private int totalCasualtiesSaved() {
        return this.centres.stream().filter(c -> c instanceof MedicalServiceCenter)
                .mapToInt(c -> c.getEmergencyRegister().getTotalEmergencies().stream()
                        .mapToInt(e -> ((PublicHealthEmergency) e).getNumberOfCasualties()).sum()).sum() +
                this.retiredCenters.stream().filter(c -> c instanceof MedicalServiceCenter)
                        .mapToInt(c -> c.getEmergencyRegister().getTotalEmergencies().stream()
                                .mapToInt(e -> ((PublicHealthEmergency) e).getNumberOfCasualties()).sum()).sum();
    }

    private int totalAmountOfSpecialCases() {
        return this.centres.stream().filter(c -> c instanceof PoliceServiceCenter)
                .mapToInt(c -> (int) c.getEmergencyRegister().getTotalEmergencies().stream()
                        .filter(e -> ((PublicOrderEmergency) e).isSpecial()).count()).sum() +
                this.retiredCenters.stream().filter(c -> c instanceof PoliceServiceCenter)
                        .mapToInt(c -> (int) c.getEmergencyRegister().getTotalEmergencies().stream()
                                .filter(e -> ((PublicOrderEmergency) e).isSpecial()).count()).sum();
    }

    @Override
    public String emergencyReport() {

        return "PRRM Services Live Statistics" + System.lineSeparator() +
                String.format("Fire Service Centers: %d", this.getSizeOfFireCentres()) + System.lineSeparator() +
                String.format("Medical Service Centers: %d", this.getSizeOfMedicalCentres()) + System.lineSeparator() +
                String.format("Police Service Centers: %d", this.getSizeOfPoliceCentres()) + System.lineSeparator() +
                String.format("Total Processed Emergencies: %d", this.getSizeOfTotalProcessedEmergencies()) + System.lineSeparator() +
                String.format("Currently Registered Emergencies: %d", this.emergencies.size()) + System.lineSeparator() +
                String.format("Total Property Damage Fixed: %d", this.totalPropertyDamageFixed()) + System.lineSeparator() +
                String.format("Total Health Casualties Saved: %d", this.totalCasualtiesSaved()) + System.lineSeparator() +
                String.format("Total Special Cases Processed: %d", this.totalAmountOfSpecialCases());
    }
}
