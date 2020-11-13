package vehicle;

import java.text.DecimalFormat;

public class Car extends Vehicle {

    public Car(double fuelQuantity, double consumption, double tankCapacity) {
        super(fuelQuantity, consumption + 0.9, tankCapacity);
    }

    @Override
    public void driving(double distance) {
        double neededLitersForCurrentDistance = (super.getConsumption() * distance);

        if (neededLitersForCurrentDistance > super.getFuelQuantity()) {
            System.out.println("Car needs refueling");
            return;
        }

        super.setFuelQuantity(super.getFuelQuantity() - neededLitersForCurrentDistance);

        DecimalFormat df = new DecimalFormat("0.##");
        System.out.println("Car travelled " + df.format(distance) +" km");
    }

    @Override
    public void refueling(double liters) {
        super.setFuelQuantity(liters);
    }

    @Override
    public String toString() {
        return String.format("Car: %.2f", super.getFuelQuantity());
    }
}
