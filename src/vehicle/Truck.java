package vehicle;

import java.text.DecimalFormat;

public class Truck extends Vehicle{

    public Truck(double fuelQuantity, double consumption) {
        super(fuelQuantity, consumption + 1.6);
    }

    @Override
    protected void driving(double distance) {
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
    protected void refueling(double liters) {
        double currentQuantity = super.getFuelQuantity();
        double newQuantity = currentQuantity + (liters * 0.95);

        super.setFuelQuantity(newQuantity);
    }

    @Override
    public String toString() {
        return String.format("Truck: %.2f", super.getFuelQuantity());
    }
}
