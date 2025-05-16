package task3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int numDays = 0;
        numDays = scanner.nextInt();

        int goodDays = scanner.nextInt();

        List<Integer> distances = new ArrayList<>();
        for (int i = 0; i < numDays; i++) {
            distances.add(scanner.nextInt());
        }

        int minChangeCounter = 0;
        if (distances.get(0) > distances.get(1)) {
            minChangeCounter = distances.get(0) - distances.get(1);
            distances.set(1, distances.get(0));
        }

        int firstDayDistance = distances.get(0);
        int secondDayDistance = distances.get(1);

        Collections.sort(distances);
        int leftIndex = distances.indexOf(firstDayDistance);
        int rightIndex = distances.lastIndexOf(secondDayDistance);

        goodDays = goodDays - (rightIndex - leftIndex - 1);

        int changeLeft = 0, changeRight = 0;
        while (goodDays > 0) {
            changeLeft = 0;
            changeRight = 0;
            if (leftIndex - 1 >= 0) {
                changeLeft = firstDayDistance - distances.get(leftIndex - 1);
            }
            if (rightIndex + 1 < distances.size()) {
                changeRight = distances.get(rightIndex + 1) - secondDayDistance;
            }

            if (changeLeft < changeRight && changeLeft > 0 || changeRight == 0) {
                minChangeCounter += changeLeft;
                leftIndex--;
            } else {
                minChangeCounter += changeRight;
                rightIndex++;
            }
            goodDays--;
        }
        System.out.println(minChangeCounter);

    }
}
