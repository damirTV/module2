package homeworks.homework3.ex2;

@FunctionalInterface
public interface Garden<T extends Fruit> {
    T growFruit();
}
