package org.firstinspires.ftc.teamcode.Auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Alliance;
import org.firstinspires.ftc.teamcode.Commands.SixWheelCMD;
import org.firstinspires.ftc.teamcode.Commands.ToolsCMD;

public class FarAuto extends LinearOpMode {
    public Alliance alliance;
    SixWheelCMD cmd;
    ToolsCMD CMD;
    public FarAuto(Alliance alliance) {
        this.alliance = alliance;
    }

    @Override
    public void runOpMode() throws InterruptedException {
        //        robot.limelight.setPollRateHz(100); // This sets how often we ask Limelight for data (100 times per second)
//        robot.limelight.start();
        waitForStart();
        CMD.startFlywheel(2500);
        cmd.moveWithEncoders(1650);
        sleep(1000);
        cmd.turnByAngle(43);
        sleep(500);
        CMD.shootArtifacts(2000);
    }
}
