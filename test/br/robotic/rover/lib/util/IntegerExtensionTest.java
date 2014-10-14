package br.robotic.rover.lib.util;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class IntegerExtensionTest {
    
    String parameterPositiveInteger;
    String parameterNegativeInteger;
    String parameterNotInteger;
    String parameterNull;
    String parameterZero;
    
    public IntegerExtensionTest() {
    }
     
    @Before
    public void setUp() {
        System.out.println("Start");
        
        parameterPositiveInteger = "1";
        parameterNegativeInteger = "-1";
        parameterNotInteger = "%";
        parameterNull = null;
        parameterZero = "0";
    }
    
    @After
    public void tearDown(){
        System.out.println("End");
    }
    
     @Test
    public void testTryParsePositiveInt_PositiveParameter_True() {
        System.out.println("testTryParsePositiveInt_PositiveParameter_True");
        boolean result = IntegerExtension.tryParsePositiveIntAndZero(parameterPositiveInteger);
        assertEquals(true, result);
    }
    
    @Test
    public void testTryParsePositiveInt_NegativeParameter_False() {
        System.out.println("testTryParsePositiveInt_NegativeParameter_False");
        boolean result = IntegerExtension.tryParsePositiveIntAndZero(parameterNegativeInteger);
        assertEquals(false, result);
    }
    
    @Test
    public void testTryParsePositiveInt_NotInteger_False() {
        System.out.println("testTryParsePositiveInt_NotInteger_False");
        boolean result = IntegerExtension.tryParsePositiveIntAndZero(parameterNotInteger);
        assertEquals(false, result);
    }
    
    @Test
    public void testTryParsePositiveInt_Null_False() {
        System.out.println("testTryParsePositiveInt_Null_False");
        boolean result = IntegerExtension.tryParsePositiveIntAndZero(parameterNull);
        assertEquals(false, result);
    }
    
    @Test
    public void testTryParsePositiveInt_Zero_True() {
        System.out.println("testTryParsePositiveInt_Zero_True");
        boolean result = IntegerExtension.tryParsePositiveIntAndZero(parameterZero);
        assertEquals(true, result);
    }
    
}
