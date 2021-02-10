// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.custom.Gains;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {

    public static final int rightTalonPort = 1;
    public static final int leftTalonPort  = 2;

    public static final int rightVictorPort = 3;
    public static final int leftVictorPort  = 4;

    //window to await the completion of ctre config methods
    public static final int kTimeoutMs = 30;

    //Velocity Driving Gains
    public static final Gains rightDriveGains = new Gains();
    public static final Gains leftDriveGains = new Gains();

    public static final int kXboxPort = 1;
}
