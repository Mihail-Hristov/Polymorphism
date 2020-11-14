package vehicle;

import java.text.DecimalFormat;

public class Vehicle {
    private double fuelQuantity;
    private double consumption;
    private final double tankCapacity;

    public Vehicle(double fuelQuantity, double consumption, double tankCapacity) {
        this.tankCapacity = tankCapacity;
        this.setFuelQuantity(fuelQuantity);
        this.consumption = consumption;
    }

    public void setConsumption(double consumption) {
        this.consumption = consumption;
    }

    public double getConsumption() {
        return this.consumption;
    }

    public double getFuelQuantity() {
        return this.fuelQuantity;
    }

    protected void setFuelQuantity(double fuelQuantity) {
        validatedForPositiveNumber(fuelQuantity);
        checkForFreeSpace(fuelQuantity);
        this.fuelQuantity = fuelQuantity;
    }

    private void validatedForPositiveNumber(double argument) {
        if (argument <= 0) {
            throw new IllegalArgumentException("Fuel must be a positive number");
        }
    }

    private void checkForFreeSpace(double newLiters) {
        if (newLiters > this.tankCapacity) {
            throw new IllegalStateException("Cannot fit fuel in tank");
        }
    }

    public String driving(double distance){
        double neededLitersForCurrentDistance = (this.consumption * distance);

        if (neededLitersForCurrentDistance > this.getFuelQuantity()) {
            return String.format("%s needs refueling", this.getClass().getSimpleName());
        }

        this.fuelQuantity -= neededLitersForCurrentDistance;
        DecimalFormat df = new DecimalFormat("0.##");
        return String.format("%s travelled %s km", this.getClass().getSimpleName(),
                df.format(distance));
    }

    public void refueling(double liters){
        validatedForPositiveNumber(liters);
        checkForFreeSpace(liters);
        this.setFuelQuantity(this.getFuelQuantity() + liters);
    }

    public String toString() {
        return String.format("%s: %.2f",this.getClass().getSimpleName(), this.getFuelQuantity());
    }
}
