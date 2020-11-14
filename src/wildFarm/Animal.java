package wildFarm;

public abstract class Animal {
    private String animalName;

    private String animalType;
    private Double animalWeight;
    private int foodEaten;
    protected Animal(String animalName, String animalType, Double animalWeight) {
        this.animalName = animalName;
        this.animalType = animalType;
        this.animalWeight = animalWeight;
        this.foodEaten = 0;
    }

    public String getAnimalName() {
        return this.animalName;
    }

    public String getAnimalType() {
        return this.animalType;
    }

    public Double getAnimalWeight() {
        return this.animalWeight;
    }

    public int getFoodEaten() {
        return this.foodEaten;
    }

    protected void setFoodEaten(int foodEaten) {
        this.foodEaten += foodEaten;
    }

    public abstract void makeSound();
    public abstract void eat(Food food);
}
