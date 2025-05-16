package task4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int num = 0, x = 0, y = 0, z = 0;
        num = scanner.nextInt();
        x = scanner.nextInt();
        y = scanner.nextInt();
        z = scanner.nextInt();

        long[] numbers = new long[num];
        for (int i = 0; i < num; i++) {
            numbers[i] = scanner.nextLong();
        }

        long nokXY = nok(x, y);
        long nokYZ = nok(y, z);
        long nokXZ = nok(x, z);
        long nokXYZ = nok(nokXY, z);

        long deficitX = 0, deficitY = 0, deficitZ = 0, deficitXY = 0, deficitYZ = 0, deficitXZ = 0, deficitXYZ = 0;
        long minDeficitX = 0, minDeficitY = 0, minDeficitZ = 0, minDeficitXY = 0, minDeficitYZ = 0, minDeficitXZ = 0, minDeficitXYZ = 0;
        minDeficitX = minDeficitY = minDeficitZ = minDeficitXY = minDeficitYZ = minDeficitXZ = minDeficitXYZ = Long.MAX_VALUE;

        for (int i = 0; i < numbers.length; i++) {

            deficitX = deficit(numbers[i], x);
            deficitY = deficit(numbers[i], y);
            deficitZ = deficit(numbers[i], z);
            deficitXY = deficit(numbers[i], nokXY);
            deficitYZ = deficit(numbers[i], nokYZ);
            deficitXZ = deficit(numbers[i], nokXZ);
            deficitXYZ = deficit(numbers[i], nokXYZ);

            minDeficitX = Math.min(minDeficitX, deficitX);
            minDeficitY = Math.min(minDeficitY, deficitY);
            minDeficitZ = Math.min(minDeficitZ, deficitZ);
            minDeficitXY = Math.min(minDeficitXY, deficitXY);
            minDeficitYZ = Math.min(minDeficitYZ, deficitYZ);
            minDeficitXZ = Math.min(minDeficitXZ, deficitXZ);
            minDeficitXYZ = Math.min(minDeficitXYZ, deficitXYZ);

        }

        long minDif = minDeficitXYZ;
        minDif = Math.min(minDif, minDeficitXY + minDeficitZ);
        minDif = Math.min(minDif, minDeficitXZ + minDeficitY);
        minDif = Math.min(minDif, minDeficitYZ + minDeficitX);
        minDif = Math.min(minDif, minDeficitX + minDeficitY + minDeficitZ);

        System.out.println(minDif);

    }

    public static long deficit(long divident, long divider) {
        return (divider - divident % divider) % divider;
    }

    public static long nod(long a, long b) {
        return b == 0 ? a : nod(b, a % b);
    }

    public static long nok(long a, long b) {
        return a / nod(a, b) * b;
    }
}
