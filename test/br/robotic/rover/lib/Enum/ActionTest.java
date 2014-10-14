package br.robotic.rover.lib.Enum;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ActionTest {
    
    String foundItemIntheEnum;
    String notfoundItemIntheEnum;
    String emptyItem;
    
    public ActionTest() {
    }
    
    @Before
    public void setUp() {
        System.out.println("Start");
        
        foundItemIntheEnum = "L";
        notfoundItemIntheEnum = "J";
        emptyItem = null;
    }
    
    @After
    public void tearDown() {
        System.out.println("Stop");
    }

    @Test
    public void testValueOf_FoundItem_Action() {
        System.out.println("testValueOf_FoundItem_Action");
        
        Action expResult = Action.L;
        Action result = Action.valueOf(foundItemIntheEnum);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testFromString_FoundItem_Action() {
        System.out.println("testFromString_FoundItem_Action");
        Action expResult = Action.L;
        Action result = Action.fromString(foundItemIntheEnum);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testFromString_EmptyItem_Action() {
        System.out.println("testFromString_EmptyItem_Action");
        Action expResult = null;
        Action result = Action.fromString(emptyItem);
        assertEquals(expResult, result);
    }
    
    
}
