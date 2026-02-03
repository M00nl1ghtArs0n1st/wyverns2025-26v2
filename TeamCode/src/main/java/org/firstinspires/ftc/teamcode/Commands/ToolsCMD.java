package org.firstinspires.ftc.teamcode.Commands;

import static java.lang.Thread.sleep;
import org.firstinspires.ftc.teamcode.Subsystems.Tools;
import org.firstinspires.ftc.teamcode.Commands.SixWheelCMD;

public class ToolsCMD {
    Tools tools;
    SixWheelCMD cmd;
    public void startFlywheel(double targetRPM) {
        double CPR =28; //Counts per revolution
        double driveGearReduction = 1;
        double CPW = CPR * driveGearReduction; // counts per wheel
        double TPS = (targetRPM/ 60) * CPW;
        tools.flywheelMotor.setVelocity(TPS);
    }
    public void shootArtifacts(long startTime) throws InterruptedException {
//         LLResult result = robot.limelight.getLatestResult();
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
        sleep(startTime); //flywheel get to speed
        tools.intakeMotor.setPower(-.25);
        tools.flywheelServo.setPower(.5);
        sleep(3000); //wait for shooting to happen loser
        tools.intakeMotor.setPower(0);
        sleep(2000);
        tools.flywheelServo.setPower(0);
        sleep(500);
        tools.intakeMotor.setPower(.25);
        sleep(500);
        tools.flywheelServo.setPower(.5);
        sleep(2500);
        tools.intakeMotor.setPower(-.25);
        sleep(2000);
        tools.intakeMotor.setPower(0);
        tools.flywheelServo.setPower(0);
        tools.flywheelMotor.setVelocity(0);
    }
}
