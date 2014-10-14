package br.robotic.rover.lib.util;

public class IntegerExtension {
    
    public static boolean tryParsePositiveIntAndZero(String value)  
    {  
        try  
        {  
            if(Integer.parseInt(value) >= 0) 
                return true;
            else
                return false;
        }     
        catch(NumberFormatException ex)  
        {  
          return false;  
        }  
    }
}
