package pr.iceworld.fernando.leetcode.simple;

import java.util.Arrays;

public class Simple_66 {
    public static void main(String[] args) {
        Arrays.stream(plusOne(new int[]{9, 9, 9})).forEach(System.out::println);
    }

    public static int[] plusOne(int[] digits) {
        int size = digits.length;
        int[] result = new int[size + 1];
        int inc = 0;
        if (digits[size - 1] + 1 == 10) {
            inc = 1;
        } else {
            digits[size - 1] = digits[size - 1] + 1;
        }
        while (size - 1 >= 0) {

            if (digits[size - 1] + inc == 10) {
                inc = 1;
                digits[size - 1] = 0;
            } else if (inc > 0) {
                digits[size - 1] = digits[size - 1] + 1;
                inc = 0;
            } else {
                inc = 0;
            }

            size--;
        }
        if (inc > 0) {
            result[0] = 1;
            for (int i = 0; i < size; i++) {
                result[i + 1] = digits[i];
            }
            return result;
        }

        return digits;

    }
}
