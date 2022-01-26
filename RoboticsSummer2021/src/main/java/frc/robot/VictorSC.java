package frc.robot;

import com.ctre.phoenix.motorcontrol.VictorSPXControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.SpeedController;

/**
 * A class that allows VictorSPXs to be put into the differential drive
 */
public class VictorSC extends VictorSPX implements SpeedController {
    double speed = 0;

    public VictorSC(int deviceNumber) {
        super(deviceNumber);
    }

    @Override
    // public void pidWrite(double output) {
    public void setVoltage(double output) {
            set(output);
    }

    @Override
    public void set(double speed) {
        super.set(VictorSPXControlMode.PercentOutput, speed);
        this.speed = speed;
    }

    @Override
    public double get() {
        return speed * (super.getInverted()?1:-1);
        
    }

    @Override
    public void setInverted(boolean isInverted) {
        super.setInverted(isInverted);
    }

    @Override
    public boolean getInverted() {
        return super.getInverted();
    }

    @Override
    public void disable() {
        stopMotor();
    }

    @Override
    public void stopMotor() {
        this.set(0);
    }

}
