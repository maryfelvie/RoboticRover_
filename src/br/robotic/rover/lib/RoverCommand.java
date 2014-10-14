package br.robotic.rover.lib;

import br.robotic.rover.lib.Enum.Action;

public class RoverCommand extends AbstractRoverCommand {

    public RoverCommand(Rover rover){
      super(rover);
    }

    @Override
    public void execute(Action action) {

        switch(action){
            case L:
                rover.spinLeft();
                break;
            case R:
                rover.spinRight();
                break;
            default:
                rover.Move();
                break;
        }
    } 
}
