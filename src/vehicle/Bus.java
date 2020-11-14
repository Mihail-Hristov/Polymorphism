package vehicle;

public class Bus extends Vehicle {
    private static final double AIR_CONSUMPTION_EXTEND = 1.4;

    public Bus (double fuelQuantity, double consumption, double tankCapacity) {
        super(fuelQuantity, consumption + AIR_CONSUMPTION_EXTEND, tankCapacity);
    }

    public String drivingEmptyBus(double distance) {

        return super.doWithLowerConsumption(AIR_CONSUMPTION_EXTEND, () -> super.driving(distance));
    }

}
