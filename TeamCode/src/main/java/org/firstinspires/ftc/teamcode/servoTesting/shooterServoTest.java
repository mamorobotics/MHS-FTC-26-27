package org.firstinspires.ftc.teamcode.servoTesting;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.gamepad1;
import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;
import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.telemetry;

import com.qualcomm.hardware.bosch.BHI260IMU;
import com.qualcomm.robotcore.eventloop.opmode.*;
import com.qualcomm.robotcore.hardware.*;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;



@TeleOp(name="shooterServoTest")
public class shooterServoTest {

    private static Servo shooterAdjustL;
    //private static Servo shooterAdjustR;

    double leftCurrentPos;
    //double rightCurrentPos;


    // @Override -- not needed here rn because this isn't connected to a larger "daddy" function
    // that also references init; however, if adding to larger opMode function, you do need it.
    public void init() {

        // 1. Initialize the servo from the hardware map
        shooterAdjustL = hardwareMap.get(Servo.class, "ArmServo");
        //shooterAdjustR = hardwareMap.get(Servo.class, "ClawServo");

        // 2. Set Servo directions
        // shooterAdjustL.setDirection(Servo.Direction.REVERSE);
        // shooterAdjustR.setDirection(Servo.Direction.FORWARD);

        shooterAdjustL.setPosition(0.0);
        //shooterAdjustR.setPosition(0.0);

        telemetry.addData("Status", "Initialized");
        telemetry.update();




    }

    // @Override --> add later.
    public void loop() {

        telemetry.addData("Left Servo:", shooterAdjustL.getPosition());
        //telemetry.addData("Right Servo:", shooterAdjustR.getPosition());

        telemetry.update();

        // Using dpad_left and dpad_right (or change to gamepad1.left_bumper / gamepad1.right_bumper)


        leftCurrentPos = shooterAdjustL.getPosition();
        //rightCurrentPos = shooterAdjustR.getPosition();

        if (gamepad1.dpad_left) {

            shooterAdjustL.setPosition(leftCurrentPos + 0.1); // Move to minimum position (e.g., 0 degrees)
            //shooterAdjustR.setPosition(rightCurrentPos - 0.1); // Move to minimum position (e.g., 0 degrees)
        } else if (gamepad1.dpad_right) {
            shooterAdjustL.setPosition(leftCurrentPos - 0.1); // Move to minimum position (e.g., 0 degrees)
            // shooterAdjustR.setPosition(rightCurrentPos + 0.1); // Move to minimum position (e.g., 0 degrees)
        }









    }


}
