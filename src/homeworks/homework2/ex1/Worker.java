package homeworks.homework2.ex1;

import java.util.Queue;

public class Worker {
    private final String name;

    public Worker(String name) {
        this.name = name;
    }

    public void throwSuitcase(Queue<Suitcase> suitcases) {
        if (suitcases.isEmpty()) {
            return;
        }
        System.out.printf("{%s}: Мужики, кидаю чемодан {%s}\n",
                    name, suitcases.poll().getFlightNumber());
    }
}
