package wildFarm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader((new InputStreamReader(System.in)));

        String input = reader.readLine();

        List<Mammal> animals = new ArrayList<>();

        while (!"End".equals(input)) {
            String[] animalTokens = input.split("\\s+");
            String[] foodTokens = reader.readLine().split("\\s+");

            Mammal currentAnimal = createAnimal(animalTokens);
            Food food = createFood(foodTokens);

            currentAnimal.makeSound();
            try {
                currentAnimal.eat(food);
            }catch (IllegalStateException ex) {
                System.out.println(ex.getMessage());
            }

            animals.add(currentAnimal);

            input = reader.readLine();
        }

        for (Mammal animal : animals) {
            System.out.println(animal);
        }
    }

    public static Mammal createAnimal(String[] tokens) {
        Mammal animal = null;

        String animalType = tokens[0];
        String animalName = tokens[1];
        double animalWeight = Double.parseDouble(tokens[2]);
        String animalLivingRegion = tokens[3];

        switch (animalType) {
            case "Mouse":
                animal = new Mouse(animalName, animalType, animalWeight, animalLivingRegion);

                break;
            case "Zebra":
                animal = new Zebra(animalName, animalType, animalWeight, animalLivingRegion);

                break;
            case "Cat":
                String catBreed = tokens[4];
                animal = new Cat(animalName, animalType, animalWeight, animalLivingRegion, catBreed);

                break;
            case "Tiger":
                animal = new Tiger(animalName, animalType, animalWeight, animalLivingRegion);

                break;
        }

        return animal;
    }

    public static Food createFood(String[] tokens) {
        Food food = null;
        String foodType = tokens[0];
        int quantity = Integer.parseInt(tokens[1]);

        switch (foodType) {
            case "Vegetable":
                food = new Vegetable(quantity);

                break;
            case "Meat":
                food = new Meat(quantity);

                break;
        }

        return food;
    }
}
