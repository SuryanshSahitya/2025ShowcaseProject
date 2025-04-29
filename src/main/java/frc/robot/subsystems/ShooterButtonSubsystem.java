package frc.robot.subsystems;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.controller.SimpleMotorFeedforward;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ShooterButtonSubsystem extends SubsystemBase {
    private final SparkMax Shootermotor = new SparkMax(5,MotorType.kBrushless);
    private RelativeEncoder ShooterEncoder = Shootermotor.getEncoder();
    private PIDController pid = new PIDController(0.05, 0, 0);
    private SimpleMotorFeedforward feedforward = new SimpleMotorFeedforward(0,0, 0);

    public ShooterButtonSubsystem() {
        
    }
    @Override
    public void periodic() {
        // Update the SmartDashboard with the current setpoint
        SmartDashboard.putNumber("ShooterMotor Setpoint", ShooterEncoder.getPosition());
        SmartDashboard.putNumber("ShooterMotor Velocity", ShooterEncoder.getVelocity());
    }

    // not used just there for gbh
    public double setSetpoint(double setpoint){
        
        pid.setSetpoint(setpoint);
        double move = pid.calculate(ShooterEncoder.getPosition());
        return move;
        
       
        

    }
public Command buttonClickerCommand(double setpoint, double tolerance, int methodused){
    
        
        return new Command() {
            @Override
            public void initialize() {
                // Initialization code, such as resetting encoders or PID controllers
            }
    
            @Override
            public void execute() {
                if (methodused == 1) {
                    double speed = setSetpoint(setpoint); // Assuming setpid() calculates the speed based on PID
                    Shootermotor.set(speed+0.01);
                }
                if (methodused == 2) {
                    double pidOutput = pid.calculate(ShooterEncoder.getVelocity(), setpoint);
                    double feedforwardOutput = feedforward.calculate(setpoint);
                    double finalOutput = pidOutput + feedforwardOutput;
                    Shootermotor.set(finalOutput);
                }

            }
    
            @Override
            public void end(boolean interrupted) {
                Shootermotor.set(0); // Stop the motor when the command ends or is interrupted
                

            }
    
            @Override
            public boolean isFinished() {
                return ShooterEncoder.getPosition() >= setpoint - tolerance && ShooterEncoder.getPosition() <= setpoint + tolerance;
            }
        };
    }  
      
    // public Command ButtonMotorCommand(double speed){
    
        
    //     return new Command() {
    //         @Override
    //         public void initialize() {
    //             // Initialization code, such as resetting encoders or PID controllers
    //         }
    
    //         @Override
    //         public void execute() {
    //             Shootermotor.set(speed);
    //         }
    
    //         @Override
    //         public void end(boolean interrupted) {
    //             Shootermotor.set(0); // Stop the motor when the command ends or is interrupted
    //             Shootermotor.setVoltage(0);
            
    //         }
    
    //         @Override
    //         public boolean isFinished() {
    //             return false;
    //         }
    //     };
    // }
      
}

