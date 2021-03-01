package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import static frc.robot.Constants.*;

/**
 * Basic tank drive with WPI-wrapped motor controllers
 * see https://docs.ctre-phoenix.com/en/stable/ch15_WPIDrive.html
 */
public class Drive extends SubsystemBase {

  WPI_TalonSRX leftTalon, rightTalon;
  WPI_VictorSPX leftVictor, rightVictor;

  SpeedControllerGroup leftGroup, rightGroup;

  DifferentialDrive drivetrain;

  /** Creates a new Drive. */
  public Drive() {
    leftTalon  = new WPI_TalonSRX(leftTalonPort);
    rightTalon = new WPI_TalonSRX(rightTalonPort);
    
    leftVictor  = new WPI_VictorSPX(leftVictorPort);
    rightVictor = new WPI_VictorSPX(rightTalonPort);

    leftGroup = new SpeedControllerGroup(leftTalon, leftVictor);
    rightGroup = new SpeedControllerGroup(rightTalon, rightVictor);

    drivetrain = new DifferentialDrive(leftGroup, rightGroup);
    drivetrain.setRightSideInverted(true);
  }

  public void curvatureDrive(double power, double turn) {
    drivetrain.curvatureDrive(power, turn, true);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
