package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.pilotlib.ctrwrappers.PilotFX;

import static frc.robot.Constants.*;

import com.ctre.phoenix.motorcontrol.ControlMode;

public class DriveBaseSubsystem extends SubsystemBase {
    
    private PilotFX m_rightLeader = new PilotFX(Right_Leader_ID);
    private PilotFX m_rightMiddle = new PilotFX(Right_Middle_ID);
    private PilotFX m_rightBack = new PilotFX(Right_Back_ID);

    private PilotFX m_leftLeader = new PilotFX(Left_Leader_ID);
    private PilotFX m_leftMiddle = new PilotFX(Left_Middle_ID);
    private PilotFX m_leftBack = new PilotFX(Left_Back_ID);

    public DriveBaseSubsystem(){
        addChild("Right Leader", m_rightLeader);
        addChild("Right Middle", m_rightMiddle);
        addChild("Right Back", m_rightBack);

        addChild("Left Leader", m_leftLeader);
        addChild("Left Middle", m_leftMiddle);
        addChild("Left Back", m_leftBack);


    }

    public void chassisControl(double leftJoyStick, double rightJoyStick){

        double leftSidePower = leftJoyStick + rightJoyStick;
        double rightSidePower = leftJoyStick - rightJoyStick;

        m_rightLeader.set(ControlMode.PercentOutput, rightSidePower);
        m_rightMiddle.set(ControlMode.PercentOutput, rightSidePower);
        m_rightBack.set(ControlMode.PercentOutput, rightSidePower);

        m_leftLeader.set(ControlMode.PercentOutput, leftSidePower);
        m_leftMiddle.set(ControlMode.PercentOutput, leftSidePower);
        m_leftBack.set(ControlMode.PercentOutput, leftSidePower);

    }
}
