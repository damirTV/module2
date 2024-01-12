package homeworks.homework1.ex3;

import java.util.ArrayList;
import java.util.List;

public class Storage {
    List<Item> items = new ArrayList<>();

    public Storage() {
    }

    public void addItems(List<Item> newItems) {
        items.addAll(newItems);
    }

    public List<Item> listItems() {
        List<Item> evenNumbersItems = new ArrayList<>();
        for (int i = 0; i < items.size(); i++) {
            if (i % 2 == 0) {
                evenNumbersItems.add(items.get(i));
            }
        }
        return evenNumbersItems;
    }

    public Item takeItem(int item) {
        Item cloneItem = items.get(item);
        items.remove(item);
        return cloneItem;
    }

    public void clearAllWithoutLastOne() {
        Item lastItem = items.get(items.size() - 1);
        items.clear();
        items.add(lastItem);
    }
}
