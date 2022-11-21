package com.stuypulse.robot.subsystems;

import static com.stuypulse.robot.constants.Ports.Excelsior.*;
import static com.stuypulse.robot.constants.Settings.Excelsior.*;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.stuypulse.robot.constants.Settings;
import com.stuypulse.robot.util.CANSparkMaxes;
import com.stuypulse.robot.util.Motor;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.kinematics.DifferentialDriveOdometry;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.smartdashboard.Field2d;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Excelsior extends Robot {
    
    private final CANSparkMax[] leftMotors;
    private final CANSparkMax[] rightMotors;

    private final Encoder leftGrayhill, rightGrayhill;
    
    private final DifferentialDriveOdometry odometry;

    private final Motor left, right;

    private final Field2d field;

    public Excelsior() {
        leftMotors = new CANSparkMax[] {
            new CANSparkMax(LEFT_TOP, MotorType.kBrushless),
            new CANSparkMax(LEFT_MIDDLE, MotorType.kBrushless),
            new CANSparkMax(LEFT_BOTTOM, MotorType.kBrushless)
        };

        rightMotors = new CANSparkMax[] {
            new CANSparkMax(RIGHT_TOP, MotorType.kBrushless),
            new CANSparkMax(RIGHT_MIDDLE, MotorType.kBrushless),
            new CANSparkMax(RIGHT_BOTTOM, MotorType.kBrushless)
        };
        
        leftGrayhill = new Encoder(LEFT_GRAYHILL_A, LEFT_GRAYHILL_B);
        leftGrayhill.setReverseDirection(true);
        leftGrayhill.setDistancePerPulse(Encoders.GRAYHILL_DISTANCE_PER_PULSE);

        rightGrayhill = new Encoder(RIGHT_GRAYHILL_A, RIGHT_GRAYHILL_B);
        rightGrayhill.setReverseDirection(true);
        rightGrayhill.setDistancePerPulse(Encoders.GRAYHILL_DISTANCE_PER_PULSE);

        odometry = new DifferentialDriveOdometry(getRotation2d());

        left = new CANSparkMaxes(leftGrayhill, leftMotors);
        right = new CANSparkMaxes(rightGrayhill, rightMotors);

        field = new Field2d();
        SmartDashboard.putData("Excelsior/Field", field);
    }

    @Override
    public Motor getLeftMotor() {
        return left;
    }

    @Override
    public Motor getRightMotor() {
        return right;
    }

    public double getRadians() {
        return (leftGrayhill.getDistance() - rightGrayhill.getDistance()) / Settings.Excelsior.TRACK_WIDTH;
    }

    public Rotation2d getRotation2d() {
        // inverted to keep in convention of ccw positive
        return new Rotation2d(-getRadians());
    }

    @Override
    public void reset(Pose2d pose) {
        odometry.resetPosition(pose, getRotation2d());
    }

}
