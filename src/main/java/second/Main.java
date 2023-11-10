package second;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите имя: ");
        String name = scanner.nextLine();
        System.out.print("Количество яблок: ");
        int apples = scanner.nextInt();
        wordDeclensions(name, apples);
    }

    public static void wordDeclensions(String name, int apples) {
        String wordDeclensions = null;
       if ((apples % 10 == 1) && (apples != 11))  {
            wordDeclensions = " яблоко";
        } else {
            if (((apples % 10 == 2) || (apples % 10 == 3) || (apples % 10 == 4)) && (apples / 10 != 1)) {
                wordDeclensions = " яблока";
            } else {
                wordDeclensions = " яблок";
            }
        }
        System.out.println(name + " хранит " + apples + wordDeclensions);
    }
}
