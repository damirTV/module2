import homeworks.homework3.ex1.Feedback;
import homeworks.homework3.ex2.Apple;
import homeworks.homework3.ex2.Apricot;
import homeworks.homework3.ex2.Fruit;
import homeworks.homework3.ex2.Garden;
import homeworks.homework3.ex3.Human;
import homeworks.homework3.ex3.Witching;
import homeworks.homework3.ex4.Burning;
import homeworks.homework3.ex4.Uranium;
import homeworks.homework3.ex4.Wood;
import homeworks.homework3.ex5.Animal;
import homeworks.homework3.ex5.Boat;
import homeworks.homework3.ex5.Ruler;
import java.util.*;
import java.util.function.Supplier;

public class Homework3 {
    public static void main(String[] args) {
        ex1(); // Первое задание
        ex2(); // Второе задание
        ex3(); // Третье задание
        ex4(); // Четвертое задание
        ex5(); // Пятое задание
    }

    /**
     Задание №1: сортировка отзывов
     Создать класс отзыв с полями: id отзыва, текст отзыва, количество лайков,
      дата + время отзыва (LocalDateTime)
      Создать коллекцию, которая хранит уникальные отзывы (уникальность по id),
     В данной коллекции отзывы должны быть отсортированы.
     Создать comparator через лямбда выражение, для сортировки отзывов:
     сначала у кого больше лайков, если лайки совпадают, то сначала идут более новые отзывы

     Пример, отсортированный :
     id, текст, кол-во лайков, дата+время)
     отзыв №1: 1, отличный товар, 200, 25.01.2024 13:37
     отзыв №2: 2, так себе товар, 100, 25.01.2024 16:37
     отзыв №3: 3, плохой товар, 100, 25.01.2024 13:37
     */
    private static void ex1() {
        Set<Feedback> feedbacks = new HashSet<>();
        addFeedbacks(feedbacks); // Добавляем в коллекцию новые фидбэки

        Comparator<Feedback> feedbackComparator = (Feedback f1, Feedback f2) -> {
            if (f2.getLikes() - f1.getLikes() == 0
                    && f2.getDateTime().compareTo(f1.getDateTime()) == 0) {
                return -1;
            }
            if (f2.getLikes() - f1.getLikes() == 0) {
                return f2.getDateTime().compareTo(f1.getDateTime());
            }
            return f2.getLikes() - f1.getLikes();
        };

        Set<Feedback> sortedFeedbacks = new TreeSet<>(feedbackComparator);
        sortedFeedbacks.addAll(feedbacks);
    }

    /**
     * Метод для добавления фидбеков в коллекцию для 1-ого задания
     */
    private static void addFeedbacks(Set<Feedback> feedbacks) {
        Supplier<Integer> randomLikes = () -> (int) (Math.random() * 1000);
        Supplier<String> randomText = () -> switch ((int) (Math.random() * 4)) {
            case (0) -> "Отличный товар!";
            case (1) -> "Всем рекомендую к покупе!";
            case (2) -> "Все понравилось, возьму еще!";
            default -> "Товар пушка!";
        };
        for (int i = 0; i < 10000; i++) {
            feedbacks.add(new Feedback(i, randomText.get(), randomLikes.get()));
        }
    }

    /**
     * Задание №2: Сад
     *  Создать два фрукта: яблоко, абрикос. (Без полей)
     *  Создать функциональный интерфейс сад, который умеет выращивать фрукты.
     *  Метод ничего не принимает.
     *  Создать с помощью лямбд выражений 2 фермы: яблочная, абрикосовая.
     *  Яблочная ферма должна отдавать яблоки(не фрукты!), абрикосовая абрикосы(не фрукты!).
     */
    private static void ex2() {
        Garden<Fruit> appleFarm = Apple::new;
        Garden<Fruit> apricotFarm = Apricot::new;
        System.out.println(appleFarm.growFruit());
        System.out.println(apricotFarm.growFruit());
    }

    /**
     Задание №3: Поиск пары с помощью гадания
     Создать функциональный интерфейс гадание, который на вход принимает аргумент любого типа,
     на выход возвращает да/нет.
     Создать с помощью лямбд выражений:
     ромашку: принимает имя, возвращает да если в имени четное кол-во букв, нет если нечетное
     бабку гадалку: принимает Человека(возраст,рост),
     возвращает да - если возраст + рост больше 210, нет - если меньше или равно
     */
    private static void ex3() {
        Witching<String> chamomile = (String name) -> (name.length() % 2 == 0) ? "Да" : "Нет";
        System.out.println(chamomile.witching("Дамир"));

        Witching<Human> grandMa = (Human human) -> (human.getAge() + human.getHeight() > 210) ? "Да" : "Нет";
        Human human1 = new Human("Вася", 300, 150);
        System.out.println(grandMa.witching(human1));
    }

    /**
     Задание №4: Гори ясно!
     Создать функциональный интерфейс сжигание, ничего не возвращает, принимает аргумент
     любого типа.
     Создать с помощью лямбд выражений:
     атомный реактор: принимает в себя уран, печатает на экран: зеленый свет вокруг!
     костер: принимает в себя дерево, печатает на экран: желто-красный свет вокруг!
     */
    private static void ex4() {
        Uranium uranium = new Uranium();
        Wood wood = new Wood();
        Burning<Uranium> nuclearReactor = (Uranium material) -> System.out.println("Зеленый свет вокруг!");
        Burning<Wood> campfire = (Wood material) -> System.out.println("Желто-красный свет вокруг!");
        nuclearReactor.accept(uranium);
        campfire.accept(wood);
    }

    /**
     Задание №5: универсальная линейка
     Создать функциональный интерфейс линейка: принимает в себя любой тип, возвращает Integer
     Создать с помощью лямбд выражений:
     Измеритель лодок: на вход лодка(длина), возвращает длину лодки
     Измеритель животных: на вход животное(длина тела, длина хвоста),
     возвращает сумму длин тела и хвоста
     */
    private static void ex5() {
        Ruler<Boat> boatMeter = Boat::getLength;
        Boat boat = new Boat(1000);
        System.out.println(boatMeter.accept(boat));

        Ruler<Animal> animalMeter = (Animal animal) -> animal.getLengthBody() + animal.getLengthTail();
        Animal animal = new Animal(100, 200);
        System.out.println(animalMeter.accept(animal));
    }
}


