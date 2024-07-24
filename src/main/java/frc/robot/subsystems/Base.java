// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import static frc.robot.Constants.KleftFollow1ID;
import static frc.robot.Constants.KleftFollow2ID;
import static frc.robot.Constants.KleftLeadID;
import static frc.robot.Constants.KrightFollow1ID;
import static frc.robot.Constants.KrightFollow2ID;
import static frc.robot.Constants.KrightLeadID;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Base extends SubsystemBase {
  private TalonSRX leftLead;
  private TalonSRX leftFollow1;
  private TalonSRX leftFollow2;

  private TalonSRX rightLead;
  private TalonSRX rightFollow1;
  private TalonSRX rightFollow2;

  public Base() {
    leftLead = new TalonSRX(KleftLeadID);
    leftFollow1 = new TalonSRX(KleftFollow1ID);
    leftFollow2 = new TalonSRX(KleftFollow2ID);

    rightLead = new TalonSRX(KrightLeadID);
    rightFollow1 = new TalonSRX(KrightFollow1ID);
    rightFollow2 = new TalonSRX(KrightFollow2ID);

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

  public void drive(double left, double right) {
    leftLead.set(ControlMode.PercentOutput, left);
    rightLead.set(ControlMode.PercentOutput, right);
  }

  public void setRight(double speed) {
    rightLead.set(ControlMode.PercentOutput, speed);
  }

  public void setLeft(double speed) {
    leftLead.set(ControlMode.PercentOutput, speed);
  }
}
