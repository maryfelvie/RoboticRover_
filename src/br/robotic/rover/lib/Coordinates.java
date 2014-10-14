package br.robotic.rover.lib;
import br.robotic.rover.lib.util.IntegerExtension;
public class Coordinates {
    private int x;
    private int y;
    
    public Coordinates(){}
    
    public Coordinates(int x, int y){
        this.x = x;
        this.y = y;
    }
            
    public int getX(){
        return x;
    }
    
    public void setX(int x){
        
        
        this.x = x;
    }
    
    public int getY(){
        return y;
    }
            
    public void setY(int y){
        
        
        this.y = y;
    }
    
    public static Coordinates ConvertToCoordinates(String input){
        if(input.isEmpty())
            throw new IllegalArgumentException("input is empty");
        
        String[] splited = input.split("\\s+");
        
        if(splited.length != 2)
            throw new IllegalArgumentException("input must have two numbers");
        
        if(!IntegerExtension.tryParsePositiveIntAndZero(splited[0]) || !IntegerExtension.tryParsePositiveIntAndZero(splited[1]))
            throw new IllegalArgumentException("input must have two positive integer numbers");
        
        Coordinates coordinates = new Coordinates(Integer.parseInt(splited[0]), Integer.parseInt(splited[1]));
        
        return coordinates;
    }
         
}
