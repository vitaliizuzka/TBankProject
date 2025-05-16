package task5;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        long s = sc.nextLong();

        long[] segments = new long[num];

        for (int i = 0; i < num; i++) {
            segments[i] = sc.nextLong();
        }

        long result = 0;
        long sum = 0;
        int partCounter = 0;

        for (int i = 0; i < num; i++) {
            sum = 0;
            partCounter = 1;
            for (int j = i; j < num; j++) {
                if (sum + segments[j] > s) {
                    partCounter++;
                    sum = segments[j];
                } else {
                    sum += segments[j];
                }
                result = result + partCounter;
            }
        }

        System.out.println(result);
    }
}