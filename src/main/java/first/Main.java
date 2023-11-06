package first;

public class Main {
    public static void main(String[] args) {
        int number = -70;
        System.out.println(result(number));
    }
    public static String result(int number) {
        return (number > 0) ? ((number % 7 < 4) ? "positive-m" : "positive-p") : ((number == 0) ? "zero" : (number % 7 > -4) ? "negative-m" : "negative-p");
    }

}
