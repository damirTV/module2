package homeworks.homework2.ex1;

import java.util.List;

public class Worker {
    private final String name;

    public Worker(String name) {
        this.name = name;
    }

    public void throwSuitcase(List<Suitcase> suitcaseList) {
        for (Suitcase suitcase : suitcaseList) {
            System.out.printf("\n{%s}: Мужики, кидаю чемодан {%s}",
                    name, suitcase.getFlightNumber());
        }
    }
}
