package homeworks.homework2;

import homeworks.homework2.ex1.LuggageSpace;
import homeworks.homework2.ex2.Item;
import homeworks.homework2.ex3.Detail;
import java.util.HashMap;
import java.util.Map;

public class Homework2 {
    public static void main(String[] args) {
        //1. Задание: багажное отделение аэропорта
        //Создать класс чемодан, атрибут: номер рейса

        //Создать класс работник. Имеет имя.
        //Имеет функцию кинуть багаж с криком. На вход набор чемоданов.
        //Работник берет один чемодан из набора чемоданов.
        //Печатает на экран: {имя работника}: Мужики, кидаю чемодан {номер рейса чемодана}

        //Создать класс багажное отделение, атрибуты: набор чемоданов, 3 работника.
        //В классе багажное отделения есть функция: прилет самолета. На вход номер рейса.
        //В багажном отделении добавляются 20 чемоданов из этого рейса.
        //
        //В классе багажное отделение есть функция: разгрузить багажное отделение.
        //3 работника по очереди разгружают вещи, в том порядке, в котором происходили прилеты.

        //Создать раннер, в нем багажное отделение. Организовать два прилета SU-077, AO-222.
        //Разгрузить багажное отделение. Сначала должны выйти чемоданы su-077, потом ao-222.

        //2. Задание: Вещей много, бакет один
        //Создать класс Item, атрибут - name
        //Переопределить у Item equals и hashcode так, чтобы при попадании в Hashmap в качестве ключа
        //вещи всегда попадали в один и тот же bucket.
        //При добавлении вещей, они не должны замещать друг друга.
        //Пример: создал 3 вещи: item(Яблоко), item(Банан), item(Апельсин)
        // положил в Map(ключ - значение):
        // item(Яблоко) - 1
        // item(Банан) - 2
        // item(Апельсин) - 3
        //При получении значения по ключу item(Апельсин) получу корректное значение (3)

        //3. Задание: Сломай это немедленно
        //Создать класс Detail, атрибут - name
        //Переопределить у Detail equals и hashcode так, чтобы при попадании в Hashmap в качестве ключа
        //деталь всегда перетирала имеющуюся там деталь.
        // Т.е. если положить Hashmap 3 детали в качестве ключа (число значение):
        // detail(Пила) - 1, detail(Молоток) - 2, detail(отвертка) - 3
        //При попытке печати map на экран: там будет последнее вставленное значение у первой детали
        //деталь ( detail(Пила) - 3 )

        System.out.println("+++ Задание №1 +++");
        LuggageSpace luggageSpace = new LuggageSpace();
        luggageSpace.newPlane("SU-077");
        luggageSpace.newPlane("А0-222");
        luggageSpace.unload();
        System.out.println();

        System.out.println("+++ Задание №2 +++");
        Item item1 = new Item("Яблоко");
        Item item2 = new Item("Банан");
        Item item3 = new Item("Апельсин");
        Map<Item, Integer> items = new HashMap<>();
        items.put(item1, 1);
        items.put(item2, 2);
        items.put(item3, 3);
        System.out.println(items.get(item3));
        System.out.println();

        System.out.println("+++ Задание №3 +++");
        Detail detail1 = new Detail("Пила");
        Detail detail2 = new Detail("Молоток");
        Detail detail3 = new Detail("Отвертка");
        Map<Detail, Integer> details = new HashMap<>();
        details.put(detail1, 1);
        details.put(detail2, 2);
        details.put(detail3, 3);
        for (Detail detail : details.keySet()) {
            System.out.println(detail.getName() + "=" + details.get(detail));
        }
    }
}
