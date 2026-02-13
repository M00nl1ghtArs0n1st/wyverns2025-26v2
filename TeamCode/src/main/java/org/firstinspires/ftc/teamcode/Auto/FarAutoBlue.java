package org.firstinspires.ftc.teamcode.Auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Commands.SixWheelCMD;
import org.firstinspires.ftc.teamcode.Commands.ToolsCMD;

import org.firstinspires.ftc.teamcode.Subsystems.Drivetrain;
import org.firstinspires.ftc.teamcode.Subsystems.Imu;
import org.firstinspires.ftc.teamcode.Subsystems.Tools;

@Autonomous
public class FarAutoBlue extends LinearOpMode {
    SixWheelCMD cmd;
    ToolsCMD CMD;


    @Override
    public void runOpMode() throws InterruptedException {
        //        robot.limelight.setPollRateHz(100); // This sets how often we ask Limelight for data (100 times per second)
//        robot.limelight.start();
        cmd = new SixWheelCMD(hardwareMap);
        CMD = new ToolsCMD(hardwareMap);
        waitForStart();
        CMD.startFlywheel(2500);
        cmd.moveWithEncoders(1650);
        sleep(1000);
        cmd.turnByAngle(-43);
        sleep(500);
        CMD.shootArtifacts(2000);
    }
}