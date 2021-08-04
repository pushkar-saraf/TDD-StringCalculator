package com.incubyte;

import lombok.Getter;

import java.util.Arrays;

@Getter
class StringCalculator {

    private static final int CALCULATOR_LIMIT = 1000;
    private int count = 0;

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
        incrementCount();
        return sum(StringUtils.getNumbers(numbers));
    }

    private void incrementCount() {
        count += 1;
    }

    /**
     * Method to add parsed numbers and return the sum
     *
     * @param nums parsed input numbers
     * @return sum
     */
    private int sum(int[] nums) {
        return Arrays.stream(validateInput(nums)).sum();
    }

    private int[] validateInput(int[] nums) {
        int[] negatives = Arrays.stream(nums).filter(x -> x < 0).toArray();
        if(negatives.length != 0) {
            String message = String.format("Negative number(s) %s are not supported", Arrays.toString(negatives));
            throw new UnsupportedOperationException(message);
        }
        return Arrays.stream(nums).filter(x -> x <= CALCULATOR_LIMIT).toArray();
    }
}