package vehicle;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Vehicle> vehicleMap = new LinkedHashMap<>();

        String[] carTokens = readTokens(reader);
        String[] truckTokens = readTokens(reader);
        String[] busTokens = readTokens(reader);

        Car car = null;
        Truck truck = null;
        Bus bus = null;
        try {
            car = new Car(Double.parseDouble(carTokens[1]), Double.parseDouble(carTokens[2]), Double.parseDouble(carTokens[3]));
            truck = new Truck(Double.parseDouble(truckTokens[1]), Double.parseDouble(truckTokens[2]), Double.parseDouble(truckTokens[3]));
            bus = new Bus(Double.parseDouble(busTokens[1]), Double.parseDouble(busTokens[2]), Double.parseDouble(busTokens[3]));
        }catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }

        vehicleMap.put("Car", car);
        vehicleMap.put("Truck", truck);
        vehicleMap.put("Bus", bus);

        int numberOfCommands = Integer.parseInt(reader.readLine());

        for (int i = 0; i < numberOfCommands; i++) {
            String[] tokens = reader.readLine().split("\\s+");

            try {
                doTheCommand(tokens, vehicleMap);
            }catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }

        for (Vehicle vehicle : vehicleMap.values()) {
            System.out.println(vehicle);
        }
    }

    public static String[] readTokens (BufferedReader reader) throws Exception {
        return reader.readLine().split("\\s+");
    }

    public static void doTheCommand(String[] tokens, Map<String, Vehicle> vehicleMap) {
        String command = tokens[0];
        String vehicleType = tokens[1];

        switch (command) {
            case "Drive":
                double distance = Double.parseDouble(tokens[2]);
                System.out.println(vehicleMap.get(vehicleType).driving(distance));

                break;
            case "Refuel":
                double liters = Double.parseDouble(tokens[2]);
                vehicleMap.get(vehicleType).refueling(liters);

                break;
                case "DriveEmpty":
                    double distanceForEmpty = Double.parseDouble(tokens[2]);
                    Bus bus = (Bus) vehicleMap.get(vehicleType);
                    System.out.println(bus.drivingEmptyBus(distanceForEmpty));
            break;
        }
    }
}

