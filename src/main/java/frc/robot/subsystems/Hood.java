// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.TalonSRXConfiguration;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Hood extends SubsystemBase {
  public final TalonSRX hoodMotor; 

  public Hood() {
    hoodMotor = new TalonSRX(6); 
    hoodMotor.configAllSettings(new TalonSRXConfiguration());
  }

  public void setHood(double speed) {
    hoodMotor.set(TalonSRXControlMode.PercentOutput, speed);
  } 
  
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
