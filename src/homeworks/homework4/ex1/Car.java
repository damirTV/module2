package homeworks.homework4.ex1;

public class Car {
    private final String number;

    public Car(String textBefore, int number, String textAfter) {
        String numberAsString;
        if (number < 10) {
            numberAsString = "0" + number;
        } else {
            numberAsString = Integer.toString(number);
        }
        this.number = textBefore + numberAsString + textAfter;
    }

    public String getNumber() {
        return number;
    }
}
