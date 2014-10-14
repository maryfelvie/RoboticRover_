package br.robotic.rover.lib;

public class Square {
    private Coordinates upperRightCoordinate;
    private Coordinates lowerLeftCoordinate;
    
    public Square(Coordinates upperRightCoordinate,  Coordinates lowerLeftCoordinate){
        
        if(upperRightCoordinate == null || lowerLeftCoordinate == null)
            throw new IllegalArgumentException("Parameter(s) is null");
            
        upperRightCoordinate.setY(upperRightCoordinate.getY() + 1);
        
        this.upperRightCoordinate = upperRightCoordinate;
        this.lowerLeftCoordinate = lowerLeftCoordinate;
    }
    
    public Square(Coordinates upperRightCoordinate){
        if(upperRightCoordinate == null)
            throw new IllegalArgumentException("Parameter is null");
            
        upperRightCoordinate.setY(upperRightCoordinate.getY() + 1);
        
        this.upperRightCoordinate = upperRightCoordinate;
        
        lowerLeftCoordinate = new Coordinates();
        lowerLeftCoordinate.setX(0);
        lowerLeftCoordinate.setY(0);
        
    }
    
    public Coordinates getUpperRightCoordinate(){
        return upperRightCoordinate;
    }
    
    public Coordinates getLowerLeftCoordinate(){
        return lowerLeftCoordinate;
    }
}
