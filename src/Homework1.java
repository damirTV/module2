import HomeworkOne.ex1.*;
import HomeworkOne.ex2.ListExample;

public class Homework1 {
    public static void main(String[] args) {
        System.out.println("\n+++Домашнее задание №1+++");
        Zoo zoo = new Zoo();
        Tiger tiger = new Tiger();
        zoo.addAnimal(tiger);
        Dog dog = new Dog();
        zoo.addAnimal(dog);
        Bird bird = new Bird();
        zoo.addAnimal(bird);
        try {
            System.out.println(zoo.takeAnimal(tiger));
            System.out.println(zoo.takeAnimal(tiger));
        } catch (AnimalNotFound e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n+++Домашнее задание №2+++");
        new ListExample();

        System.out.println("\n+++Домашнее задание №3+++");
    }
}
