package frc.robot;

import frc.robot.subsystems.Drivetrain;

public class DriveAction implements Action {
    double speed;
    double distance;
    Drivetrain drivetrain = Robot.drivetrain;

    public DriveAction(double distance, double speed) {
        this.speed = speed;
        this.distance = distance;
    }

    @Override
    public void run() {
        if (drivetrain.getGyroAngleZ() < 0) {
            drivetrain.arcadeDrive(speed, Math.min(drivetrain.getGyroAngleZ() / -4, 1));
        } else {
            drivetrain.arcadeDrive(speed, Math.max(drivetrain.getGyroAngleZ() / -4, -1));
        }
    }

    @Override
    public boolean isFinished() {
        return drivetrain.getAverageDistanceInch() > distance;
    }

    @Override
    public void init() {
        drivetrain.resetEncoders();
    }

}
