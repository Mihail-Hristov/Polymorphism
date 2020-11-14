package wildFarm;

import java.text.DecimalFormat;

public class Mouse extends Mammal{

    public Mouse(String animalName, String animalType, Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("SQUEEEAAAK!");
    }

    @Override
    public void eat(Food food) {
        String className = food.getClass().getSimpleName();
        if (className.equals("Meat")) {
            throw new IllegalStateException(String.format("Mice are not eating that type of food!"));
        }

        this.setFoodEaten(food.getQuantity());
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("0.##");
        return String.format("%s[%s, %s, %s, %d]",
                this.getAnimalType(),
                this.getAnimalName(),
                df.format(this.getAnimalWeight()),
                this.getLivingRegion(),
                this.getFoodEaten());
    }

}
