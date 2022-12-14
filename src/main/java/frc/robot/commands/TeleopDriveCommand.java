package frc.robot.commands;

import java.util.function.BooleanSupplier;
import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveBaseSubsystem;

public class TeleopDriveCommand extends CommandBase {
    
    private DoubleSupplier m_leftTrigger;
    private DoubleSupplier m_rightTrigger;
    private DoubleSupplier m_rightJoystick;

    private BooleanSupplier m_leftBumper;
    private double speedControl;

    private DriveBaseSubsystem m_DriveBaseSubsystem;

    public TeleopDriveCommand(DoubleSupplier leftTrigger, DoubleSupplier rightTrigger, DoubleSupplier rightJoystick, BooleanSupplier leftBumper, DriveBaseSubsystem driveBaseSubsystem){

        m_leftTrigger = leftTrigger;
        m_rightTrigger = rightTrigger;
        m_rightJoystick = rightJoystick;

        m_leftBumper = leftBumper;

        m_DriveBaseSubsystem = driveBaseSubsystem;
        addRequirements(m_DriveBaseSubsystem);

    }

    @Override
    public void initialize(){
        speedControl = 0.25;
        m_DriveBaseSubsystem.chassisControl(0.0, 0.0, 0.0, speedControl);
    }

    @Override
    public void execute(){

        if (m_leftBumper.getAsBoolean()){
            speedControl = 0.25;
        }
        else{
            speedControl = 0.5;
        }

        //The left joystick is negative due to the controller being in pilot/flight mode
        m_DriveBaseSubsystem.chassisControl(m_leftTrigger.getAsDouble(), m_rightTrigger.getAsDouble(), m_rightJoystick.getAsDouble(), speedControl);
    }

    @Override
    public void end(boolean interrupted){
        speedControl = 0.25;
        m_DriveBaseSubsystem.chassisControl(0.0, 0.0, 0.0, speedControl);
    }

    @Override
    public boolean isFinished(){
        return false;
    }

}
