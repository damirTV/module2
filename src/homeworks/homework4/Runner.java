package homeworks.homework4;

import homeworks.homework4.ex1.Car;

import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Runner {
    public static void main(String[] args) {
        ex1();
        ex2();
        ex3();
    }

    /**
    Задание №1 - Список спец номеров
    Создать класс машина. У машины есть номер.
    Создать 50 машин с номерами а0[01-50]ан799 (где [01-50] - это все значения от 01 до 50)
    Создать 50 машин с номерами к0[01-50]се178
    Соединить машины в единый стрим
    Машины, с номерами 04[0-9] - это спец номера (врачи)
    оставить только те машины, которые обладают спец номерами
    Получить из машин номера
    Соединить в единую строку, с разделителем в " ," - самостоятельное изучение
    ожидаемый финал
    "a040ан1799, a041ан799, ... , k048се178, k049се178"
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
    Задание №2 - Сколько здесь "о" ?
    Создать набор уникальных слов: "тонь", "тополь", "боль", "рой", "стройка"
    Внутри одного стрима:
    Посчитать количество букв "о" в одном слове
    Посчитать сумму количества букв "о" во всех словах из набора
    Если буквы "о" есть - напечатать количество букв "о", если нет выкинуть исключение
    ожидаемый результат:
     6
     */

    private static void ex2() {
        Set<String> text = Set.of("тонь", "тополь", "боль", "рой", "стройка");

       /*
        text.forEach(word -> word.chars()
                .mapToObj(letter -> (char)letter)
                .filter(x -> x.toString().equals("о"))
                .forEach(System.out::println));
        System.out.println("Вариант №2");

        int count2 = 0;
        for (String word : text) {
            int counter = 0;
            for(char ch : word.toCharArray()) {
                if (ch == 'о') {
                    counter++;
                }
            }
            System.out.println("Слово: " + word + ". Кол-во букв О: " + counter);
            count2 = count2 + counter;
        }
        System.out.println("Всего букв О: " + count2);
*/
        AtomicLong count = new AtomicLong(0);
        text.forEach(word -> {
            long counter = word.chars().filter(ch -> ch == 'о').count();
            count.addAndGet(counter);
        });
        check(count);
    }

    private static void check(AtomicLong count) {
        if (count.get() > 0) {
         System.out.println("Всего букв 'о': " + count);
      } else {
          throw new RuntimeException("Буква 'о' не найдена");
      }
    }


    /**
    //Задание №3 - Небоскребы, небоскребы, а я...
    //Дано: Небоскреб - имя небоскреба, его высота в метрах.
    //Необходимо создать небоскребы:
    //1 Всемирный торговый центр 1 - 541м
    //2 Шанхайская башня - 632м
    //3	Бурдж-Халифа - 828м
    //4 Международный финансовый центр Пинань - 599м
    //5 Абрадж аль-Бейт - 601м
    //6 Всемирный центр Лотте - 555м

    //Занести данный список в List! Дважды положить бурдж халифа в лист.
    //С помощью стримов:
    //Убрать дубликаты
    //(РАЗНЫЕ СТРИМЫ)
    //Вывести только первые три небоскреба.
    //Вывести самый высокий небоскреб.
    //Вывести те небоскребы, которые выше километра.
    //Если выше нет, то вывести на экран: небоскреба выше километра - нет.
     */

    private static void ex3() {

    }
}
