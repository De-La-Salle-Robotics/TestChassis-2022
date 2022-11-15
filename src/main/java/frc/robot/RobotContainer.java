// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;

import static frc.robot.Constants.*;

import frc.robot.commands.TeleopDriveCommand;
import frc.robot.commands.LEDCommand;
import frc.robot.subsystems.DriveBaseSubsystem;
import frc.robot.subsystems.LEDSubsystem;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...

  private final DriveBaseSubsystem m_driveBaseSubsystem = new DriveBaseSubsystem();
  private final TeleopDriveCommand m_teleopDriveCommand = new TeleopDriveCommand(leftTrigger, rightTrigger, rightJoyStickX, leftBumper, m_driveBaseSubsystem);

  private final LEDSubsystem m_LEDSubsystem = new LEDSubsystem();
  private final LEDCommand m_LEDCommand = new LEDCommand(button_A, button_Y, ()->{return !DriverStation.isEnabled();}, m_LEDSubsystem);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();

    m_driveBaseSubsystem.setDefaultCommand(m_teleopDriveCommand);
    m_LEDSubsystem.setDefaultCommand(m_LEDCommand);

  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {}

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return null;
  }
}
