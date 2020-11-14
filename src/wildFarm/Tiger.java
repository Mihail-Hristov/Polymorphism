package wildFarm;

import java.text.DecimalFormat;

public class Tiger extends Felime{
    private String livingRegion;

    public Tiger(String animalName, String animalType, Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("ROAAR!!!");
    }

    @Override
    public void eat(Food food) {
        String className = food.getClass().getSimpleName();
        if (className.equals("Vegetable")) {
            throw new IllegalStateException(String.format("Tigers are not eating that type of food!"));
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
