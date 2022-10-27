package frc.robot.commands;

import java.util.function.BooleanSupplier;
import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveBaseSubsystem;

public class TeleopDriveCommand extends CommandBase {
    
    private DoubleSupplier m_rightJoystick;
    private DoubleSupplier m_leftJoystick;
    private BooleanSupplier m_leftBumper;
    private BooleanSupplier m_rightBumper;
    private double speedControl;
    private DriveBaseSubsystem m_DriveBaseSubsystem;

    public TeleopDriveCommand(DoubleSupplier leftJoystick, DoubleSupplier rightJoystick, BooleanSupplier leftBumper, BooleanSupplier rightBumper, DriveBaseSubsystem driveBaseSubsystem){

        m_leftJoystick = leftJoystick;
        m_rightJoystick = rightJoystick;
        m_leftBumper = leftBumper;
        m_rightBumper = rightBumper;
        m_DriveBaseSubsystem = driveBaseSubsystem;
        addRequirements(m_DriveBaseSubsystem);

    }

    @Override
    public void initialize(){
        speedControl = 0.25;
        m_DriveBaseSubsystem.chassisControl(0, 0, speedControl);
    }

    @Override
    public void execute(){

        if (m_leftBumper.getAsBoolean()){
            speedControl = 1;
        }
        if (m_rightBumper.getAsBoolean()){
            speedControl = 0.25;
        }

        //The left joystick is negative due to the controller being in pilot/flight mode
        m_DriveBaseSubsystem.chassisControl(-m_leftJoystick.getAsDouble(), m_rightJoystick.getAsDouble(), speedControl);
    }

    @Override
    public void end(boolean interrupted){
        speedControl = 0.25;
        m_DriveBaseSubsystem.chassisControl(0, 0, speedControl);
    }

    @Override
    public boolean isFinished(){
        return false;
    }

}
