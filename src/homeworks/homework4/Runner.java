package homeworks.homework4;

import homeworks.homework4.ex1.Car;
import homeworks.homework4.ex3.Skyscraper;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Runner {
    public static void main(String[] args) {
        ex1();
        ex2();
        ex3();
    }

    /**
     * Задание №1 - Список спец номеров
     * Создать класс машина. У машины есть номер.
     * Создать 50 машин с номерами а0[01-50]ан799 (где [01-50] - это все значения от 01 до 50)
     * Создать 50 машин с номерами к0[01-50]се178
     * Соединить машины в единый стрим
     * Машины, с номерами 04[0-9] - это спец номера (врачи)
     * оставить только те машины, которые обладают спец номерами
     * Получить из машин номера
     * Соединить в единую строку, с разделителем в " ," - самостоятельное изучение
     * ожидаемый финал
     * "a040ан1799, a041ан799, ... , k048се178, k049се178"
     */

    private static void ex1() {
        AtomicInteger counter = new AtomicInteger(0);
        List<Car> group1 = Stream.generate(() -> new Car("а0", counter.addAndGet(1), "ан799"))
                .limit(50).toList();
        counter.set(0);
        List<Car> group2 = Stream.generate(() -> new Car("к0", counter.addAndGet(1), "се178"))
                .limit(50).toList();

        String text = Stream.of(group1, group2)
                .flatMap(List::stream)
                .map(Car::getNumber)
                .filter(number -> number.substring(1, 3).contains("04"))
                .collect(Collectors.joining(", "));
        System.out.println(text);
    }

    /**
     * Задание №2 - Сколько здесь "о" ?
     * Создать набор уникальных слов: "тонь", "тополь", "боль", "рой", "стройка"
     * Внутри одного стрима:
     * Посчитать количество букв "о" в одном слове
     * Посчитать сумму количества букв "о" во всех словах из набора
     * Если буквы "о" есть - напечатать количество букв "о", если нет выкинуть исключение
     * ожидаемый результат:
     * 6
     */

    private static void ex2() {
        Set<String> text = Set.of("тонь", "тополь", "боль", "рой", "стройка");
        System.out.println(text.stream()
                .mapToInt(word -> (int) word.chars().filter(letter -> letter == 'о').count())
                .reduce(Integer::sum)
                .stream().filter(value -> value > 0)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Буква не найдена")));
    }

    /**
     * //Задание №3 - Небоскребы, небоскребы, а я...
     * //Дано: Небоскреб - имя небоскреба, его высота в метрах.
     * //Необходимо создать небоскребы:
     * //1 Всемирный торговый центр 1 - 541м
     * //2 Шанхайская башня - 632м
     * //3	Бурдж-Халифа - 828м
     * //4 Международный финансовый центр Пинань - 599м
     * //5 Абрадж аль-Бейт - 601м
     * //6 Всемирный центр Лотте - 555м
     * <p>
     * //Занести данный список в List! Дважды положить бурдж халифа в лист.
     * //С помощью стримов:
     * //Убрать дубликаты
     * //(РАЗНЫЕ СТРИМЫ)
     * //Вывести только первые три небоскреба.
     * //Вывести самый высокий небоскреб.
     * //Вывести те небоскребы, которые выше километра.
     * //Если выше нет, то вывести на экран: небоскреба выше километра - нет.
     */

    private static void ex3() {
        Skyscraper skyscraper = new Skyscraper("Бурдж-Халифа", 632);
        List<Skyscraper> skyscrapers = List.of(
                new Skyscraper("Всемирный торговый центр", 541),
                new Skyscraper("Шанхайская башня", 632),
                skyscraper, skyscraper,
                new Skyscraper("Международный финансовый центр Пинань", 599),
                new Skyscraper("Абрадж аль-Бейт", 601),
                new Skyscraper("Всемирный центр Лотте", 555));

        //Убрать дубликаты
        List<Skyscraper> distinctList = skyscrapers.stream().distinct().toList();

        //Вывести первые три небоскреба
        skyscrapers.stream().limit(3).forEach(value -> System.out.println(value.getName()));

        System.out.println();

        //Вывести самый высокий небоскреб
        System.out.println(skyscrapers.stream().
                max(Comparator.comparing(Skyscraper::getHeight)).
                get().getName());

        System.out.println();

        //Вывести те небоскребы, которые выше километра
        System.out.println(skyscrapers.stream()
                .filter(value -> value.getHeight() > 1000)
                .map(Skyscraper::getName)
                .reduce((skyscraper1, skyscraper2) -> skyscraper1 + ", " + skyscraper2)
                .orElse("Небоскреба выше километра - нет"));
    }
}




