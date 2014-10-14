
package br.robotic.rover.app;
import java.io.*;
import br.robotic.rover.lib.AbstractRoverCommand;
import br.robotic.rover.lib.Coordinates;
import br.robotic.rover.lib.Enum.Action;
import br.robotic.rover.lib.Location;
import br.robotic.rover.lib.Rover;
import br.robotic.rover.lib.RoverCommand;
import br.robotic.rover.lib.Square;

public class Program {
    
    public static void main(String[] args) {
        
            boolean resetArea = true;
            boolean informPosition = false;
            boolean questionPlateau = false;
            String plateauArea = "";
            boolean stop = false;
            Square square = null;
            
            while(!stop){

                if(resetArea){
                    
                    try{
                        System.out.println("**********Type the plateau area **********");

                        InputStreamReader in=new InputStreamReader(System.in);
                        BufferedReader br = new BufferedReader(in);
                        plateauArea = br.readLine();

                        Coordinates squareCoordinate = Coordinates.ConvertToCoordinates(plateauArea);
                        square = new Square(squareCoordinate);
                        
                        resetArea = false;
                        informPosition = true;
                    }
                    catch (IllegalArgumentException ex) {
                         System.out.println(String.format("*********An error has occurred: %s **********", ex.getMessage())); 
                    }
                    catch (IOException ex) {
                        System.out.println("*********Invalid values **********"); 
                    }
                    catch(Exception ex){
                         System.out.println("*********An error has occurred **********"); 
                    }
                }
                if(informPosition){
                    try{
                        
                        Rover rover1 = new Rover(square);
                        System.out.println("**********Type the rover position **********");

                        InputStreamReader in = new InputStreamReader(System.in);
                        BufferedReader br = new BufferedReader(in);
                        String roverPosition = br.readLine();

                        System.out.println("**********Type sequence of commands **********");

                        in = new InputStreamReader(System.in);
                        br = new BufferedReader(in);
                        String commands = br.readLine();
                        
                        Location roverLocation = Location.ConvertToLocation(roverPosition);

                        rover1.setLastLocation(roverLocation);
                        AbstractRoverCommand command = new RoverCommand(rover1);

                        int totalLenght = commands.length();
                        char[] charCommands = commands.toCharArray();

                        for(int i = 0; i < totalLenght; i += 1) {
                            String cmd = Character.toString(charCommands[i]);
                            Action action = Action.fromString(cmd);

                            if (action == null)
                                throw new IllegalArgumentException("Invalid Command.");

                            command.execute(action);
                        }
                       
                        System.out.println("Result is: " + rover1.getLocationFriendly());
                            
                        informPosition = false;
                        questionPlateau = true;
                    }
                    catch (IOException ex) {
                          System.out.println("*********Invalid values **********"); 
                    }
                    catch (IllegalArgumentException ex) {
                         System.out.println(String.format("*********An error has occurred: %s **********", ex.getMessage()));
                    }
                    catch(UnsupportedOperationException ex){
                         System.out.println(String.format("*********An error has occurred: %s **********", ex.getMessage()));
                    }
                    catch(Exception ex){
                         System.out.println("*********An error has occurred **********"); 
                    }
                }
                if(questionPlateau){
                    try{
                        System.out.println("**********Would you like reset the plateau area?(Y/N), type E to exit **********");
                        InputStreamReader in = new InputStreamReader(System.in);
                        BufferedReader br = new BufferedReader(in);
                        String shouldResetArea = br.readLine();
                        
                        if(shouldResetArea.equalsIgnoreCase("N") || shouldResetArea.equalsIgnoreCase("Y") || shouldResetArea.equalsIgnoreCase("E")){
                            if(shouldResetArea.equalsIgnoreCase("E")){
                                stop = true;
                                System.out.println("**********Good bye! **********");
                            }
                            else{
                                questionPlateau = false;
                            
                                if(shouldResetArea.equalsIgnoreCase("Y"))
                                    resetArea = true;
                                else
                                    informPosition = true;
                            }
                        }
                    }
                    catch(Exception ex){
                        System.out.println("*********Invalid values **********"); 
                    }
                }   
            }    
    }
}
