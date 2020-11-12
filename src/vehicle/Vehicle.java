package vehicle;

public abstract class Vehicle {
    protected double fuelQuantity;
    protected double consumption;

    public Vehicle(double fuelQuantity, double consumption) {
        this.fuelQuantity = fuelQuantity;
        this.consumption = consumption;
    }

    public double getFuelQuantity() {
        return this.fuelQuantity;
    }

    protected void setFuelQuantity(double fuelQuantity) {
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
