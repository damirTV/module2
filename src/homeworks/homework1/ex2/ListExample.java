package homeworks.homework1.ex2;

import java.util.ArrayList;
import java.util.List;

public class ListExample {
    public ListExample() {
        List<Integer> listFirst = new ArrayList<>(List.of(new Integer[]{5, 2, 4}));
        List<Integer> listSecond = new ArrayList<>(List.of(new Integer[]{7, 10}));
        List<Integer> listFinal = new ArrayList<>();
        listFinal.addAll(listFirst);
        listFinal.addAll(listSecond);
        listFinal.remove(3);
        System.out.println("Индекса числа 10: " + listFinal.indexOf(10));
    }
}
