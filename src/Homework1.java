import homeworks.homework1.ex1.*;
import homeworks.homework1.ex1.animals.Bird;
import homeworks.homework1.ex1.animals.Dog;
import homeworks.homework1.ex1.animals.Tiger;
import homeworks.homework1.ex2.ListExample;
import homeworks.homework1.ex3.Item;
import homeworks.homework1.ex3.Storage;
import java.util.ArrayList;
import java.util.List;

public class Homework1 {
    public static void main(String[] args) {
        System.out.println("\n+++Домашнее задание №1+++");
        Tiger tiger = new Tiger();
        Dog dog = new Dog();
        Bird bird = new Bird();
        Zoo<Tiger, Dog, Bird> zoo = new Zoo<>(tiger, dog, bird);
        Tiger tiger1 = zoo.getTiger();
        tiger1.action();

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
