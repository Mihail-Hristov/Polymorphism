package vehicle;

import java.text.DecimalFormat;

public class Truck extends Vehicle{
    private static final double AIR_CONSUMPTION_EXTEND = 1.6;

    public Truck(double fuelQuantity, double consumption, double tankCapacity) {
        super(fuelQuantity, consumption + AIR_CONSUMPTION_EXTEND, tankCapacity);
    }

    @Override
    public void refueling(double liters) {
        super.refueling(liters * 0.95);
    }

    @Override
    public String toString() {
        return String.format("Truck: %.2f", super.getFuelQuantity());
    }

}
