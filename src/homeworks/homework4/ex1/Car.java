package homeworks.homework4.ex1;

public class Car {
    private final String number;

    public Car(String textBefore, int number, String textAfter) {
        checkErrors(number);
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

    private void checkErrors(int number) {
        if (number < 0) {
            throw new RuntimeException("Число внутри номера не может быть отрицательным");
        }
        if (number > 99) {
            throw new RuntimeException("Число внутри номера должно быть двухзначным");
        }
    }
}
