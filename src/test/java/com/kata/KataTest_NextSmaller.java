package com.kata;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class KataTest_NextSmaller {
    @Test
    public void less_21() {
        Assertions.assertEquals(12, NextSmaller.nextSmaller(21));
    }

    @Test
    public void less_351() {
        Assertions.assertEquals(315, NextSmaller.nextSmaller(351));
    }

    @Test
    public void less_315() {
        Assertions.assertEquals(153, NextSmaller.nextSmaller(315));
    }

    @Test
    public void less_111() {
        Assertions.assertEquals(-1, NextSmaller.nextSmaller(111));
    }

    @Test
    public void less_123() {
        Assertions.assertEquals(-1, NextSmaller.nextSmaller(123));
    }

    @Test
    public void less_4123() {
        Assertions.assertEquals(3421, NextSmaller.nextSmaller(4123));
    }

    @Test
    public void less_531() {
        Assertions.assertEquals(513, NextSmaller.nextSmaller(531));
    }

    @Test
    public void less_2071(){
        Assertions.assertEquals(2017, NextSmaller.nextSmaller(2071));
    }

    @Test
    public void less_135(){
        Assertions.assertEquals(-1, NextSmaller.nextSmaller(135));
    }

    @Test
    public void less_1027(){
        Assertions.assertEquals(-1, NextSmaller.nextSmaller(1027));
    }

    @Test
    public void less_441(){
        Assertions.assertEquals(414, NextSmaller.nextSmaller(441));
    }

    @Test
    public void less_123456798(){
        Assertions.assertEquals(123456789, NextSmaller.nextSmaller(123456798));
    }
}
