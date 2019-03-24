package org.usfirst.frc1337.Ri3D2019.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import org.usfirst.frc1337.Ri3D2019.Robot;
import org.usfirst.frc1337.Ri3D2019.commands.Driving;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

// This is the way we brush our teeth, brush our teeth, brush our teeth

public class Drivetrain extends Subsystem {

    private WPI_TalonSRX fL;
    private WPI_TalonSRX fR;
    private WPI_TalonSRX rL;
    private WPI_TalonSRX rR;
    private SpeedControllerGroup driveControl;
    private SpeedControllerGroup driveControl2;
    private DifferentialDrive differentialDrive;

    public Drivetrain() {

        fL = new WPI_TalonSRX(1);
        addChild("FL",fL);
        fL.setInverted(false);
        
        fR = new WPI_TalonSRX(3);
        addChild("FR",fR);
        fR.setInverted(false);
        
        rL = new WPI_TalonSRX(4);
        addChild("RL",rL);
        rL.setInverted(false);

        rR = new WPI_TalonSRX(2);
        addChild("RR",rR);
        rR.setInverted(false);
        
        driveControl = new SpeedControllerGroup(fL, rL);
        driveControl2 = new SpeedControllerGroup(fR, rR);
        addChild("DriveControl",driveControl);
        addChild("DriveControl2",driveControl2);
        
        
        differentialDrive = new DifferentialDrive(driveControl, driveControl2);
        
        differentialDrive.setSafetyEnabled(true);
        differentialDrive.setExpiration(0.1);
        differentialDrive.setMaxOutput(1);
        differentialDrive.setRightSideInverted(true);
        differentialDrive.setDeadband(.06);
        
    }

    public void driveeeee(){
        differentialDrive.arcadeDrive(Robot.oi.driver.getRawAxis(1) * -1, Robot.oi.driver.getRawAxis(4), true);
        //differentialDrive.tankDrive(Robot.oi.driver.getRawAxis(1), Robot.oi.driver.getRawAxis(5), false);
        //System.out.println(Robot.oi.driver.getY());
        //\System.out.println(Robot.oi.driver.getX());
    }

    @Override
    public void initDefaultCommand() {
            setDefaultCommand(new Driving());

        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }

    @Override
    public void periodic() {
        // Put code here to be run every loop

    }

}

