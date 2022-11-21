/************************ PROJECT PHIL ************************/
/* Copyright (c) 2022 StuyPulse Robotics. All rights reserved.*/
/* This work is licensed under the terms of the MIT license.  */
/**************************************************************/

package com.stuypulse.robot.constants;

import com.stuypulse.stuylib.network.SmartBoolean;
import com.stuypulse.stuylib.network.SmartNumber;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Transform2d;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.util.Units;

/*-
 * File containing tunable settings for every subsystem on the robot.
 *
 * We use StuyLib's SmartNumber / SmartBoolean in order to have tunable
 * values that we can edit on Shuffleboard.
 */
public interface Settings {
    
    public interface Limits {
        int CAN_MAX_VOLTS = 8;

        int ROMI_MAX_VOLTS = 8;
        
    }

    public interface Field {
        Translation2d FIELD_OFFSET = new Translation2d(8, 4);
    }

    public interface Romi {
        SmartNumber SET_DELAY = new SmartNumber("Romi/Set Delay", 0.1);
        
        public interface Robot {
            double TRACK_WIDTH_METERS = 0.141;
            double WHEEL_DIAMETER_METERS = Units.metersToInches(0.070);
        }
        
        public interface Encoder {
            double COUNTS_PER_REVOLUTION = 1440.0;

            double DISTANCE_PER_PULSE = (Math.PI * Robot.WHEEL_DIAMETER_METERS) / COUNTS_PER_REVOLUTION;
        }
        
        public interface Feedforward {
            double kS = 0.45;
            double kV = 10.00;
            double kA = 0.186;
        }
    }
    
    public interface Excelsior {

        double TRACK_WIDTH = Units.inchesToMeters(26.9);

        public interface Encoders {
        
            public interface GearRatio {
    
                public interface Stages {
                    double INITIAL_STAGE = (11.0 / 50.0);
    
                    double HIGH_GEAR_STAGE = (50.0 / 34.0);
                    double LOW_GEAR_STAGE = (24.0 / 60.0);
    
                    double GRAYHILL_STAGE = (12.0 / 36.0);
    
                    double THIRD_STAGE = (34.0 / 50.0);
    
                    double EXTERNAL_STAGE = (1.0 / 1.0);
                }
    
                /** = 0.22666 */
                double GRAYHILL_TO_WHEEL =
                        Stages.GRAYHILL_STAGE * Stages.THIRD_STAGE * Stages.EXTERNAL_STAGE;
            }
    
            double WHEEL_DIAMETER = Units.inchesToMeters(4);
            double WHEEL_CIRCUMFERENCE = WHEEL_DIAMETER * Math.PI;
    
            double GRAYHILL_PULSES_PER_REVOLUTION = 256;
            double GRAYHILL_DISTANCE_PER_PULSE =
                    (WHEEL_CIRCUMFERENCE / GRAYHILL_PULSES_PER_REVOLUTION)
                            * GearRatio.GRAYHILL_TO_WHEEL;
        }
    }
}
