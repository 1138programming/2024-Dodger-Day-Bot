// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Base extends SubsystemBase {
  private final TalonSRX leftLead;
  private final TalonSRX leftFollow1;
  private final TalonSRX leftFollow2;

  private final TalonSRX rightLead;
  private final TalonSRX rightFollow1;
  private final TalonSRX rightFollow2;

  public Base() {
    leftLead = new TalonSRX(36);
    leftFollow1 = new TalonSRX(35);
    leftFollow2 = new TalonSRX(20);

    rightLead = new TalonSRX(16);
    rightFollow1 = new TalonSRX(25);
    rightFollow2 = new TalonSRX(27);

    leftFollow1.follow(leftLead);
    leftFollow2.follow(leftLead);
    rightFollow1.follow(rightLead);
    rightFollow2.follow(rightLead);

    rightFollow1.setInverted(InvertType.FollowMaster);
    rightFollow2.setInverted(InvertType.FollowMaster);
    rightLead.setInverted(true);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void setRight(double speed) {
    rightLead.set(ControlMode.PercentOutput, speed);
  }

  public void setLeft(double speed) {
    leftLead.set(ControlMode.PercentOutput, speed);
  }
}
