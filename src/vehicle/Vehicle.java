package vehicle;

public abstract class Vehicle {
    private double fuelQuantity;
    private double consumption;
    private double tankCapacity;

    public Vehicle(double fuelQuantity, double consumption, double tankCapacity) {
        this.setFuelQuantity(fuelQuantity);
        this.consumption = consumption;
        this.tankCapacity = tankCapacity;
    }

    public double getFuelQuantity() {
        return this.fuelQuantity;
    }

    protected void setFuelQuantity(double fuelQuantity) {
        if (fuelQuantity <= 0) {
            throw new IllegalArgumentException("Fuel must be a positive number");
        }

        this.fuelQuantity = fuelQuantity;
    }

    public double getConsumption() {
        return this.consumption;
    }

    protected void setConsumption(double consumption) {
        this.consumption = consumption;
    }


    protected abstract void driving(double distance);
    protected abstract void refueling(double liters);
}
