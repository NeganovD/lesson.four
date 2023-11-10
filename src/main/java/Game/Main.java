package Game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Integer> initGameList = gameList();
        System.out.println("***********************  Игра начинается  ***********************");
        System.out.println("*Правила: Найти два одинаковых числа или, которые в сумме дают 9*\n" +
                "   *За каждое правильное совпадение +1 балл к результату*\n" +
                "*****************************************************************\n");
        System.out.println("Даны числа " + initGameList);
        playGame(initGameList);

    }

    static void playGame(List<Integer> gameList) {
        int score = 0;
        while (true) {
            if ((checkGameListEquals(gameList) == false) && (checkGameListSumNine(gameList) == false)) {
                System.out.println("\n*****Игра окончена!***** \n" +
                        "Ваш итоговый результат: " + score);
                break;
            }
            int firstNumber = enteredNumber();
            int secondNumber = enteredNumber();
            findEqualsOfRules(gameList, firstNumber, secondNumber);
            score++;
            System.out.println("Ваш результат: " + score);
            System.out.println("Игровое поле " + gameList);
        }
    }

    static int findEqualsOfRules(List<Integer> gameList, int firstNumber, int secondNumber) {
        int score = 0;
        if ((gameList.contains(gameList.get(firstNumber))) && gameList.contains(gameList.get(secondNumber))) {
            if (gameList.get(firstNumber) == gameList.get(secondNumber)) {
                System.out.println("Вы нашли два одинаковых числа");
                gameList.remove(firstNumber);
                gameList.remove(secondNumber - 1);
                System.out.println(gameList);
                score++;
            } else {
                if (gameList.get(firstNumber) + gameList.get(secondNumber) == 9) {
                    System.out.println("Вы нашли два числа, сумма которых равна 9   ");
                    gameList.remove(firstNumber);
                    gameList.remove(secondNumber - 1);
                    System.out.println(gameList);
                    score++;
                } else {
                    System.out.println("нет совпадения");
                    System.out.println(gameList);
                }
            }
        }
        return score;
    }

    static int enteredNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите индекс числа: ");
        int num = scanner.nextInt();
        return num;
    }

    static List<Integer> gameList() { //инициализация поля
        Random random = new Random();
        List<Integer> trashList = new ArrayList<>();
        for (int i = 0; i <= 9; i++) {
            trashList.add(random.nextInt(10));
        }
        while (true) {
            if (checkGameListEquals(trashList) != true || checkGameListSumNine(trashList) != true) {
                gameList();
            }
            return trashList;
        }
    }

    static boolean checkGameListEquals(List<Integer> gameList) {  //проверка на совпадение
        boolean result = false;
        for (int i = 0; i < (gameList.size() - 1); i++) {
            if (gameList.get(i).equals(gameList.get(i + 1))) {
                result = true;
                break;
            }
        }
        return result;
    }
    static boolean checkGameListSumNine(List<Integer> gameList) { //проверка на суммы
        boolean result = false;
        for (int i = 0; i < (gameList.size() - 1); i++) {
            if (gameList.get(i) + (gameList.get(i + 1)) == 9) {
                result = true;
                break;
            }
        }
        return result;
    }
}