package vehicle;

import java.text.DecimalFormat;

public class Truck extends Vehicle{

    public Truck(double fuelQuantity, double consumption, double tankCapacity) {
        super(fuelQuantity, consumption + 1.6, tankCapacity);
    }

    @Override
    public void driving(double distance) {
        double neededLitersForCurrentDistance = (super.getConsumption() * distance);

        if (neededLitersForCurrentDistance > super.getFuelQuantity()) {
            System.out.println("Truck needs refueling");
            return;
        }

        super.setFuelQuantity(super.getFuelQuantity() - neededLitersForCurrentDistance);

        DecimalFormat df = new DecimalFormat("0.##");
        System.out.println("Truck travelled " + df.format(distance) + " km");
    }

    @Override
    public void refueling(double liters) {
        super.setFuelQuantity(liters * 0.95);
    }

    @Override
    public String toString() {
        return String.format("Truck: %.2f", super.getFuelQuantity());
    }
}
