package br.robotic.rover.lib;

import br.robotic.rover.lib.Enum.Action;

public abstract class AbstractRoverCommand {
    protected Rover rover;  
    
    public AbstractRoverCommand(Rover rover){
        this.rover = rover;
    }
    
    public abstract void execute(Action action);
}
