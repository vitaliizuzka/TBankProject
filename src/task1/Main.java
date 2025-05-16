package task1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        int x = 0;
        String answer = null;
        text = text.toUpperCase();
        answer = text.charAt(0) == 'R' || (text.charAt(1) == 'R' && text.charAt(2) == 'M') ? "Yes" : "No";
        System.out.println(answer);

    }
}
