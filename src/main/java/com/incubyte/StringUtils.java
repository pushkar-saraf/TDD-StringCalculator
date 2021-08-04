package com.incubyte;

public class StringUtils {
    // private constructor for static class
    // so default public one is not used
    private StringUtils(){}

    public static boolean isEmpty(String input){
        if(input == null) {
            return  true;
        }
        return input.isBlank();
    }

    public static int[] getNumbers(String input) {
        int[] numbers = new int[3];
        return numbers;
    }
}
