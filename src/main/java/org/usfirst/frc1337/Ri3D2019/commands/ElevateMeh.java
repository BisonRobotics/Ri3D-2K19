package org.usfirst.frc1337.Ri3D2019.commands;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc1337.Ri3D2019.Robot;
import org.usfirst.frc1337.Ri3D2019.subsystems.Elevator;


public class ElevateMeh extends Command {

    private String position;
    private boolean testingMode = false;

    // Overloaded constructor to allow for picking position
    public ElevateMeh(String position) {
    requires(Robot.elevator);
    this.position = position;

    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
        switch(position){

            case "bottom" :
            if(testingMode)
            Robot.elevator.lower(SmartDashboard.getNumber("Speed (0 to 1 range)", 0));
            else{Robot.elevator.lower(1);}
            break;
       
            case "middle" :
            break;
    
            case "top" :
            if(testingMode)
            Robot.elevator.raise(SmartDashboard.getNumber("Speed (0 to 1 range)", 0));
            else{Robot.elevator.raise(1);}
            break;
    
        default : 
          break;
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {
        Robot.elevator.shutdown();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
        Robot.elevator.shutdown();
    }
}
