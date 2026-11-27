package org.firstinspires.ftc.teamcode;

import com.pedropathing.follower.Follower;
import com.pedropathing.math.Pose;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.pedropathing.drivetrain.DrivePowers;
import com.pedropathing.follower.ManualDrive;
import org.firstinspires.ftc.teamcode.pedro.Constants;

@TeleOp(name = "PedroTeleOp")
public class PedroTeleOp extends OpMode {

    private Follower follower;

    @Override
    public void init() {
        follower = Constants.create(hardwareMap);
    }

    @Override
    public void loop() {
        DrivePowers powers = ManualDrive.fieldCentric(
                -gamepad1.left_stick_y,
                -gamepad1.left_stick_x,
                -gamepad1.right_stick_x,
                follower.pose().heading()


        );



        ManualDrive.driveOrHold(follower, powers);
        follower.update();
        Pose robotPose = follower.pose(); // returns a Pose object
        telemetry.addData("Robot X", robotPose.x());
        telemetry.addData("Robot Y", robotPose.y());
        telemetry.addData("Robot Heading",
                Math.toDegrees(robotPose.heading()));

        telemetry.addData("Follower Mode", follower.mode());
        telemetry.addData("Holding", follower.holding());
        telemetry.addData("Manual", follower.manual());

        telemetry.addData("Velocity X", follower.velocity().vx);
        telemetry.addData("Velocity Y", follower.velocity().vy);
        telemetry.addData("Angular Velocity", follower.velocity().omega);

        telemetry.update();
    }
}