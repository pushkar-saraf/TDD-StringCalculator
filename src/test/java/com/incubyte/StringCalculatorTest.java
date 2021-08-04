package com.incubyte;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class StringCalculatorTest {

    private static StringCalculator stringCalculator;

    @BeforeAll
    static void setup(){
        stringCalculator = new StringCalculator();
    }

    @Test
    void givenNull_whenAdd_thenZero(){
        Assertions.assertEquals(
                0,
                stringCalculator.add(null)
        );
    }

    @Test
    void givenEmpty_whenAdd_thenZero(){
        Assertions.assertEquals(
                0,
                stringCalculator.add("")
        );
    }

    @Test
    void givenSingleNumber_whenAdd_thenNumber(){
        Assertions.assertEquals(
                1,
                stringCalculator.add("1")
        );
    }

    @Test
    void givenTwoNumbers_wheAdd_thenSum() {
        Assertions.assertEquals(
                3,
                stringCalculator.add("1,2")
        );
    }

    @Test
    void givenMultipleNumbers_whenAdd_thenSum(){
        Assertions.assertEquals(
                6,
                stringCalculator.add("1,2,3")
        );
        Assertions.assertEquals(
                6,
                stringCalculator.add("0,1,2,3")
        );
    }

    @Test
    void givenNumbersInNewLine_whenAdd_thenSum(){
        Assertions.assertEquals(
                6,
                stringCalculator.add("1\n2,3")
        );
    }

    @Test
    void givenDelimiterAndNumbers_whenAdd_thenSum(){
        Assertions.assertEquals(
                3,
                stringCalculator.add("//;\n1;2")
        );
    }

    @Test
    void givenNegative_whenAdd_thenNotSupported(){
        UnsupportedOperationException ex = Assertions.assertThrows(UnsupportedOperationException.class,() -> stringCalculator.add("-1,0,1"));
        Assertions.assertEquals("Negative number(s) [-1] are not supported", ex.getMessage());
    }

    @Test
    void givenNegativeNumbers_whenAdd_thenNotSupported(){
        UnsupportedOperationException ex = Assertions.assertThrows(UnsupportedOperationException.class,() -> stringCalculator.add("-1,0,-1"));
        Assertions.assertEquals("Negative number(s) [-1, -1] are not supported", ex.getMessage());
    }

    @Test
    void givenOperations_whenGetAddCount_thenCount() {
        stringCalculator = new StringCalculator();
        stringCalculator.add("1");
        stringCalculator.add("1,2");
        Assertions.assertEquals(2, stringCalculator.getCount());
    }

    @Test
    void givenLargeNumbers_whenAdd_thenIgnored() {
        Assertions.assertEquals(2, stringCalculator.add("1001,2"));
    }

}