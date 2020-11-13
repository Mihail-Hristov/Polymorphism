package vehicle;

import java.text.DecimalFormat;

public class Bus extends Vehicle {
    private boolean airConditionerIsOn = true;

    public Bus (double fuelQuantity, double consumption, double tankCapacity) {
        super(fuelQuantity, consumption + 1.4, tankCapacity);
    }

    @Override
    public void driving(double distance) {
        double currentConsumption = super.getConsumption();
        if (!this.airConditionerIsOn) {
            currentConsumption -= 1.4;
        }
        double neededLitersForCurrentDistance = (currentConsumption * distance);

        if (neededLitersForCurrentDistance > super.getFuelQuantity()) {
            System.out.println("Bus needs refueling");
            return;
        }

        super.setFuelQuantity(super.getFuelQuantity() - neededLitersForCurrentDistance);

        DecimalFormat df = new DecimalFormat("0.##");
        System.out.println("Bus travelled " + df.format(distance) +" km");
    }

    public void drivingEmptyBus(double distance) {
        this.airConditionerIsOn = false;
        driving(distance);
        this.airConditionerIsOn = true;
    }

    @Override
    public void refueling(double liters) {
        super.setFuelQuantity(liters);
    }

    @Override
    public String toString() {
        return String.format("Bus: %.2f", super.getFuelQuantity());
    }
}
