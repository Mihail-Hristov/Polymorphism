package vehicle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] carTokens = reader.readLine().split("\\s+");
        String[] truckTokens = reader.readLine().split("\\s+");
        String[] busTokens = reader.readLine().split("\\s+");

        Vehicle car = null;
        Vehicle truck = null;
        Vehicle bus = null;

        try {
            car = new Car(Double.parseDouble(carTokens[1]), Double.parseDouble(carTokens[2]), Double.parseDouble(carTokens[3]));
            truck = new Truck(Double.parseDouble(truckTokens[1]), Double.parseDouble(truckTokens[2]), Double.parseDouble(truckTokens[3]));
            bus = new Bus(Double.parseDouble(busTokens[1]), Double.parseDouble(busTokens[2]), Double.parseDouble(busTokens[3]));
        }catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }

        int numberOfCommands = Integer.parseInt(reader.readLine());

        for (int i = 0; i < numberOfCommands; i++) {
            String[] tokens = reader.readLine().split("\\s+");

            String command = tokens[0];
            String vehicleType = tokens[1];

            try {
                switch (command) {
                    case "Drive":
                        double distance = Double.parseDouble(tokens[2]);
                        if (vehicleType.equals("Car")) {
                            car.driving(distance);
                        } else if (vehicleType.equals("Truck")) {
                            truck.driving(distance);
                        }
                        break;
                    case "Refuel":
                        double liters = Double.parseDouble(tokens[2]);
                        if (vehicleType.equals("Car")) {
                            car.refueling(liters);
                        } else if (vehicleType.equals("Truck")) {
                            truck.refueling(liters);
                        }
                        break;
                }
            }catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }

        System.out.println(car);
        System.out.println(truck);

    }
}

