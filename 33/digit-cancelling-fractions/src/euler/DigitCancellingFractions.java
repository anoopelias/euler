package euler;

import java.util.*;

public class DigitCancellingFractions {

    public static void main(String[] args) {
        fractions();
    }

    public static void fractions() {
        Set<Fraction> fractions = new HashSet<>();
        for (int x = 10; x <= 99; x++) {
            for (int y = x + 1; y <= 99; y++) {
                Fraction f1 = new Fraction(x, y);
                Fraction f2 = f1.removeCommonDigit();

                if (f2 != null && f1.normalize().equals(f2.normalize())) {
                    fractions.add(f1);
                }
            }
        }

        System.out.println(fractions.stream().reduce(Fraction::mutiply).orElse(null).normalize());
    }

    public static List<Integer> digitsOf(int x) {
        List<Integer> digits = new ArrayList<>();

        while (x != 0) {
            digits.add(x % 10);
            x = x / 10;
        }

        return digits;
    }

    public static List<Integer> factorsOf(int x) {
        List<Integer> factors = new ArrayList<>();
        for (int i = 1; i <= x; i++) {
            if (x % i == 0) {
                factors.add(i);
            }
        }

        return factors;
    }

    public static int hcf(int x, int y) {
        List<Integer> xFactors = factorsOf(x);
        List<Integer> yFactors = factorsOf(y);

        List<Integer> commonFactors = new ArrayList<>(xFactors);
        commonFactors.retainAll(yFactors);
        Collections.sort(commonFactors, Collections.reverseOrder());

        if (commonFactors.size() == 0) {
            // Either x or y is zero
            return 1;
        }

        return commonFactors.get(0);
    }

    static class Fraction {
        int x;
        int y;

        Fraction(int x, int y) {
            this.x = x;
            this.y = y;
        }

        Fraction removeCommonDigit() {
            List<Integer> xDigits = digitsOf(x);
            List<Integer> yDigits = digitsOf(y);

            List<Integer> commonDigits = new ArrayList<>(xDigits);
            commonDigits.retainAll(yDigits);

            if (commonDigits.size() > 0) {
                // There can only be one digit since y > x when we remove common digit
                Integer commonDigit = commonDigits.get(0);

                // We don't want trivial ones
                if (commonDigit != 0) {
                    xDigits.remove(commonDigit);
                    yDigits.remove(commonDigit);
                    return new Fraction(xDigits.get(0), yDigits.get(0));
                }
            }
            return null;
        }

        Fraction normalize() {
            int hcf = hcf(x, y);

            if (x != 1) {
                return new Fraction(x / hcf, y / hcf);
            }

            return this;
        }

        Fraction mutiply(Fraction fraction) {
            return new Fraction(x * fraction.x, y * fraction.y);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Fraction fraction = (Fraction) o;
            return x == fraction.x &&
                    y == fraction.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        public String toString() {
            return x + "/" + y;
        }
    }

}
