// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.math.filter.SlewRateLimiter;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import static frc.robot.Constants.*;

import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;


public class Flywheel extends SubsystemBase {
  private TalonSRX flywheelLead;
  private TalonSRX flywheelFollower;

  private SlewRateLimiter flywheelSlewRateLimiter;

  /** Creates a new Shooter. */
  public Flywheel() {
    flywheelLead = new TalonSRX(KflywheelLeadMotorID);
    flywheelFollower = new TalonSRX(KFlywheelFollwerMotorID);

    flywheelSlewRateLimiter = new SlewRateLimiter(0.2);

    flywheelLead.setInverted(true);
    flywheelFollower.follow(flywheelLead);

    SmartDashboard.putNumber("Flywheel Speed", KFlywheelSpeed);
  }

  @Override
  public void periodic() {
  }

  public void StopFlywheel() {
    flywheelLead.set(TalonSRXControlMode.PercentOutput, 0);
  }

  public void slewLimitedFlywheelSpin(double speed) {
    flywheelLead.set(TalonSRXControlMode.PercentOutput, flywheelSlewRateLimiter.calculate(speed));
  }

  public void slewLimitedFlywheelSpin(double speed, SlewRateLimiter rateLimiter) {
    flywheelLead.set(TalonSRXControlMode.PercentOutput, rateLimiter.calculate(speed));
  }

  public void FlywheelSpin(double speed) {
    flywheelLead.set(TalonSRXControlMode.PercentOutput, speed);
  }

}
