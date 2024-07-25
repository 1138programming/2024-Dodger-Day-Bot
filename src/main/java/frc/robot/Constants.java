// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    public static final int KLogitechPort = 0;
    // Deadzone
    public static final double KDeadZone = 0.05;

    // Joystick Axis IDs
    public static final int KLeftXAxis = 0;
    public static final int KLeftYAxis = 1;
    public static final int KRightXAxis = 2;
    public static final int KRightYAxis = 3;

    // Joystick Axis IDs
    public static final int KXboxLeftYAxis = 1;
    public static final int KXboxRightYAxis = 5;
    public static final int KXboxLeftXAxis = 0;
    public static final int KXboxRightXAxis = 4;

    // Logitech Button Constants
    public static final int KLogitechButtonX = 1;
    public static final int KLogitechButtonA = 2;
    public static final int KLogitechButtonB = 3;
    public static final int KLogitechButtonY = 4;
    public static final int KLogitechLeftBumper = 5;
    public static final int KLogitechRightBumper = 6;
    public static final int KLogitechLeftTrigger = 7;
    public static final int KLogitechRightTrigger = 8; 
    
    // Motor IDs - Make sure to double check 
    public static final int KleftLeadID = 1;
    public static final int KleftFollow1ID = 2;
    public static final int KleftFollow2ID = 3;

    public static final int KrightLeadID = 4;
    public static final int KrightFollow1ID = 5;
    public static final int KrightFollow2ID = 6;

    public static final int KIndexerMotorID = 7;

    public static final int KHoodMotorID = 8;

    public static final int KflywheelLeadMotorID = 9;
    public static final int KFlywheelFollwerMotorID = 10;

    public static final int KTurretMotorID = 11; 

    // Motor Speeds
    public static final double KFlywheelSpeed = 0.75;
    public static final double KHoodMoveSpeed = 0.1;
    public static final double KTurretMoveSpeed = 0.3;
    public static final double KIndexerSpeed = 0.4;
    
  }

