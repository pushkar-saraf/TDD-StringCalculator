package com.incubyte;

import java.util.Arrays;

class StringCalculator {

    /**
     * Method used to add numbers
     *
     * @param numbers input string containing numbers
     * @return result
     */
    public int add(String numbers) {
        if (StringUtils.isEmpty(numbers)) {
            return 0;
        }
        return sum(StringUtils.getNumbers(numbers));
    }

    /**
     * Method to add parsed numbers and return the sum
     *
     * @param nums parsed input numbers
     * @return sum
     */
    private int sum(int[] nums) {
        return Arrays.stream(nums).sum();
    }
}