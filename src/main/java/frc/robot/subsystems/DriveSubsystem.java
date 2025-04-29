package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix6.hardware.TalonFXS;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DriveConstants;

public class DriveSubsystem extends SubsystemBase {

    private TalonSRX driveFrontLeftMotor = new TalonSRX(1);
    private TalonSRX driveFrontRightMotor = new TalonSRX(4);
    private TalonSRX driveBackRightMotor = new TalonSRX(3);
    private TalonSRX driveBackLeftMotor = new TalonSRX(2);


    public DriveSubsystem() {

    }
    @Override
    public void periodic() {
    // Update the SmartDashboard with the current setpoint
    SmartDashboard.putNumber("driveBackLeftMotor Setpoint", driveBackLeftMotor.getSelectedSensorPosition());
    SmartDashboard.putNumber("driveBackRightMotorSetpoint", driveBackRightMotor.getSelectedSensorPosition());

    }
    


    public void setMotors(double leftSpeed, double rightSpeed) {
      driveBackRightMotor.set(ControlMode.PercentOutput, leftSpeed);
      driveFrontRightMotor.set(ControlMode.PercentOutput, leftSpeed);
      driveFrontLeftMotor.set(ControlMode.PercentOutput, -rightSpeed);
      driveBackLeftMotor.set(ControlMode.PercentOutput,-rightSpeed);
    }

}
