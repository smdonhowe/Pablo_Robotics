package frc.robot;

public class TurnAction implements Action {
    double speed;
    double degrees;

    public TurnAction(double degrees, double speed) {
        this.speed = speed;
        this.degrees = degrees;
    }

    @Override
    public void run() {
        Robot.drivetrain.arcadeDrive(0, speed);
    }

    @Override
    public boolean isFinished() {
        return Robot.drivetrain.getGyroAngleZ() > degrees;
    }
    @Override
    public void init() {
        Robot.drivetrain.resetGyro();
    }
    
}
