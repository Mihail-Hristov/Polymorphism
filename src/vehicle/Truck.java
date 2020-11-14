package vehicle;

public class Truck extends Vehicle{
    private static final double AIR_CONSUMPTION_EXTEND = 1.6;

    public Truck(double fuelQuantity, double consumption, double tankCapacity) {
        super(fuelQuantity, consumption + AIR_CONSUMPTION_EXTEND, tankCapacity);
    }

    @Override
    public void refueling(double liters) {
        super.refueling(liters * 0.95);
    }

}
