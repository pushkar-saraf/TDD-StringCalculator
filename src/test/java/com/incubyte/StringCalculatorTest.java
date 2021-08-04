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

}