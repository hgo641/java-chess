package techcourse.fp.mission;

import java.util.List;
import java.util.function.Predicate;

public class Calculator {

    public static int sumWhen(List<Integer> numbers, Predicate<Integer> sumCondition) {
        int total = 0;
        for (int number : numbers) {
            if (sumCondition.test(number)) {
                total += number;
            }
        }
        return total;
    }

    public static int sumAll(List<Integer> numbers) {
        return sumWhen(numbers, number -> true);
    }

    public static int sumAllEven(List<Integer> numbers) {
        return sumWhen(numbers, num -> (num % 2 == 0));
    }

    public static int sumAllOverThree(List<Integer> numbers) {
        int total = 0;
        return 0;

    }
}
