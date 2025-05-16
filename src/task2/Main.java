package task2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int numDays = 0;

        numDays = scanner.nextInt();
        long[] amounts = new long[numDays];

        for (int i = 0; i < amounts.length; i++) {
            amounts[i] = scanner.nextLong();
        }

        long maxPrice = 0;
        long flowerPrice = 0;

        int minPrice = (int) (Math.pow(2, 0) + Math.pow(2, 1) + Math.pow(2, 2));

        for (int i = 0; i < amounts.length; i++) {
            maxPrice = 0;
            if (amounts[i] < minPrice) {
                System.out.println(-1);
            } else {
                flowerPrice = maxPriceOneFlower(amounts[i] - 3);
                amounts[i] = amounts[i] - flowerPrice;
                maxPrice = maxPrice + flowerPrice;
                flowerPrice = maxPriceOneFlower(amounts[i] - 1);
                amounts[i] = amounts[i] - flowerPrice;
                maxPrice = maxPrice + flowerPrice;
                flowerPrice = maxPriceOneFlower(amounts[i]);
                maxPrice = maxPrice + flowerPrice;
                System.out.println(maxPrice);
            }
        }


    }
    public static long maxPriceOneFlower(long amount) {
        long result = 1;
        while (amount != 1) {
            amount = amount / 2;
            result = result * 2;
        }
        return result;
    }
}
