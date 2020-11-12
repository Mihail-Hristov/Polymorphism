package vehicle;

import java.text.DecimalFormat;

public class Bus extends Vehicle {

    public Bus (double fuelQuantity, double consumption, double tankCapacity) {
        super(fuelQuantity, consumption, tankCapacity);
    }

    @Override
    public void driving(double distance) {
        double neededLitersForCurrentDistance = (super.getConsumption() * distance);

        if (neededLitersForCurrentDistance > super.getFuelQuantity()) {
            System.out.println("Bus needs refueling");
            return;
        }

        super.setFuelQuantity(super.getFuelQuantity() - neededLitersForCurrentDistance);

        DecimalFormat df = new DecimalFormat("0.##");
        System.out.println("Bus travelled " + df.format(distance) +" km");
    }

    @Override
    public void refueling(double liters) {
        double currentQuantity = super.getFuelQuantity();
        double newQuantity = currentQuantity + liters;

        super.setFuelQuantity(newQuantity);
    }

    @Override
    public String toString() {
        return String.format("Bus: %.2f", super.getFuelQuantity());
    }
}
