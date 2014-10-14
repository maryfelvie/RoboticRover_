
package br.robotic.rover.lib;

import br.robotic.rover.lib.Enum.CardinalPoints;

public class Location {
    private Coordinates coordinate;
    private CardinalPoints cardinalPoint; 
    
    public Location(){}
    
    public Location(Coordinates coordinate, CardinalPoints cardinalPoint){
        if(coordinate == null || cardinalPoint == null)
            throw new IllegalArgumentException("Coordinates and Cardinal Points is required to this constructor");
        
        this.coordinate = coordinate;
        this.cardinalPoint = cardinalPoint;
    }
    
    public Coordinates getCoordinate(){
        return coordinate;
    }
    
    public CardinalPoints getCardinalPoints(){
        return cardinalPoint;
    }
    
    public void setCoordinate(Coordinates coordinate){
        if(coordinate == null)
            throw new IllegalArgumentException("Coordinates can't be null");
        
        this.coordinate = coordinate;   
    }
    
    public void setCardinalPoints(CardinalPoints cardinalPoint){
        if(cardinalPoint == null)
            throw new IllegalArgumentException("Cardinal Points can't be null");
        
        this.cardinalPoint = cardinalPoint;   
    }
    
    public static Location ConvertToLocation(String input){
        if(input.isEmpty())
            throw new IllegalArgumentException("input is empty");
        
        String[] splited = input.split("\\s+");
        
        if(splited.length != 3)
            throw new IllegalArgumentException("input must have two numbers and one valid letter");
        
        Coordinates coordinate = Coordinates.ConvertToCoordinates(String.format("%s %s", splited[0], splited[1]));
        
        CardinalPoints cardinalPoints = CardinalPoints.fromString(splited[2]);
        if(cardinalPoints == null)
            throw new IllegalArgumentException("input must have two numbers and one valid letter");
        
        return new Location(coordinate, cardinalPoints);
    }
}
