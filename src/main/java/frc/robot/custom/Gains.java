package frc.robot.custom;

/**
 * A simple container class for PID Gains
 */
public class Gains{

    public double kF, kP, kI, kD;

    public Gains(double kF, double kP, double kI, double kD) {
        this.kF = kF;
        this.kP = kP;
        this.kI = kI;
        this.kD = kD;
    }

    /**
     * Default constructor
     */
    public Gains() {
        this.kF = 0;
        this.kP = 0;
        this.kI = 0;
        this.kD = 0;
    }
}