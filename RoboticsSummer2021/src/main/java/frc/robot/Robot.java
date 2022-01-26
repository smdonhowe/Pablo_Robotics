// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  VictorSC one = new VictorSC(1);
  VictorSC two = new VictorSC(2);
  VictorSC three = new VictorSC(3);
  VictorSC four = new VictorSC(4);
  Spark roller = new Spark(1);
  Spark arm = new Spark(0);
  Joystick joystick = new Joystick(0);

  SpeedControllerGroup left = new SpeedControllerGroup(two, three);
  SpeedControllerGroup right = new SpeedControllerGroup(one, four);

  DifferentialDrive driveTrain = new DifferentialDrive(left, right);

  /**
   * This function is run when the robot is first started up and should be used
   * for any initialization code.
   */
  @Override
  public void robotInit() {

  }

  /**
   * This function is called every robot packet, no matter the mode. Use this for
   * items like diagnostics that you want ran during disabled, autonomous,
   * teleoperated and test.
   *
   * <p>
   * This runs after the mode specific periodic functions, but before LiveWindow
   * and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {

  }

  /**
   * This autonomous (along with the chooser code above) shows how to select
   * between different autonomous modes using the dashboard. The sendable chooser
   * code works with the Java SmartDashboard. If you prefer the LabVIEW Dashboard,
   * remove all of the chooser code and uncomment the getString line to get the
   * auto name from the text box below the Gyro
   *
   * <p>
   * You can add additional auto modes by adding additional comparisons to the
   * switch structure below with additional strings. If using the SendableChooser
   * make sure to add them to the chooser code above as well.
   */
  @Override
  public void autonomousInit() {

  }

  /** This function is called periodically during autonomous. */
  @Override
  public void autonomousPeriodic() {
    
  }

  /** This function is called once when teleop is enabled. */
  @Override
  public void teleopInit() {
  }

  /** This function is called periodically during operator control. */
  @Override
  public void teleopPeriodic() {
   //  driveTrain.arcadeDrive(joystick.getRawAxis(0) * Math.sqrt(.25), joystick.getRawAxis(1) * Math.sqrt(.25));
    roller.set(joystick.getRawAxis(4));

    if (joystick.getRawAxis(2) == 1) {
      arm.set(0.5);
    } else {
      arm.set(0);
    }

    if (joystick.getRawAxis(3) == 1 && joystick.getRawAxis(2) == 1) {
      roller.set(0.5);
    } else if (joystick.getRawAxis(3) == 1) {
      roller.set(-0.5);
    } else if (joystick.getRawButton(6)  == true) {
      roller.set(0.5);}
      else {roller.set(0);
    }

    if (joystick.getRawButton(4) == true) { 
      driveTrain.arcadeDrive(joystick.getRawAxis(0) * Math.sqrt(0.1), joystick.getRawAxis(1) * Math.sqrt(0.1));
    }
    else {driveTrain.arcadeDrive(joystick.getRawAxis(0) * Math.sqrt(0.3), joystick.getRawAxis(1) * Math.sqrt(0.3));
    }
    if (joystick.getRawButton(1) == true) { 
      driveTrain.arcadeDrive(joystick.getRawAxis(0) * Math.sqrt(0.5), joystick.getRawAxis(1) * Math.sqrt(0.5));
    }
    else {driveTrain.arcadeDrive(joystick.getRawAxis(0) * Math.sqrt(0.3), joystick.getRawAxis(1) * Math.sqrt(0.3));
    }


    }
  

  /** This function is called once when the robot is disabled. */
  @Override
  public void disabledInit() {
  }

  /** This function is called periodically when disabled. */
  @Override
  public void disabledPeriodic() {
  }

  /** This function is called once when test mode is enabled. */
  @Override
  public void testInit() {
    index = 0;
  }

  SpeedController[] speedC = new SpeedController[] { one, two, three, four, roller, arm };
  int index = 0;

  /** This function is called periodically during test mode. */
  @Override
  public void testPeriodic() {
    // Cycle through each speed controller by pressing A
    speedC[index].set(0.2);
    if (joystick.getRawButtonPressed(1) && speedC.length > index) {
      speedC[index].set(0);
      index = index + 1;
    }

    System.out.println(index);

    // Victor One, Victor Two, Victor Three, Victor Four, Spark Five, Spark Six (victor sucks)

  }
}
