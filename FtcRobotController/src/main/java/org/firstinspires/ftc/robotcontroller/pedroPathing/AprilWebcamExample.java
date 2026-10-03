package org.firstinspires.ftc.robotcontroller.pedroPathing;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.robotcontroller.mechanisms.AprilTagWebcam;
import org.firstinspires.ftc.vision.apriltag.AprilTagDetection;

@Autonomous
public class AprilWebcamExample extends OpMode {
    AprilTagWebcam aprilTagWebcam = new AprilTagWebcam();

    @Override
    public void init(){
        aprilTagWebcam.init(hardwareMap, telemetry);
    }

    @Override
    public void loop(){
        //update vision portal
        aprilTagWebcam.update();
        AprilTagDetection id20 = aprilTagWebcam.getTagBySpecificId(20);
        telemetry.addData("id20 String", id20.toString());
    }
}
