// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.ColorMatch;
import com.revrobotics.ColorMatchResult;
import com.revrobotics.ColorSensorV3;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class CapteurCouleur extends SubsystemBase {

  // Capteur de couleur
  ColorSensorV3 capteurCouleur = new ColorSensorV3(I2C.Port.kOnboard);
  private final ColorMatch colorMatcher = new ColorMatch();
  private final Color kCouleurCone = new Color(0.359, 0.485, 0.158);
  private final Color kCouleurCube = new Color(0.26, 0.429, 0.311);

  String colorString;
  ColorMatchResult comparaisonCouleur;

  public CapteurCouleur() {
    colorMatcher.addColorMatch(kCouleurCube);
    colorMatcher.addColorMatch(kCouleurCone);
  }

  @Override
  public void periodic() {
   /*SmartDashboard.putNumber("Proximite", capteurCouleur.getProximity());
    SmartDashboard.putNumber("Rouge", getCouleur().red);
    SmartDashboard.putNumber("Vert", getCouleur().green);
    SmartDashboard.putNumber("Bleu", getCouleur().blue);*/
    SmartDashboard.putBoolean("Cone?", isCone());
    SmartDashboard.putBoolean("Cube?", isCube());
  }

  public Color getCouleur() {
    return capteurCouleur.getColor();
  }

  public Color comparerCouleur() {
    comparaisonCouleur = colorMatcher.matchClosestColor(getCouleur());
    return comparaisonCouleur.color;
  }

  public boolean isDetected() {
    return capteurCouleur.getProximity() > 115;
  }

  public boolean isCone() {

    return comparerCouleur() == kCouleurCone && isDetected();
  }

  public boolean isCube() {
    return comparerCouleur() == kCouleurCube && isDetected();
  }
}
