package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.VictorSPXControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DriveConstants;

public class DriveSubsystem extends SubsystemBase {
    private VictorSPX frontRightMotor = new VictorSPX(DriveConstants.kFrontRightMotorCanId);
    private VictorSPX backRightMotor = new VictorSPX(DriveConstants.kBackRightMotorCanId);
    private VictorSPX frontLeftMotor = new VictorSPX(DriveConstants.kFrontLeftMotorCanId);
    private VictorSPX backLeftMotor = new VictorSPX(DriveConstants.kBackLeftMotorCanId);

    public DriveSubsystem(){
        backRightMotor.follow(frontRightMotor);
        backLeftMotor.follow(frontLeftMotor);
    }
    public void drive(float forward, float turn){
        frontRightMotor.set(VictorSPXControlMode.PercentOutput,forward+turn);
        frontLeftMotor.set(VictorSPXControlMode.PercentOutput,forward+turn);
    }
    public Command getDriveCommand(float forward, float turn){
        return this.run(()->drive(forward, turn));
    }
}
