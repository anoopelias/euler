package euler;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NonAbundantSums {

    private static final Integer MAX = 28123;

    private static List<Integer> factorsOf(int n) {
        List<Integer> factors = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            if (n % i == 0) {
                factors.add(i);
            }
        }
        return factors;
    }

    private static List<Integer> abundantNums() {
        List<Integer> abundantNums = new ArrayList<>();

        for (int i = 1; i <= MAX; i++) {
            Optional<Integer> sumOfFactors = factorsOf(i).stream().reduce((Integer x, Integer y) -> x + y);
            if (sumOfFactors.orElse(0) > i) {
                abundantNums.add(i);
            }
        }
        return abundantNums;
    }

    private static Set<Integer> abundantSums() {
        Set<Integer> abundantSums = new HashSet<>();
        List<Integer> abundantNums = abundantNums();

        for (int i = 0; i < abundantNums.size(); i++) {
            for (int j = i; j < abundantNums.size(); j++) {
                Integer sum = abundantNums.get(i) + abundantNums.get(j);
                if (sum > MAX) {
                    break;
                }
                abundantSums.add(sum);
            }

        }

        return abundantSums;
    }

    private static List<Integer> nonAbundantSums() {
        List<Integer> allNums = IntStream.rangeClosed(1, MAX)
                .boxed().collect(Collectors.toList());
        allNums.removeAll(abundantSums());
        return allNums;
    }

    public static void main(String[] args) {
        System.out.println("Non abundant sums");
        System.out.println(nonAbundantSums().stream().reduce((Integer x, Integer y) -> x + y));
    }
}
