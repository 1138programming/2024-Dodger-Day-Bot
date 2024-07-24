

package frc.robot.commands.StopCommands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Hood;

public class StopHood extends Command {
  private final Hood hoodSubsystem;

  public StopHood(Hood hoodSubsystem) {
    this.hoodSubsystem = hoodSubsystem;
    addRequirements(hoodSubsystem);
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() {
    hoodSubsystem.setHood(0);
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
