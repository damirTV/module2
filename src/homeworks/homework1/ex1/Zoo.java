package homeworks.homework1.ex1;

public class Zoo<A extends Animal> {
    private A animal;


    public void addAnimal(A animal) {
        this.animal = animal;
    }

    public A getAnimal() {
        return animal;
    }

}
