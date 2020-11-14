package wildFarm;

public abstract class Felime extends Mammal{

    public Felime(String animalName, String animalType, Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
    }

    public abstract void makeSound();

    public abstract void eat(Food food);
}
