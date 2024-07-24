

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Hood;

public class MoveHood extends Command {
  private final Hood hoodSubsystem;
  private final double speed;

  public MoveHood(Hood hoodSubsystem, double speed) {
    this.hoodSubsystem = hoodSubsystem;
    this.speed = speed;
    addRequirements(hoodSubsystem);
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() {
    hoodSubsystem.setHood(speed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
