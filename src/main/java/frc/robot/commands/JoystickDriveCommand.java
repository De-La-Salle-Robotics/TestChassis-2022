package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveBaseSubsystem;

public class JoystickDriveCommand extends CommandBase {
    
    private DoubleSupplier m_rightJoystick;
    private DoubleSupplier m_leftJoystick;
    private DriveBaseSubsystem m_DriveBaseSubsystem;

    public JoystickDriveCommand(DoubleSupplier leftJoystick, DoubleSupplier rightJoystick, DriveBaseSubsystem driveBaseSubsystem){

        m_leftJoystick = leftJoystick;
        m_rightJoystick = rightJoystick;
        m_DriveBaseSubsystem = driveBaseSubsystem;
        addRequirements(m_DriveBaseSubsystem);

    }

    @Override
    public void initialize(){
        m_DriveBaseSubsystem.chassisControl(0, 0);
    }

    @Override
    public void execute(){
        //The left joystick is negative due to the controller being in pilot/flight mode
        m_DriveBaseSubsystem.chassisControl(-m_leftJoystick.getAsDouble(), m_rightJoystick.getAsDouble());
    }

    @Override
    public void end(boolean interrupted){
        m_DriveBaseSubsystem.chassisControl(0, 0);
    }

    @Override
    public boolean isFinished(){
        return false;
    }

}
