package br.robotic.rover.lib;
import br.robotic.rover.lib.Enum.CardinalPoints;

public class Rover {
    private Location lastLocation;
    private Square square;
     
    public Rover(Square square){
        if(square == null)
            throw new IllegalArgumentException("Square is required");
        
        if(square.getUpperRightCoordinate().getX() <= 0 && square.getUpperRightCoordinate().getY() <= 0 )
            throw new UnsupportedOperationException("Invalid Square");
        
        this.square = square;
    }
    
    public Location getLastLocation(){        
        return lastLocation;
    }
      
    public void setLastLocation(Location location){
        if(location == null)
            throw new IllegalArgumentException("Location is required");
        
        if(location.getCoordinate().getX() > square.getUpperRightCoordinate().getX() ||
           location.getCoordinate().getY() > square.getUpperRightCoordinate().getY())
            throw new UnsupportedOperationException("Invalid Location");
        
        lastLocation = location;
    }
    
    public String getLocationFriendly(){
        String str = String.format("%d %d %s", lastLocation.getCoordinate().getX(), lastLocation.getCoordinate().getY(), lastLocation.getCardinalPoints().toString());
         
        return str;
    }
    
    public void spinLeft(){
        ValidateSettings();
        
        switch(lastLocation.getCardinalPoints()){
            case N: 
                lastLocation.setCardinalPoints(CardinalPoints.W);
                break;
            case S: 
                lastLocation.setCardinalPoints(CardinalPoints.E);
                break;
            case E: 
                lastLocation.setCardinalPoints(CardinalPoints.N);
                break;
            default: 
                lastLocation.setCardinalPoints(CardinalPoints.S);
                break;
        }
    }
    
    public void spinRight(){
        ValidateSettings();
        
        switch(lastLocation.getCardinalPoints()){
            case N: 
                lastLocation.setCardinalPoints(CardinalPoints.E);
                break;
            case S: 
                lastLocation.setCardinalPoints(CardinalPoints.W);
                break;
            case E: 
                lastLocation.setCardinalPoints(CardinalPoints.S);
                break;
            default: 
                lastLocation.setCardinalPoints(CardinalPoints.N);
                break;
        }

    }
    
    public void Move(){
        ValidateSettings();
        
        Coordinates coordinate;
        
        switch(lastLocation.getCardinalPoints()){
            case N: 
                coordinate = new Coordinates(lastLocation.getCoordinate().getX(), lastLocation.getCoordinate().getY());
                coordinate.setY(coordinate.getY() + 1);
                if(validateCoordinates(coordinate))
                    lastLocation.setCoordinate(coordinate);
                break;
            case S: 
                coordinate = new Coordinates(lastLocation.getCoordinate().getX(), lastLocation.getCoordinate().getY());
                coordinate.setY(coordinate.getY() - 1);
                if(validateCoordinates(coordinate))
                    lastLocation.setCoordinate(coordinate);
                break;
            case E: 
                coordinate = new Coordinates(lastLocation.getCoordinate().getX(), lastLocation.getCoordinate().getY());
                coordinate.setX(coordinate.getX()+ 1);
                if(validateCoordinates(coordinate))
                    lastLocation.setCoordinate(coordinate);
                break;
            default: 
                coordinate = new Coordinates(lastLocation.getCoordinate().getX(), lastLocation.getCoordinate().getY());
                coordinate.setX(coordinate.getX() - 1);
                if(validateCoordinates(coordinate))
                    lastLocation.setCoordinate(coordinate);
                break;
        }
    }    
    
    private boolean validateCoordinates(Coordinates coordinate){
        int x = square.getLowerLeftCoordinate().getX();
        int y = square.getLowerLeftCoordinate().getY();
        
        if((coordinate.getX() < x) || (coordinate.getY() < y))
            return false;
        
        x = square.getUpperRightCoordinate().getX();
        y = square.getUpperRightCoordinate().getY();
        
        if((coordinate.getX() > x) || (coordinate.getY() > y))
            return false;
        
        return true;
    }
     
    private void ValidateSettings(){
        if(lastLocation == null || square == null)
            throw new UnsupportedOperationException("to continue you must configure me"); 
    }
 }