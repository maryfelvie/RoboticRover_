package br.robotic.rover.lib;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class SquareTest {
    
    private Coordinates upperRightCoordinateNull;
    private Coordinates lowerLeftCoordinateNull;
    private Coordinates upperRightCoordinate;
    private Coordinates lowerLeftCoordinate;
    
    public SquareTest() {
    }

    @Before
    public void setUp() {
        System.out.println("Start");
        
        upperRightCoordinate = new Coordinates(5, 5);
        lowerLeftCoordinate = new Coordinates(0, 0);
    }
    
    @After
    public void tearDown() {
        System.out.println("End");
    }

    
    @Test
    public void testConstructor_ParametersNull_Exception() {
        System.out.println("testConstructor_ParametersNull_Exception");
        boolean expResult = true;
        boolean result = false;
        
        try{
            Square instance = new Square(upperRightCoordinateNull, lowerLeftCoordinateNull);
        }
        catch(IllegalArgumentException ex){
            result = true;
        }
        
        assertEquals(expResult, result); 
    }
    
    @Test
    public void testConstructor_ParameterNull_Exception() {
        System.out.println("testConstructor_ParameterNull_Exception");
        boolean expResult = true;
        boolean result = false;
        
        try{
            Square instance = new Square(upperRightCoordinateNull);
        }
        catch(IllegalArgumentException ex){
            result = true;
        }
        
        assertEquals(expResult, result); 
    }
    
    @Test
    public void testConstructor_ParametersNotNull_Square() {
        System.out.println("testConstructor_ParametersNotNull_Square");
        boolean expResult = true;
        boolean result = true;
        
        try{
            Square instance = new Square(upperRightCoordinate, lowerLeftCoordinate);
        }
        catch(IllegalArgumentException ex){
            result = false;
        }
        
        assertEquals(expResult, result); 
    }
    
    @Test
    public void testConstructor_ParameterNotNull_Square() {
        System.out.println("testConstructor_ParameterNotNull_Square");
        boolean expResult = true;
        boolean result = false;
        
        try{
            Square instance = new Square(upperRightCoordinateNull);
        }
        catch(IllegalArgumentException ex){
            result = true;
        }
        
        assertEquals(expResult, result); 
    }
    
    @Test
    public void testConstructor_ParametersNullAndParametersNotNull_Exception() {
        System.out.println("testConstructor_ParametersNullAndParametersNotNull_Exception");
        boolean expResult = true;
        boolean result = false;
        
        try{
            Square instance = new Square(upperRightCoordinateNull, lowerLeftCoordinate);
        }
        catch(IllegalArgumentException ex){
            result = true;
        }
        
        assertEquals(expResult, result); 
    }
}
