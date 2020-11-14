package vehicle;

public class Bus extends Vehicle {
    private static final double AIR_CONSUMPTION_EXTEND = 1.4;

    public Bus (double fuelQuantity, double consumption, double tankCapacity) {
        super(fuelQuantity, consumption + AIR_CONSUMPTION_EXTEND, tankCapacity);
    }

    public void drivingEmptyBus(double distance) {
        super.setConsumption(getConsumption() - AIR_CONSUMPTION_EXTEND);
        System.out.println(driving(distance));
        super.setConsumption(getConsumption() + AIR_CONSUMPTION_EXTEND);
    }


    @Override
    public String toString() {
        return String.format("Bus: %.2f", super.getFuelQuantity());
    }
}
