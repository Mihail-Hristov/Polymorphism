package vehicle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] carTokens = reader.readLine().split("\\s+");
        String[] truckTokens = reader.readLine().split("\\s+");

        Vehicle car = new Car(Double.parseDouble(carTokens[1]), Double.parseDouble(carTokens[2]));
        Vehicle truck = new Truck(Double.parseDouble(truckTokens[1]), Double.parseDouble(truckTokens[2]));

        int numberOfCommands = Integer.parseInt(reader.readLine());

        for (int i = 0; i < numberOfCommands; i++) {
            String[] tokens = reader.readLine().split("\\s+");

            String command = tokens[0];
            String vehicleType = tokens[1];

            switch (command) {
                case "Drive":
                    double distance = Double.parseDouble(tokens[2]);
                    if (vehicleType.equals("Car")) {
                        car.driving(distance);
                    }else if (vehicleType.equals("Truck")) {
                        truck.driving(distance);
                    }
                    break;
                case "Refuel":
                    double liters = Double.parseDouble(tokens[2]);
                    if (vehicleType.equals("Car")) {
                        car.refueling(liters);
                    }else if (vehicleType.equals("Truck")) {
                        truck.refueling(liters);
                    }
                    break;
            }
        }

        System.out.println(car);
        System.out.println(truck);

    }
}
