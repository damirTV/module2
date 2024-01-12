import homeworks.homework1.ex1.*;
import homeworks.homework1.ex2.ListExample;
import homeworks.homework1.ex3.Item;
import homeworks.homework1.ex3.Storage;
import java.util.ArrayList;
import java.util.List;

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
        List<Item> items = new ArrayList<>(List.of(
                new Item("Кровать"),
                new Item("Телевизор"),
                new Item("Ручка менеджера из офиса Тойоты"),
                new Item("Стул"),
                new Item("Компьютер Юры")));
        Storage storage = new Storage();
        storage.addItems(items);
        System.out.println(storage.listItems());
        System.out.println("Взяли со склада вещь: " + storage.takeItem(2).getName());
        storage.clearAllWithoutLastOne();
        System.out.println("Удаляем все вещи, кроме самой ценной (последней): "
                + storage.takeItem(0).getName());
    }
}
