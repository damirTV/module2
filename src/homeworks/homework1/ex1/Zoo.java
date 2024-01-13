package homeworks.homework1.ex1;

import java.util.ArrayList;

public class Zoo<A extends Animal> {

    ArrayList<A> animals = new ArrayList<>();

    public void addAnimal(A animal) {
        animals.add(animal);
    }

    public A takeAnimal() throws AnimalNotFound {
        if (!animals.isEmpty()) {
            A cloneAnimal = animals.get(0);
            animals.remove(0);
            return cloneAnimal;
        } else {
            throw new AnimalNotFound("Ошибка: в зоопарке нет животных!");
        }
    }
}
