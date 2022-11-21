package com.stuypulse.robot.util;

import com.revrobotics.CANSparkMax;
import com.stuypulse.robot.constants.Settings.Limits;

import edu.wpi.first.wpilibj.Encoder;

public class CANSparkMaxes extends Motor {

    private CANSparkMax[] motors;
    private Encoder encoder;

    public CANSparkMaxes(Encoder encoder, CANSparkMax... motors) {
        this.motors = motors;
        this.encoder = encoder;
    }

    @Override
    public void setInternal(double speed) {
        for (CANSparkMax motor : motors) {
            motor.setVoltage(speed * Limits.CAN_MAX_VOLTS);
        }
    }

    @Override
    public double getSpeed() {
        return encoder.getRate();
    }

    @Override
    public double getDistance() {
        return encoder.getDistance();
    }

}
