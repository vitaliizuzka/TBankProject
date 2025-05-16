package task7;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        BigInteger mod = BigInteger.valueOf(998244353);
        int num = 0;
        num = scanner.nextInt();
        int k = 0;
        k = scanner.nextInt();

        int[] numbers = new int[num];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = scanner.nextInt();
        }

        List<Integer> pairs = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                pairs.add(numbers[i]);
                pairs.add(numbers[j]);
            }
        }


        List<Integer> sumPairs = new ArrayList<>();
        for (int i = 0; i < pairs.size(); i = i + 2) {
            sumPairs.add(pairs.get(i) + pairs.get(i + 1));
        }


        // BigInteger bigZero = BigInteger.valueOf(0);
        for (int i = 1; i <= k; i++) {
            BigInteger sum = BigInteger.valueOf(0);
            for (int j = 0; j < sumPairs.size(); j++) {
                sum = sum.add(power(sumPairs.get(j), i));
            }

            System.out.println(sum.remainder(mod));
        }

    }

    public static BigInteger power(int x, int y) {
        BigInteger result = BigInteger.valueOf(x);
        BigInteger bigX = BigInteger.valueOf(x);
        for (int i = 2; i <= y; i++) {
            result = result.multiply(bigX);
        }
        return result;
    }
}


