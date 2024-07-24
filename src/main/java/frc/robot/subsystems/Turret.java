// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import static frc.robot.Constants.KTurretMotorID;

import com.ctre.phoenix6.configs.SoftwareLimitSwitchConfigs;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Turret extends SubsystemBase {
  private TalonFX turretMotor;
  private TalonFXConfiguration turretMotorConfig;
  private SoftwareLimitSwitchConfigs limitSwitchConfigs;
  private boolean limitsEnabled;

  /** Creates a new Turret. */
  public Turret() {
    turretMotor = new TalonFX(KTurretMotorID);

    turretMotor.setPosition(0);
    turretMotorConfig = new TalonFXConfiguration();
    limitsEnabled = true;

    SmartDashboard.putBoolean("Turret encoder limits", this.limitsEnabled);
        this.limitSwitchConfigs = new SoftwareLimitSwitchConfigs()
                .withReverseSoftLimitEnable(this.limitsEnabled)
                .withReverseSoftLimitThreshold(turretRotationsToTurretMotorRotations(-0.45))
                .withForwardSoftLimitEnable(this.limitsEnabled)
                .withForwardSoftLimitThreshold(turretRotationsToTurretMotorRotations(0.45));

        turretMotor.getConfigurator().apply(this.turretMotorConfig);
        turretMotor.getConfigurator().apply(this.limitSwitchConfigs);
  }

  @Override
  public void periodic() {
     SmartDashboard.putNumber("Rotations", turretMotorRotationsToTurretRotations(this.turretMotor.getPosition().getValueAsDouble()));
  }

  public static double turretRotationsToTurretMotorRotations(double turretRots) {
    return turretRots
        * 36.0 /* 36:1 gear ratio */
        / 20.0 /* 1:20 gear ratio (maybe???) */
        * 140.0 /* 140:1 gear ratio (approx) */;
  }

  public static double turretMotorRotationsToTurretRotations(double motorRots) {
    return motorRots
        / 36.0 /* 36:1 gear ratio */
        * 20.0 /* 1:20 gear ratio (maybe???) */
        / 140.0 /* 140:1 gear ratio (approx) */;
  }
  
  public void setSpeed(double speed) {
    turretMotor.set(speed);
  }

  public boolean getLimitsEnabled() {
    return this.limitsEnabled;
  }

}
