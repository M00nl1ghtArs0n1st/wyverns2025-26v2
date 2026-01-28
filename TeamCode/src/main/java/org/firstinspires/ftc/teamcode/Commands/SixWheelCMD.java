package org.firstinspires.ftc.teamcode.Commands;

import static java.lang.Thread.sleep;

import org.firstinspires.ftc.teamcode.Subsystems.Drivetrain;
import org.firstinspires.ftc.teamcode.Subsystems.Imu;
public class SixWheelCMD {

    Drivetrain drivetrain;
    Imu imu;

    public void driveBasic(double left, double right, long time) throws InterruptedException {
        //set all motor powers
        setMotors(left,right);
        sleep(time); //wait for however long
        //stop
        setMotors(0,0);
    }
    public void setMotors(double left, double right) {
        drivetrain.leftSide.setPower(left);
        drivetrain.rightSide.setPower(right);
    }
    public void moveWithEncoders (double position) {
//        double CPR = 28 * (28); //counts per revolution 28 times gear ratio 20:1
//        double circumference = Math.PI * 115;
//        double countsPerMM = CPR / circumference;
//        double positionTicks = ((position/304.8) * countsPerMM);
        imu.imu.resetYaw();
        drivetrain.leftSide.resetEncoders();
        drivetrain.rightSide.resetEncoders();
        double currentPos = drivetrain.backRight.getCurrentPosition();
        if (position > 0) {
            setMotors(.35, .35);//CHANGE BACK TO .35
            while (currentPos < position - 100) {
                currentPos = drivetrain.backLeft.getCurrentPosition();
            }
            setMotors(.25, .25);//CHANGE BACK TO .25
            while (currentPos < position - 50) {
                currentPos = drivetrain.backLeft.getCurrentPosition();
            }
        } else {
            setMotors(-.35, -.35); //CHANGE BACK TO .4
            while (currentPos > position + 100) {
                currentPos = drivetrain.backLeft.getCurrentPosition();
            }
            setMotors(-.25, -.25);//CHANGE BACK TO .3
            while (currentPos > position + 50) {
                currentPos = drivetrain.backLeft.getCurrentPosition();
            }
        }
        setMotors(0,0);
    }
    public void turnByAngle(double angle) {
        drivetrain.leftSide.resetEncoders();
        drivetrain.rightSide.resetEncoders();
        double heading = imu.getRobotHeading();
        if (angle < 0) {
            setMotors(-.375, .375); //sets initial motor powers
            while (heading < angle + 30) {
                heading = imu.getRobotHeading();
            }//waits until the robot only needs to turn 30 more degrees
            setMotors(-.25, .25); //robot slows down to be more accurate
            while (heading <  angle + 5) {
                heading = imu.getRobotHeading();
            }// waits for the robot to turn all the way
        } else {
            setMotors(.375, -.375);// sets initial motor powers
            while (heading > angle -30) {
                heading = imu.getRobotHeading();
            } //waits until the robot only has to turn 30 more degrees
            setMotors(.25, -.25); //robot slows to be more accurate
            while (heading> angle -5) {
                heading = imu.getRobotHeading();
            } //waits for the robot to turn to the specified angle
        }
        setMotors(0,0); //stops robot after it has turned
    }

}
