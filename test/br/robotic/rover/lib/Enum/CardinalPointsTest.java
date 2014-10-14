package br.robotic.rover.lib.Enum;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CardinalPointsTest {
    
    String foundItemIntheEnum;
    String notfoundItemIntheEnum;
    String emptyItem;
   
    
    public CardinalPointsTest() {
    }
    
    @Before
    public void setUp() {
        System.out.println("Start");
        
        foundItemIntheEnum = "E";
        notfoundItemIntheEnum = "J";
        emptyItem = null;
    }
    
    @After
    public void tearDown() {
        System.out.println("Stop");
    }

    @Test
    public void testValueOf_FoundItem_CardinalPoints() {
        System.out.println("testValueOf_FoundItem_CardinalPoints");
        
        CardinalPoints expResult = CardinalPoints.E;
        CardinalPoints result = CardinalPoints.valueOf(foundItemIntheEnum);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testFromString_FoundItem_CardinalPoints() {
        System.out.println("testFromString_FoundItem_CardinalPoints");
        CardinalPoints expResult = CardinalPoints.E;
        CardinalPoints result = CardinalPoints.fromString(foundItemIntheEnum);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testFromString_EmptyItem_CardinalPoints() {
        System.out.println("testFromString_EmptyItem_CardinalPoints");
        CardinalPoints expResult = null;
        CardinalPoints result = CardinalPoints.fromString(emptyItem);
        assertEquals(expResult, result);
    }
    
}
