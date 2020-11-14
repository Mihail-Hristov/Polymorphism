package vehicle;

public class Car extends Vehicle {
    private static final double AIR_CONSUMPTION_EXTEND = 0.9;

    public Car(double fuelQuantity, double consumption, double tankCapacity) {
        super(fuelQuantity, consumption + AIR_CONSUMPTION_EXTEND, tankCapacity);
    }


}
