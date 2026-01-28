package org.firstinspires.ftc.teamcode.Commands;

import static java.lang.Thread.sleep;
import org.firstinspires.ftc.teamcode.Subsystems.Tools;
import org.firstinspires.ftc.teamcode.Commands.SixWheelCMD;

public class ToolsCMD {
    Tools tools;
    SixWheelCMD cmd;
    public void shootArtifacts(long amountOfArtifacts) throws InterruptedException {
//         LLResult result = robot.limelight.getLatestResult();
        double CPR =28; //Counts per revolution
        double driveGearReduction = 1;
        double CPW = CPR * driveGearReduction; // counts per wheel
        double targetRPM = 2000;
        double TPS = (targetRPM/ 60) * CPW;
//         double tx = result.getTx();
//         double ty = result.getTy();
//         double ta = result.getTa();
//         while (tx > (farthest right target can be) && tx > (farthest left target can be) && too far away (too small target)< ta < too close(too large target)){
//             while (tx > (farthest right target can be)){
//                 result = robot.limelight.getLatestResult();
//                 ty = result.getTy();
//                 tx = result.getTx();
//                 cmd.setMotors(.1,-.1);
//             }
//             while (tx > (farthest left target can be)){
//                 retrieveTelemetry();
//                 result = robot.limelight.getLatestResult();
//                 ty = result.getTy();
//                 tx = result.getTx();
//                 cmd.setMotors(-.1,.1);
//             }
//             while (too far away (too small target) < ta) {
//                 result = robot.limelight.getLatestResult();
//                 ta = result.getTa();
//                 cmd.setMotors(.1,.1);
//             }
//             while (ta < too close(too large target)) {
//                 result = robot.limelight.getLatestResult();
//                 ta = result.getTa();
//                 cmd.setMotors(-.1,-.1);
//             }
//         }
        cmd.setMotors(0,0);
        tools.flywheelMotor.setVelocity(TPS);
        sleep(3000); //flywheel get to speed
        tools.flywheelServo.setPower(.5);
        sleep(3000); //wait for shooting to happen loser
        tools.flywheelServo.setPower(0);
        amountOfArtifacts = amountOfArtifacts - 1;
        while (amountOfArtifacts != 0) {
            sleep(1000);
            tools.flywheelServo.setPower(.5);
            sleep(3000);
            tools.flywheelServo.setPower(0);
            amountOfArtifacts = amountOfArtifacts - 1;
        }
        tools.flywheelMotor.setVelocity(0);
    }
}
