package com.incubyte;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Arrays;

/**
 * Class for utility methods to parse strings
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class StringUtils {

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
        ParsedInput parsedInput = parseInputString(input);
        String[] nums = parsedInput.getNumbers().split(parsedInput.getDelimiter());
        int[] numbers = new int[nums.length];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = parseInt(nums[i]);
        }
        return numbers;
    }

    /**
     * Method to parse an input string for delimiter and numbers
     *
     * @param input input string
     * @return ParsedInput
     */
    private static ParsedInput parseInputString(String input) {
        if (!input.startsWith("//")) {
            return ParsedInput.of("[,\n]", input);
        }
        String[] parts = input.split("\n");
        String delimiters = getDelimiters(parts[0].substring(2));
        return ParsedInput.of(delimiters, parts[1]);
    }

    /**
     * Method to get a regexp of delimiters
     *
     * @param input delimiters in [...][...] format
     * @return delimiters in regexp separated by '|' operator
     */
    private static String getDelimiters(String input) {
        String[] delimiters = input.split("]");
        return Arrays.stream(delimiters).map(str -> str.substring(1))
                .map(StringUtils::sanitize)
                .reduce("", (s1, s2) -> s1 + "|" + s2);
    }

    /**
     * Sanitize string for special caracters
     *
     * @param str input
     * @return sanitized output
     */
    private static String sanitize(String str) {
        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (c == '*') {
                sb.append("\\");
            }
            sb.append(c);
        }
        return sb.toString();
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
