// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.commands.ArcadeDriveCmd;
import frc.robot.commands.ExampleCommand;
//import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.subsystems.CameraSubsystem;
import frc.robot.subsystems.ShooterButtonSubsystem;
import frc.robot.subsystems.DriveSubsystem;





/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  //private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();
  private final CameraSubsystem CameraSubsystem = new CameraSubsystem();
  private final DriveSubsystem driveSubsystem = new DriveSubsystem();
  private final ShooterButtonSubsystem ShooterButtonSubsystem = new ShooterButtonSubsystem();

  private double tolerance = 0.2;

  // Replace with CommandPS4Controller or CommandJoystick if needed
  private final CommandXboxController controller_uno = new CommandXboxController(0);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the trigger bindings
    configureBindings();

    
      driveSubsystem.setDefaultCommand(new ArcadeDriveCmd(driveSubsystem,() -> controller_uno.getRawAxis(1), () -> controller_uno.getRawAxis(4), 0.8));
      controller_uno.b().whileTrue(ShooterButtonSubsystem.buttonClickerCommand(-4, 0.001, 1)).whileFalse(ShooterButtonSubsystem.buttonClickerCommand(0,0.001, 1));
//      ShooterButtonSubsystem.ButtonMotorCommand(controller_uno.getRightTriggerAxis());
      }

  /**
   * 
   * Use this method to define your trigger->command mappings. Triggers can be created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for {@link
   * CommandXboxController Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */
  private void configureBindings() {
    // Schedule `ExampleCommand` when `exampleCondition` changes to `true`
    // new Trigger(m_exampleSubsystem::exampleCondition)
    //     .onTrue(new ExampleCommand(m_exampleSubsystem));

    // Schedule `exampleMethodCommand` when the Xbox controller's B button is pressed,
    // cancelling on release.
    //m_driverController.b().whileTrue(m_exampleSubsystem.exampleMethodCommand());
   // controller_uno.b().whileTrue(ShooterButtonSubsystem.buttonClickerCommand(5, 0.2)).whileFalse(ShooterButtonSubsystem.buttonClickerCommand(0,0.2));
    //ShooterButtonSubsystem.ButtonMotorCommand(controller_uno.getRightTriggerAxis());


  }
}