package homeworks.homework1.ex1;

import java.util.ArrayList;
import java.util.List;

public class Zoo {
    int animalsQTY = 3;
    ArrayList<Animal> animals;

    public Zoo() {
        this.animals = new ArrayList<>();
    }

    public <A> void addAnimal(A animal) {
        if (animals.size() <= animalsQTY) {
            animals.add((Animal) animal);
        } else {
            System.out.println("Превышена емкость зоопарка");
        }
    }

    public <A> Animal takeAnimal(A animal) throws AnimalNotFound {
        if (animals.contains((Animal) animal)) {
            animals.remove(animal);
            ((Animal) animal).makeAction();
            return (Animal) animal;
        } else {
            throw new AnimalNotFound("Ошибка: такого животного не найдено!");
        }
    }
}
