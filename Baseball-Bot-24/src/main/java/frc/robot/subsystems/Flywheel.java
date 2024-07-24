// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.math.filter.SlewRateLimiter;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;


public class Flywheel extends SubsystemBase {
  private TalonSRX flywheelLead;
  private TalonSRX flywheelFollower;
  private TalonSRX indexer;

  private SlewRateLimiter flywheelSlewRateLimiter;

  /** Creates a new Shooter. */
  public Flywheel() {
    flywheelLead = new TalonSRX(0);
    flywheelFollower = new TalonSRX(1);
    indexer = new TalonSRX(2);

    flywheelSlewRateLimiter = new SlewRateLimiter(0.2);

    flywheelLead.setInverted(true);
    flywheelFollower.follow(flywheelLead);

    indexer.setInverted(true);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
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

  public void indexerSpeed(double speed) {
    indexer.set(TalonSRXControlMode.PercentOutput, speed);
  }
  
}
