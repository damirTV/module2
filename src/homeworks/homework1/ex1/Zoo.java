package homeworks.homework1.ex1;

import homeworks.homework1.ex1.animals.Animal;

public class Zoo<T extends Animal, D extends Animal, B extends Animal> {
    private T tiger;
    private D dog;
    private B bird;

    public Zoo(T tiger, D dog, B bird) {
        this.tiger = tiger;
        this.dog = dog;
        this.bird = bird;
    }

    public T getTiger() {
        return tiger;
    }

    public D getDog() {
        return dog;
    }

    public B getBird() {
        return bird;
    }
}
