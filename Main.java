package bullscows;

import java.util.*;


public class Main {
    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();
    static boolean stop;
    static String num1 = "";
    static List<Character> randomList = new ArrayList<>(List.of('0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u',
            'v', 'w', 'x', 'y', 'z'));
    static List<String> list = new ArrayList<>(List.of("*", "**", "***", "****", "*****", "******", "*******",
            "********" +  "*********" + "**********"));

    static boolean stop2;
    static String num = "";
    static int bulls = 0;
    static int cows = 0;
    public static void main(String[] args) {
        Main main = new Main();
        main.createNumberV2();

    }
    public void constructor(String number) {
        stop = true;
        while (stop) {
            cows = 0;
            bulls = 0;
            String inPutNumber = scanner.nextLine();
            for (int i = 0; i < inPutNumber.length(); i++) {
                if (inPutNumber.contains(String.valueOf(number.charAt(i)))) {
                    cows++;
                }
                if (number.charAt(i) == inPutNumber.charAt(i)) {
                    cows--;
                    bulls++;
                }
            }
            if (inPutNumber.equals(number)) {
                System.out.println("Grade: " + num + " bulls");
                System.out.println("Congratulations! You guessed the secret code.");
                stop = false;
            } else if (bulls == 0 && cows == 0) {
                System.out.println("Grade: None.");
            } else if (bulls <= 0) {
                System.out.println("Grade: " + cows + " cow(s). ");
            } else if (cows <= 0) {
                System.out.println("Grade: " + bulls + " bull(s). ");
            } else {
                System.out.println("Grade: " + bulls + "bull(s). " + "and " + cows + " cow(s). ");
            }
        }
    }
    public void createNumberV2() {
        System.out.println("Please, enter the secret code's length:");
        num = scanner.next();
        try {
            int numb = Integer.parseInt(num);
        } catch (NumberFormatException e) {
            System.out.println("Error: \"" + num + "\" invalid number.");
            System.exit(0);
        }
        System.out.println("Input the number of possible symbols in the code:");
        num1 = scanner.next();
        if (Integer.parseInt(num) > Integer.parseInt(num1)) {
            System.out.println("Error: it's not possible to generate a code with a length of " + num1 + " with " + num + " unique symbols.");
            System.exit(0);
        } else if (Integer.parseInt(num) > 10) {
            System.out.println("System.out.println(\"Error: can't generate a secret number with a length of \" +\n" +
                    "                    num + \" because there aren't enough unique digits.\");");
            System.exit(0);
        } else if(Integer.parseInt(num1) > 0 && Integer.parseInt(num1) <= 10) {
            System.out.println("The secret is prepared: " + list.get(Integer.parseInt(num)) + " (0-"+ randomList.get(Integer.parseInt(num1) - 1) + ").");
            System.out.println("Okay, let's start a game!");
        } else if (Integer.parseInt(num1) > 10 && Integer.parseInt(num1) <= 36) {
            System.out.println("The secret is prepared: " + list.get(Integer.parseInt(num)) + " (0-9, a-" + randomList.get(Integer.parseInt(num1) - 1) +").");
            System.out.println("Okay, let's start a game!");
        }  else {
            System.out.println("Error: maximum number of possible symbols in the code is 36 (0-9, a-z).");
            System.exit(0);
        }
        if (Integer.parseInt(num) > 0 && Integer.parseInt(num) <= 10) {
            String m = randomGenerator(Integer.parseInt(num));
            constructor(m);
        }
        else {
            System.out.println("Error: can't generate a secret number with a length of " +
                    num + " because there aren't enough unique digits.");
        }
    }
    public static String randomGenerator(int length) {
        randomList = new ArrayList<>(List.of('0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u',
                'v', 'w', 'x', 'y', 'z'));
        StringBuilder result = new StringBuilder();
        for (var ch: randomList.subList(0, length)) {
            result.append(ch);
        } return result.toString();
    }
}