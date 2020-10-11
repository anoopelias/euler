package euler;

import java.util.*;

public class PandigitalProducts {

    private static final List<Integer> NUMS = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

    public static void main(String[] args) {
        System.out.println("Pandigital products");
        Set<Integer> products = new HashSet<>();
        permutations(new ArrayList<>(), NUMS, products);

        System.out.println(products.stream().reduce((Integer a, Integer b) -> a + b));
    }

    private static List<Integer> permutations(List<Integer> nums, List<Integer> options, Set<Integer> products) {
        if (options.size() == 0) {
            products.addAll(pandigitalProducts(nums));
        }

        List<Integer> permutations = new ArrayList<>();
        for (Integer option : options) {

            List<Integer> nNums = new ArrayList<>(nums);
            nNums.add(option);
            List<Integer> nOptions = new ArrayList<>(options);
            nOptions.remove(option);

            permutations.addAll(permutations(nNums, nOptions, products));
        }

        return permutations;
    }

    private static Integer arrayToNum(List<Integer> nums) {
        return nums.stream().reduce((Integer a, Integer b) -> (a * 10) + b).orElse(0);
    }

    private static Set<Integer> pandigitalProducts(List<Integer> digits) {
        Set<Integer> products = new HashSet<>();
        for (int i = 1; i < digits.size(); i++) {
            for (int j = i + 1; j < digits.size(); j++) {
                Integer x = arrayToNum(digits.subList(0, i));
                Integer y = arrayToNum(digits.subList(i, j));
                Integer z = arrayToNum(digits.subList(j, digits.size()));
                if (x * y == z) {
                    products.add(z);
                }
            }
        }

        return products;
    }

}
