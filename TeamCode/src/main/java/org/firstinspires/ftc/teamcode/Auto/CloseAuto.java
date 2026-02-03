package org.firstinspires.ftc.teamcode.Auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Commands.SixWheelCMD;
import org.firstinspires.ftc.teamcode.Commands.ToolsCMD;

@Autonomous
public class CloseAuto extends LinearOpMode {
    SixWheelCMD cmd;
    ToolsCMD CMD;

    @Override
    public void runOpMode() throws InterruptedException {
        waitForStart();
//        robot.limelight.setPollRateHz(100); // This sets how often we ask Limelight for data (100 times per second)
//        robot.limelight.start();
        waitForStart();
        CMD.startFlywheel(2500);
        cmd.moveWithEncoders(-780);
        CMD.shootArtifacts(5000); //test how long itll take for flywheel to get to speed!!
    }
}