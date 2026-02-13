package org.firstinspires.ftc.teamcode.Auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Commands.SixWheelCMD;
import org.firstinspires.ftc.teamcode.Commands.ToolsCMD;

import org.firstinspires.ftc.teamcode.Subsystems.Drivetrain;
import org.firstinspires.ftc.teamcode.Subsystems.Imu;
import org.firstinspires.ftc.teamcode.Subsystems.Tools;

@Autonomous
public class CloseAuto extends LinearOpMode {
    SixWheelCMD cmd;
    ToolsCMD CMD;
    Drivetrain drivetrain;
    Tools tools;
    Imu imu;

    @Override
    public void runOpMode() throws InterruptedException {
        drivetrain = new Drivetrain(hardwareMap);
        tools = new Tools(hardwareMap);
        imu = new Imu(hardwareMap);
        waitForStart();
//        robot.limelight.setPollRateHz(100); // This sets how often we ask Limelight for data (100 times per second)
//        robot.limelight.start();
        waitForStart();
        CMD.startFlywheel(2500);
        cmd.moveWithEncoders(-780);
        CMD.shootArtifacts(5000); //test how long itll take for flywheel to get to speed!!
    }
}