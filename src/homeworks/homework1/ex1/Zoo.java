package homeworks.homework1.ex1;

import java.util.ArrayList;

public class Zoo {
    int animalsQTY = 3;
    ArrayList<Animal> animals;

    public Zoo() {
        this.animals = new ArrayList<>();
    }

    public <A> void addAnimal(A animal) {
        if (animals.size() < animalsQTY) {
            animals.add((Animal) animal);
        } else {
            System.out.println("Превышена емкость зоопарка");
        }
    }

    public Animal takeAnimal() throws AnimalNotFound {
        if (!animals.isEmpty()) {
            Animal cloneAnimal = animals.get(0);
            cloneAnimal.makeAction();
            animals.remove(0);
            return cloneAnimal;
        } else {
            throw new AnimalNotFound("Ошибка: в зоопарке нет животных!");
        }
    }
}
