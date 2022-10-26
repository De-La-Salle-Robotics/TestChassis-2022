package frc.robot.commands;

import java.util.function.BooleanSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.LEDSubsystem;

public class LEDCommand extends CommandBase{
    
    private LEDSubsystem m_LEDSubsystem;
    private BooleanSupplier m_A;
    private BooleanSupplier m_Y;
    private BooleanSupplier m_B;

    public LEDCommand(BooleanSupplier A, BooleanSupplier Y, BooleanSupplier B, LEDSubsystem ledSubsystem)
    {
        m_A = A;
        m_Y = Y;
        m_B = B;
        m_LEDSubsystem = ledSubsystem;
        addRequirements(m_LEDSubsystem);
    }

    @Override
    public void execute(){
        m_LEDSubsystem.updateLED0(m_A.getAsBoolean(), m_Y.getAsBoolean(), m_B.getAsBoolean());
    }

    @Override
    public void initialize(){
        m_LEDSubsystem.initializeLED0();
    }

    @Override
    public void end(boolean interrupted){
        
    }

    @Override
    public boolean isFinished(){
        return false;
    }

}
