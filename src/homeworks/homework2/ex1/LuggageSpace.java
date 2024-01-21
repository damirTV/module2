package homeworks.homework2.ex1;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class LuggageSpace {
    Queue<Suitcase> suitcases = new LinkedList<>();
    Set<Worker> workers = new HashSet<>();

    public LuggageSpace() {
        workers.add(new Worker("Вася"));
        workers.add(new Worker("Петя"));
        workers.add(new Worker("Ваня"));
    }

    public void newPlane(String flightNumber) {
        for (int i = 0; i <= 19; i++) {
            suitcases.add(new Suitcase(flightNumber));
        }
    }

    public void unload() {
        while (!suitcases.isEmpty()) {
            for (Worker worker : workers) {
                worker.throwSuitcase(suitcases);
            }
        }
    }
}
