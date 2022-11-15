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

    public double speedControl;

    public DriveBaseSubsystem(){
        addChild("Right Leader", m_rightLeader);
        addChild("Right Middle", m_rightMiddle);
        addChild("Right Back", m_rightBack);

        addChild("Left Leader", m_leftLeader);
        addChild("Left Middle", m_leftMiddle);
        addChild("Left Back", m_leftBack);

        /* Factory default all devices to default settings */
        m_rightLeader.configFactoryDefault();
        m_rightMiddle.configFactoryDefault();
        m_rightBack.configFactoryDefault();
        m_leftLeader.configFactoryDefault();
        m_leftMiddle.configFactoryDefault();
        m_leftBack.configFactoryDefault();

    }

    public void chassisControl(double leftTrigger, double rightTrigger, double rightJoyStick, double speedControl){

        double triggerInput = rightTrigger - leftTrigger;
        double leftSidePower = (triggerInput + rightJoyStick) * speedControl;
        double rightSidePower = (triggerInput - rightJoyStick) * speedControl;

        m_rightLeader.set(ControlMode.PercentOutput, rightSidePower);
        m_rightMiddle.set(ControlMode.PercentOutput, rightSidePower);
        m_rightBack.set(ControlMode.PercentOutput, rightSidePower);

        m_leftLeader.set(ControlMode.PercentOutput, leftSidePower);
        m_leftMiddle.set(ControlMode.PercentOutput, leftSidePower);
        m_leftBack.set(ControlMode.PercentOutput, leftSidePower);

        return;
    }
}
