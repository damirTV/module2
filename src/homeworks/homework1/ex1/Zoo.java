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
        if (tiger != null) {
            T clone = tiger;
            tiger = null;
            return clone;
        } else {
            throw new RuntimeException("Ошибка: животное не найдено");
        }
    }

    public D getDog() {
        if (dog != null) {
            D clone = dog;
            dog = null;
            return clone;
        } else {
            throw new RuntimeException("Ошибка: животное не найдено");
        }
    }

    public B getBird() {
        if (bird != null) {
            B clone = bird;
            bird = null;
            return clone;
        } else {
        throw new RuntimeException("Ошибка: животное не найдено");
        }
    }
}
