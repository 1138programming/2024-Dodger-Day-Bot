// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.commands.DriveWithJoysticks;
import frc.robot.commands.MoveHood;
import frc.robot.commands.MoveTurret;
import frc.robot.commands.SpinFlywheelToSpeed;
import frc.robot.commands.SpinIndexer;
import frc.robot.commands.StopCommands.StopFlywheel;
import frc.robot.commands.StopCommands.StopHood;
import frc.robot.commands.StopCommands.StopIndexer;
import frc.robot.commands.StopCommands.StopTurret;
import frc.robot.subsystems.Base;
import frc.robot.subsystems.Flywheel;
import frc.robot.subsystems.Indexer;
import frc.robot.subsystems.Turret;
import frc.robot.subsystems.Hood;

import static frc.robot.Constants.*;

/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in
 * the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of
 * the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // Subsystems
  private final Base base = new Base();
  private final Indexer indexer = new Indexer();
  private final Hood hood = new Hood();
  private final Turret turret = new Turret();
  private final Flywheel flywheel = new Flywheel();

  // Commands
  private final DriveWithJoysticks driveWithJoysticks = new DriveWithJoysticks(base);
  private final MoveHood moveHoodUp = new MoveHood(hood, KHoodMoveSpeed);
  private final MoveHood moveHoodDown = new MoveHood(hood, -KHoodMoveSpeed);
  private final MoveTurret moveTurretRight = new MoveTurret(turret, KTurretMoveSpeed);
  private final MoveTurret moveTurretLeft = new MoveTurret(turret, -KTurretMoveSpeed);
  private final SpinFlywheelToSpeed spinFlywheelToSpeed = new SpinFlywheelToSpeed(flywheel);
  private final SpinIndexer spinIndexer = new SpinIndexer(indexer, KTurretMoveSpeed);

  // private final BaseStop baseStop = new BaseStop(base);
  private final StopHood stopHood = new StopHood(hood);
  private final StopTurret stopTurret = new StopTurret(turret);
  private final StopFlywheel stopFlywheel = new StopFlywheel(flywheel);
  private final StopIndexer stopIndexer = new StopIndexer(indexer);

  // Logi Buttons
  public static Joystick logitech;

  public JoystickButton logitechBtnX, logitechBtnA, logitechBtnB, logitechBtnY, logitechBtnLB, logitechBtnRB,
      logitechBtnLT, logitechBtnRT; // Logitech Button

  public RobotContainer() {
    base.setDefaultCommand(driveWithJoysticks);
    hood.setDefaultCommand(stopHood);
    turret.setDefaultCommand(stopTurret);
    flywheel.setDefaultCommand(stopFlywheel);
    indexer.setDefaultCommand(stopIndexer);

    logitech = new Joystick(KLogitechPort);

    // Logitch Buttons
    logitechBtnX = new JoystickButton(logitech, KLogitechButtonX);
    logitechBtnA = new JoystickButton(logitech, KLogitechButtonA);
    logitechBtnB = new JoystickButton(logitech, KLogitechButtonB);
    logitechBtnY = new JoystickButton(logitech, KLogitechButtonY);
    logitechBtnLB = new JoystickButton(logitech, KLogitechLeftBumper);
    logitechBtnRB = new JoystickButton(logitech, KLogitechRightBumper);
    logitechBtnLT = new JoystickButton(logitech, KLogitechLeftTrigger);
    logitechBtnRT = new JoystickButton(logitech, KLogitechRightTrigger);

    configureBindings();
  }

  /**
   * Use this method to define your trigger->command mappings. Triggers can be
   * created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with
   * an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for
   * {@link
   * CommandXboxController
   * Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or
   * {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */
  private void configureBindings() {
    logitechBtnRB.whileTrue(spinFlywheelToSpeed);
    logitechBtnLB.whileTrue(spinIndexer);
    logitechBtnX.whileTrue(moveTurretLeft);
    logitechBtnB.whileTrue(moveTurretRight);
    logitechBtnY.whileTrue(moveHoodUp);
    logitechBtnA.whileTrue(moveHoodDown);

    // Swerve Controls

  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    return null;
  }

  public double getLogiRightYAxis() {
    final double Y = logitech.getRawAxis(KRightYAxis);
    SmartDashboard.putNumber("getLogiRightYAxis", -Y);
    if (Y > KDeadZone || Y < -KDeadZone)
      return -Y;
    else
      return 0;
  }

  public double getLogiLeftYAxis() {
    final double Y = logitech.getY();
    SmartDashboard.putNumber("getLogiLeftYAxis", -Y);
    if (Y > KDeadZone || Y < -KDeadZone)
      return -Y;
    else
      return 0;
  }

  public double getLogiRightXAxis() {
    double X = logitech.getZ();
    SmartDashboard.putNumber("getLogiRightXAxis", -X);
    if (X > KDeadZone || X < -KDeadZone) {
      return -X;
    } else {
      return 0;
    }
  }

  public double getLogiLeftXAxis() {
    double X = logitech.getX();
    SmartDashboard.putNumber("getLogiLeftXAxis", -X);
    if (X > KDeadZone || X < -KDeadZone) {
      return -X;
    } else {
      return 0;
    }
  }
}
