package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.custom.WPI_VeloTalon;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import static frc.robot.Constants.*;

/**
 * Basic tank drive with WPI-wrapped motor controllers
 * see https://docs.ctre-phoenix.com/en/stable/ch15_WPIDrive.html
 */
public class Drive extends SubsystemBase {

  WPI_VeloTalon leftTalon, rightTalon;
  WPI_VictorSPX leftVictor, rightVictor;

  DifferentialDrive drivetrain;

  /** Creates a new Drive. */
  public Drive() {

    leftTalon  = new WPI_VeloTalon(leftTalonPort, leftDriveGains);
    rightTalon = new WPI_VeloTalon(rightTalonPort, rightDriveGains);
    
    drivetrain = new DifferentialDrive(leftTalon, rightTalon);
    drivetrain.setRightSideInverted(false);

    //follower setup

    leftVictor  = new WPI_VictorSPX(leftVictorPort);
    leftVictor.configFactoryDefault();
    leftVictor.follow(leftTalon);
    leftVictor.setInverted(InvertType.FollowMaster);

    rightVictor = new WPI_VictorSPX(rightTalonPort);
    rightVictor.configFactoryDefault();
    rightVictor.follow(rightTalon);
    rightVictor.setInverted(InvertType.FollowMaster);
  }

  public void curvatureDrive(double power, double turn) {
    drivetrain.curvatureDrive(power, turn, true);
  }
}
