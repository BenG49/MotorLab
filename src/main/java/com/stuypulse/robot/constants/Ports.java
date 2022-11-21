/************************ PROJECT PHIL ************************/
/* Copyright (c) 2022 StuyPulse Robotics. All rights reserved.*/
/* This work is licensed under the terms of the MIT license.  */
/**************************************************************/

package com.stuypulse.robot.constants;

/** This file contains the different ports of motors, solenoids and sensors */
public interface Ports {
    public interface Romi {
        int LEFT_MOTOR = 0;
		int RIGHT_MOTOR = 1;

		int LEFT_ENCODER_A = 4;
		int LEFT_ENCODER_B = 5;

		int RIGHT_ENCODER_A = 6;
		int RIGHT_ENCODER_B = 7;
    }
    
    public interface Edwin {
        int LEFT_TOP = 7;
        int LEFT_BOTTOM = 6;

        int RIGHT_TOP = 4;
        int RIGHT_BOTTOM = 3;

        int GEAR_SHIFT = 0;
    }

    public interface Excelsior {
        int LEFT_TOP = 10;
        int LEFT_MIDDLE = 11;
        int LEFT_BOTTOM = 12;

        int RIGHT_TOP = 13;
        int RIGHT_MIDDLE = 14;
        int RIGHT_BOTTOM = 15;

        int GEAR_SHIFT_FORWARD = 0;
        int GEAR_SHIFT_REVERSE = 1;

        int LEFT_GRAYHILL_A = 0;
        int LEFT_GRAYHILL_B = 1;

        int RIGHT_GRAYHILL_A = 2;
        int RIGHT_GRAYHILL_B = 3;
    }
}
