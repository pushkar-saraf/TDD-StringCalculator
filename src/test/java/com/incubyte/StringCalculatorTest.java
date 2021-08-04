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

}