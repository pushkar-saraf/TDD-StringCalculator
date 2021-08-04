package com.incubyte;

class StringCalculator {

    public int add(String numbers) {
        if(StringUtils.isEmpty(numbers)) {
            return 0;
        }
        return sum(StringUtils.getNumbers(numbers));
    }

    private int sum(int[] nums) {
        return 0;
    }
}