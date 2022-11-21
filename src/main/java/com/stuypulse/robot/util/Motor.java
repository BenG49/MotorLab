package com.stuypulse.robot.util;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public abstract class Motor extends SubsystemBase {
    // set speed from -1.0 to 1.0
    public final void set(double speed) {
        setInternal(MathUtil.clamp(speed, -1, 1));
    }

    protected abstract void setInternal(double speed);

    // speed in inches/s
    public abstract double getSpeed();

    // distance in inches
    public abstract double getDistance();
}
