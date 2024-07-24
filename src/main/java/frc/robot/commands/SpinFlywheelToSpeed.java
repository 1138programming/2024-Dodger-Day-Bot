

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Hood;
import frc.robot.subsystems.HoodSubsystem;

public class SpinFlywheelToSpeed extends Command {
  private final Hood hoodSubsystem;
  private final double speed;

  public SpinFlywheelToSpeed(HoodSubsystem hoodSubsystem, double speed) {
    this.hoodSubsystem = hoodSubsystem;
    this.speed = speed;
    addRequirements(hoodSubsystem);
  }

  @Override
  public void initialize() {
      this.hoodSubsystem.setHood(speed);
  }
}
