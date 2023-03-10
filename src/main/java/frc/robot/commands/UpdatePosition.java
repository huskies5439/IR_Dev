// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.BasePilotable;
import frc.robot.subsystems.Limelight;

public class UpdatePosition extends CommandBase {
  Limelight limelight;
  BasePilotable basePilotable;
  /** Creates a new UpdatePosition. */
  public UpdatePosition(Limelight limelight, BasePilotable basePilotable) {
    this.limelight = limelight;
    this.basePilotable = basePilotable;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(limelight);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    //limelight.setAlliance();

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(limelight.getTv() && limelight.getTa() > 1){
      basePilotable.addVisionMeasurement(limelight.getVisionPosition().toPose2d(), limelight.getTl()/1000.0);

    }

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
