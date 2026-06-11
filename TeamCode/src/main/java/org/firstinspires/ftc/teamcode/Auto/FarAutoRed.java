package org.firstinspires.ftc.teamcode.Auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Commands.SixWheelCMD;
import org.firstinspires.ftc.teamcode.Commands.ToolsCMD;

import org.firstinspires.ftc.teamcode.Subsystems.Drivetrain;
import org.firstinspires.ftc.teamcode.Subsystems.Imu;
import org.firstinspires.ftc.teamcode.Subsystems.Tools;
@Autonomous
public class FarAutoRed extends LinearOpMode {
    SixWheelCMD cmd;
    ToolsCMD CMD;
    Drivetrain drivetrain;
    Tools tools;
    Imu imu;

    @Override
    public void runOpMode() throws InterruptedException {
        //        robot.limelight.setPollRateHz(100); // This sets how often we ask Limelight for data (100 times per second)
//        robot.limelight.start();
        drivetrain = new Drivetrain(hardwareMap);
        tools = new Tools(hardwareMap);
        imu = new Imu(hardwareMap);
        cmd = new SixWheelCMD(drivetrain, imu);
        CMD = new ToolsCMD(drivetrain, imu, tools, cmd);

        waitForStart();
        CMD.startFlywheel(2500);
        cmd.moveWithEncoders(1725);
        sleep(500);
        cmd.turnByAngle(45);
        sleep(500);
        CMD.shootArtifacts(2000);
        cmd.turnByAngle(43);
        cmd.moveWithEncoders(500);
    }
}