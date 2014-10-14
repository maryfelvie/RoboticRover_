package br.robotic.rover.lib;

import br.robotic.rover.lib.Enum.CardinalPoints;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class RoverTest {
    
    Square squareNull;
    Square squareNotNullAndValid;
    Square squareNotNullAndZero;
    
    public RoverTest() {
    }
    
    @Before
    public void setUp() {
        System.out.println("Start");
        
        Coordinates upperRightCoordinate = new Coordinates(5,5);
        Coordinates zeroCoordinate = new Coordinates(0,0);
                
        squareNotNullAndValid = new Square(upperRightCoordinate);
        
        squareNotNullAndZero = new Square(zeroCoordinate);
        
    }
    
    @After
    public void tearDown() {
        System.out.println("End");
    }

    @Test
    public void testConstructor_NullParameter_Exception(){
        System.out.println("testConstructor_NullParameter_Exception");
        boolean expResult = true;
        boolean result = false;
        
        try{
            Rover instance = new Rover(squareNull);
        }
        catch(IllegalArgumentException ex){
            result = true;
        }
        
        assertEquals(expResult, result); 
    }

    
    @Test
    public void testSetLastLocation_NullLocation_Exception(){
        System.out.println("testSetLastLocation_NullLocation_Exception");
        boolean expResult = true;
        boolean result = false;
        
        try{
            Location location = null;
            Rover instance = new Rover(squareNotNullAndValid);
            instance.setLastLocation(location);
        }
        catch(IllegalArgumentException ex){
            result = true;
        }
        
        assertEquals(expResult, result); 
    }

    @Test
    public void testSetLastLocation_CoordinateXGreaterThanSquareX_Exception(){
        System.out.println("testSetLastLocation_CoordinateXGreaterThanSquareX_Exception");
        boolean expResult = true;
        boolean result = false;
        
        try{
            Coordinates coordinate = new Coordinates(6, 0);
            CardinalPoints cardinalPoint = CardinalPoints.E;
            Location location = new Location(coordinate, cardinalPoint);
            
            Rover instance = new Rover(squareNotNullAndValid);
            instance.setLastLocation(location);
        }
        catch(UnsupportedOperationException ex){
            result = true;
        }
        
        assertEquals(expResult, result); 
    }
    
    @Test
    public void testSetLastLocation_CoordinateXLessThanSquareX_Location(){
        System.out.println("testSetLastLocation_CoordinateXLessThanSquareX_Location");
        boolean expResult = true;
        boolean result = true;
        
        try{
            Coordinates coordinate = new Coordinates(4, 0);
            CardinalPoints cardinalPoint = CardinalPoints.E;
            Location location = new Location(coordinate, cardinalPoint);
            
            Rover instance = new Rover(squareNotNullAndValid);
            instance.setLastLocation(location);
        }
        catch(UnsupportedOperationException ex){
            result = false;
        }
        
        assertEquals(expResult, result); 
    }
    
    @Test
    public void testSetLastLocation_CoordinateYGreaterThanSquareY_Exception(){
        System.out.println("testSetLastLocation_CoordinateYGreaterThanSquareY_Exception");
        boolean expResult = true;
        boolean result = false;
        
        try{
            Coordinates coordinate = new Coordinates(1, 7);
            CardinalPoints cardinalPoint = CardinalPoints.E;
            Location location = new Location(coordinate, cardinalPoint);
            
            Rover instance = new Rover(squareNotNullAndValid);
            instance.setLastLocation(location);
        }
        catch(UnsupportedOperationException ex){
            result = true;
        }
        
        assertEquals(expResult, result); 
    }
    
    @Test
    public void testSetLastLocation_CoordinateYLessThanSquareY_Location(){
        System.out.println("testSetLastLocation_CoordinateYLessThanSquareY_Location");
        boolean expResult = true;
        boolean result = true;
        
        try{
            Coordinates coordinate = new Coordinates(2, 2);
            CardinalPoints cardinalPoint = CardinalPoints.E;
            Location location = new Location(coordinate, cardinalPoint);
            
            Rover instance = new Rover(squareNotNullAndValid);
            instance.setLastLocation(location);
        }
        catch(UnsupportedOperationException ex){
            result = false;
        }
        
        assertEquals(expResult, result); 
    }
    
    @Test
    public void testSpinLeft_CardinalPointEqualN_CardinalPointEqualW(){
        System.out.println("testSpinLeft_CardinalPointEqualN_CardinalPointEqualW");
        CardinalPoints result = CardinalPoints.W;
        
        
        Coordinates coordinate = new Coordinates(2, 2);
        CardinalPoints cardinalPoint = CardinalPoints.N;
        Location location = new Location(coordinate, cardinalPoint);

        Rover instance = new Rover(squareNotNullAndValid);
        instance.setLastLocation(location);

        instance.spinLeft();

        assertEquals(instance.getLastLocation().getCardinalPoints(), result); 
            
    }
    
    @Test
    public void testSpinLeft_CardinalPointEqualS_CardinalPointEqualE(){
        System.out.println("testSpinLeft_CardinalPointEqualS_CardinalPointEqualE");
        CardinalPoints result = CardinalPoints.E;
        
        Coordinates coordinate = new Coordinates(2, 2);
        CardinalPoints cardinalPoint = CardinalPoints.S;
        Location location = new Location(coordinate, cardinalPoint);

        Rover instance = new Rover(squareNotNullAndValid);
        instance.setLastLocation(location);

        instance.spinLeft();

        assertEquals(instance.getLastLocation().getCardinalPoints(), result); 
            
    }
    
    @Test
    public void testSpinLeft_CardinalPointEqualE_CardinalPointEqualN(){
        System.out.println("testSpinLeft_CardinalPointEqualE_CardinalPointEqualN");
        CardinalPoints result = CardinalPoints.N;
        
        Coordinates coordinate = new Coordinates(2, 2);
        CardinalPoints cardinalPoint = CardinalPoints.E;
        Location location = new Location(coordinate, cardinalPoint);

        Rover instance = new Rover(squareNotNullAndValid);
        instance.setLastLocation(location);

        instance.spinLeft();

        assertEquals(instance.getLastLocation().getCardinalPoints(), result); 
            
    }
    
    @Test
    public void testSpinLeft_CardinalPointEqualW_CardinalPointEqualS(){
        System.out.println("testSpinLeft_CardinalPointEqualW_CardinalPointEqualS");
        CardinalPoints result = CardinalPoints.S;
        
        Coordinates coordinate = new Coordinates(2, 2);
        CardinalPoints cardinalPoint = CardinalPoints.W;
        Location location = new Location(coordinate, cardinalPoint);

        Rover instance = new Rover(squareNotNullAndValid);
        instance.setLastLocation(location);

        instance.spinLeft();

        assertEquals(instance.getLastLocation().getCardinalPoints(), result); 
            
    }
    
    @Test
    public void testSpinRight_CardinalPointEqualN_LocationWithCardinalPointEqualE(){
        System.out.println("testSpinRight_CardinalPointEqualN_LocationWithCardinalPointEqualE");
        CardinalPoints result = CardinalPoints.E;
        
        
        Coordinates coordinate = new Coordinates(2, 2);
        CardinalPoints cardinalPoint = CardinalPoints.N;
        Location location = new Location(coordinate, cardinalPoint);

        Rover instance = new Rover(squareNotNullAndValid);
        instance.setLastLocation(location);

        instance.spinRight();

        assertEquals(instance.getLastLocation().getCardinalPoints(), result); 
            
    }
    
    @Test
    public void testSpinRight_CardinalPointEqualS_LocationWithCardinalPointEqualW(){
        System.out.println("testSpinRight_CardinalPointEqualS_LocationWithCardinalPointEqualW");
        CardinalPoints result = CardinalPoints.W;
        
        Coordinates coordinate = new Coordinates(2, 2);
        CardinalPoints cardinalPoint = CardinalPoints.S;
        Location location = new Location(coordinate, cardinalPoint);

        Rover instance = new Rover(squareNotNullAndValid);
        instance.setLastLocation(location);

        instance.spinRight();

        assertEquals(instance.getLastLocation().getCardinalPoints(), result); 
            
    }
    
    @Test
    public void testSpinRight_CardinalPointEqualE_LocationWithCardinalPointEqualS(){
        System.out.println("testSpinRight_CardinalPointEqualE_LocationWithCardinalPointEqualS");
        CardinalPoints result = CardinalPoints.S;
        
        Coordinates coordinate = new Coordinates(2, 2);
        CardinalPoints cardinalPoint = CardinalPoints.E;
        Location location = new Location(coordinate, cardinalPoint);

        Rover instance = new Rover(squareNotNullAndValid);
        instance.setLastLocation(location);

        instance.spinRight();

        assertEquals(instance.getLastLocation().getCardinalPoints(), result); 
            
    }
    
    @Test
    public void testSpinRight_CardinalPointEqualW_LocationWithCardinalPointEqualN(){
        System.out.println("testSpinRight_CardinalPointEqualW_LocationWithCardinalPointEqualN");
        CardinalPoints result = CardinalPoints.N;
        
        Coordinates coordinate = new Coordinates(2, 2);
        CardinalPoints cardinalPoint = CardinalPoints.W;
        Location location = new Location(coordinate, cardinalPoint);

        Rover instance = new Rover(squareNotNullAndValid);
        instance.setLastLocation(location);

        instance.spinRight();

        assertEquals(instance.getLastLocation().getCardinalPoints(), result); 
            
    }
    
    @Test
    public void testMove_CardinalPointEqualN_LocationWithCordinateYPlusOnePoint(){
        System.out.println("testMove_CardinalPointEqualN_LocationWithCordinateYPlusOnePoint");
        
        CardinalPoints cardinalPoint = CardinalPoints.N;
        
        Coordinates resultCoordinate = new Coordinates(2, 3);
        Location resultLocation = new Location(resultCoordinate, cardinalPoint);
        
        Coordinates coordinate = new Coordinates(2, 2);
        
        Location location = new Location(coordinate, cardinalPoint);

        Rover instance = new Rover(squareNotNullAndValid);
        instance.setLastLocation(location);

        instance.Move();

        assertEquals(instance.getLastLocation().getCoordinate().getX(), resultLocation.getCoordinate().getX()); 
        assertEquals(instance.getLastLocation().getCoordinate().getY(), resultLocation.getCoordinate().getY());     
    }
    
    @Test
    public void testMove_CardinalPointEqualS_LocationWithCordinateYLessOnePoint(){
        System.out.println("testMove_CardinalPointEqualS_LocationWithCordinateYLessOnePoint");
        
        CardinalPoints cardinalPoint = CardinalPoints.S;
        
        Coordinates resultCoordinate = new Coordinates(2, 1);
        Location resultLocation = new Location(resultCoordinate, cardinalPoint);
        
        Coordinates coordinate = new Coordinates(2, 2);
        
        Location location = new Location(coordinate, cardinalPoint);

        Rover instance = new Rover(squareNotNullAndValid);
        instance.setLastLocation(location);

        instance.Move();

        assertEquals(instance.getLastLocation().getCoordinate().getX(), resultLocation.getCoordinate().getX()); 
        assertEquals(instance.getLastLocation().getCoordinate().getY(), resultLocation.getCoordinate().getY());      
    }
    
    @Test
    public void testMove_CardinalPointEqualE_LocationWithCordinateXPlusOnePoint(){
        System.out.println("testMove_CardinalPointEqualE_LocationWithCordinateXPlusOnePoint");
        
        CardinalPoints cardinalPoint = CardinalPoints.E;
        
        Coordinates resultCoordinate = new Coordinates(3, 2);
        Location resultLocation = new Location(resultCoordinate, cardinalPoint);
        
        Coordinates coordinate = new Coordinates(2, 2);
        
        Location location = new Location(coordinate, cardinalPoint);

        Rover instance = new Rover(squareNotNullAndValid);
        instance.setLastLocation(location);

        instance.Move();

        assertEquals(instance.getLastLocation().getCoordinate().getX(), resultLocation.getCoordinate().getX()); 
        assertEquals(instance.getLastLocation().getCoordinate().getY(), resultLocation.getCoordinate().getY()); 
            
    }
    
    @Test
    public void testMove_CardinalPointEqualW_LocationWithCordinateXLessOnePoint(){
        System.out.println("testMove_CardinalPointEqualW_LocationWithCordinateXLessOnePoint");
        
        CardinalPoints cardinalPoint = CardinalPoints.W;
        
        Coordinates resultCoordinate = new Coordinates(1, 2);
        Location resultLocation = new Location(resultCoordinate, cardinalPoint);
        
        Coordinates coordinate = new Coordinates(2, 2);
        
        Location location = new Location(coordinate, cardinalPoint);

        Rover instance = new Rover(squareNotNullAndValid);
        instance.setLastLocation(location);

        instance.Move();

        assertEquals(instance.getLastLocation().getCoordinate().getX(), resultLocation.getCoordinate().getX()); 
        assertEquals(instance.getLastLocation().getCoordinate().getY(), resultLocation.getCoordinate().getY());  
            
    }
    
    @Test
    public void testMove_CardinalPointEqualN_OverLimitY(){
        System.out.println("testMove_CardinalPointEqualN_OverLimitY");
        CardinalPoints cardinalPoint = CardinalPoints.N;
        
        Coordinates resultCoordinate = new Coordinates(3, 6);
        Location resultLocation = new Location(resultCoordinate, cardinalPoint);
        
        Coordinates coordinate = new Coordinates(3, 6);
        
        Location location = new Location(coordinate, cardinalPoint);

        Rover instance = new Rover(squareNotNullAndValid);
        instance.setLastLocation(location);

        instance.Move();

        assertEquals(instance.getLastLocation().getCoordinate().getX(), resultLocation.getCoordinate().getX()); 
        assertEquals(instance.getLastLocation().getCoordinate().getY(), resultLocation.getCoordinate().getY());
    }
    
    @Test
    public void testMove_CardinalPointEqualS_BellowTheLimitY(){
        System.out.println("testMove_CardinalPointEqualS_BellowTheLimitY");
        
        CardinalPoints cardinalPoint = CardinalPoints.S;
        
        Coordinates resultCoordinate = new Coordinates(2, 0);
        Location resultLocation = new Location(resultCoordinate, cardinalPoint);
        
        Coordinates coordinate = new Coordinates(2, 0);
        
        Location location = new Location(coordinate, cardinalPoint);

        Rover instance = new Rover(squareNotNullAndValid);
        instance.setLastLocation(location);

        instance.Move();

        assertEquals(instance.getLastLocation().getCoordinate().getX(), resultLocation.getCoordinate().getX()); 
        assertEquals(instance.getLastLocation().getCoordinate().getY(), resultLocation.getCoordinate().getY());    
    }
    
    @Test
    public void testMove_CardinalPointEqualE_OverLimitX(){
        System.out.println("testMove_CardinalPointEqualE_OverLimitX");
        CardinalPoints cardinalPoint = CardinalPoints.E;
        
        Coordinates resultCoordinate = new Coordinates(5, 2);
        Location resultLocation = new Location(resultCoordinate, cardinalPoint);
        
        Coordinates coordinate = new Coordinates(5, 2);
        
        Location location = new Location(coordinate, cardinalPoint);

        Rover instance = new Rover(squareNotNullAndValid);
        instance.setLastLocation(location);

        instance.Move();

        assertEquals(instance.getLastLocation().getCoordinate().getX(), resultLocation.getCoordinate().getX()); 
        assertEquals(instance.getLastLocation().getCoordinate().getY(), resultLocation.getCoordinate().getY());
               
    }
    
    @Test
    public void testMove_CardinalPointEqualW_BellowTheLimitX(){
        System.out.println("testMove_CardinalPointEqualW_BellowTheLimitX");
        
        CardinalPoints cardinalPoint = CardinalPoints.W;
        
        Coordinates resultCoordinate = new Coordinates(0, 2);
        Location resultLocation = new Location(resultCoordinate, cardinalPoint);
        
        Coordinates coordinate = new Coordinates(0, 2);
        
        Location location = new Location(coordinate, cardinalPoint);

        Rover instance = new Rover(squareNotNullAndValid);
        instance.setLastLocation(location);

        instance.Move();

        assertEquals(instance.getLastLocation().getCoordinate().getX(), resultLocation.getCoordinate().getX()); 
        assertEquals(instance.getLastLocation().getCoordinate().getY(), resultLocation.getCoordinate().getY()); 
            
    }
}
    
    
    
    

