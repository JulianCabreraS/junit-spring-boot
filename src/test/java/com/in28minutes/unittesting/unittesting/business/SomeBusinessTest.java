package com.in28minutes.unittesting.unittesting.business;

import org.junit.Test;

import static org.junit.Assert.*;

public class SomeBusinessTest {

    @Test
    public void calculateSum_basic(){
        SomeBusinessImpl business = new SomeBusinessImpl();
        int actualResult = business.calculateSum(new int[] {1,2,3});
        int expectedResult =6;
        assertEquals(expectedResult,actualResult);
    }
    public void calculateSum_empty(){
        SomeBusinessImpl business = new SomeBusinessImpl();
        int actualResult = business.calculateSum(new int[] { });
        int expectedResult =6;
        assertEquals(expectedResult,actualResult);
    }

}
