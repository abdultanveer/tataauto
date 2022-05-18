package com.abdul.tataauto;

import junit.framework.TestCase;

public class CalculatorTest extends TestCase {
    public void  testMultiply(){
        int exp = 20;
        int act = Calculator.multiply(5,4);
        assertEquals(exp,act);
    }
    public void testAdd() {
        int expected = 40;
        int actual = Calculator.add(10,20);
        assertEquals(expected,actual);
    }

    public  void testDivide(){
        int expected = 5;
        int actual = Calculator.divide(20,4);
        assertEquals(expected,actual);
    }
}