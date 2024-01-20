package homeworks.homework2.ex1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LuggageSpace {
    List<Suitcase> suitcaseList = new ArrayList<>();
    Set<Worker> workers = new HashSet<>();

    public LuggageSpace() {
        workers.add(new Worker("Вася"));
        workers.add(new Worker("Петя"));
        workers.add(new Worker("Ваня"));
    }

    public void newPlane(String flightNumber) {
        for (int i = 0; i <= 20; i++) {
            suitcaseList.add(new Suitcase(flightNumber));
        }
    }

    public void unload() {
        for (Worker worker : workers) {
            worker.throwSuitcase(suitcaseList);
        }
    }
}
