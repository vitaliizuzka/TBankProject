package task6;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int num = 0;
        num = scanner.nextInt();

        int[] x = new int[num];
        int[] y = new int[num];

        for (int i = 0; i < num; i++) {
            x[i] = scanner.nextInt();
            y[i] = scanner.nextInt();
        }

        int maxPointLine = 0;
        int pointLineCounter = 0;

        for (int i = 0; i < num; i++) {
            for (int j = i + 1; j < num; j++) {
                pointLineCounter = 0;
                for (int k = 0; k < num; k++) {
                    if ((long)(x[k] - x[i]) * (y[j] - y[i]) == (long) (y[k] - y[i]) * (x[j] - x[i])) {
                        pointLineCounter++;
                    }
                }
                maxPointLine = Math.max(maxPointLine, pointLineCounter);

            }
        }
        int result = 0;
        result = maxPointLine <= 2 * num / 3 ? num / 3 : num - maxPointLine;
        System.out.println(result);

    }
}
