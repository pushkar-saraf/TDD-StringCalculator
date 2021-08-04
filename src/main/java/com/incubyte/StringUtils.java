package com.incubyte;

public class StringUtils {
    /**
     * Private constructor for utility class
     */
    private StringUtils() {
    }

    /**
     * Checks if input string is empty or null
     *
     * @param input input string
     * @return outcome
     */
    public static boolean isEmpty(String input) {
        if (input == null) {
            return true;
        }
        return input.isBlank();
    }

    /**
     * Returns parsed numbers for input string
     *
     * @param input input string
     * @return parsed numbers
     */
    public static int[] getNumbers(String input) {
        int[] numbers = new int[3];
        numbers[0] = parseInt(input);
        return numbers;
    }

    /**
     * Method to parse an integer
     *
     * @param input number as string
     * @return number as integer
     */
    private static int parseInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException ex) {
            return 0;
        }
    }
}
