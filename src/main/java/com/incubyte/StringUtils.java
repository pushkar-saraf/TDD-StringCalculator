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
        numbers[0] = parseInt(input);
        return numbers;
    }

    private static int parseInt(String input) {
        try{
            return Integer.parseInt(input);
        } catch (NumberFormatException ex) {
            return 0;
        }
    }
}
