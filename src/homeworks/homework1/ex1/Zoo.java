package homeworks.homework1.ex1;

import java.util.ArrayList;

public class Zoo {
    ArrayList<Animal> animals = new ArrayList<>(3);

    public Zoo() {
    }

    public <A> void addAnimal(A animal) {
        if (animals.size() <= 2) {
            animals.add((Animal) animal);
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
