package org.firstinspires.ftc.teamcode.DriverControl;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import org.firstinspires.ftc.teamcode.Subsystems.Drivetrain;
import org.firstinspires.ftc.teamcode.Subsystems.Tools;

//Made by Finch (Will)

@TeleOp
public class SixWheelDrive extends OpMode {
    Drivetrain drivetrain;
    Tools tools;
    boolean usingTankDrive = false; //easy switch between tank drive and arcade drive
    //tank drive: left_stick_y is used for forward and back for the left side, same for right_stick_y and right side
    //arcade drive: left_stick_y is used for forward and back for both sides, right_stick_x is used for turning

    public void init() { // called once when INIT is pressed
        //hardware mapping from driver hub
        drivetrain = new Drivetrain(hardwareMap);

        telemetry.addData("Status", "Initialized"); // Displays this on Driver Station
        telemetry.update(); // updates the telemetry on the screen
        double CPR =28; //Counts per revolution
        double driveGearReduction = 1;
        double CPW = CPR * driveGearReduction; // counts per wheel
    }

    public void start() {} // called once after ▶ is pressed

    public void loop() { // loops after ▶ is pressed
        telemetry.addData("Status", "Started");
        // gamepad1: drivetrain gamepad
        // gamepad2: tools gamepad
        double CPR =28; //Counts per revolution
        double driveGearReduction = 1;
        double CPW = CPR * driveGearReduction; // counts per wheel
        double leftJoyY = -gamepad1.left_stick_y;
        double rightJoyY = gamepad1.right_stick_y;
        double rightJoyX = gamepad1.right_stick_x;
        // if you need to reverse a control, you can just add "-" before
        //gamepad1: driver gamepad
        //gamepad2: tools gamepad
        double targetRPMFar = 3100* gamepad2.right_trigger; //actual 6000 //from 3100
        double targetRPMClose = 2575 * gamepad2.left_trigger; //from 2600
        telemetry.addData("Flywheel Power", targetRPMFar);
        double TPSFar = (targetRPMFar/ 60) * CPW;
        double TPSClose = (targetRPMClose/ 60) * CPW;
        //this seems useless, but if you need to reverse a control, you can just add "-" before the reference
        boolean threeProngStart = gamepad2.b;
        boolean intakeForward = gamepad2.right_bumper;
        boolean intakeBackward = gamepad2.left_bumper;
        if (intakeForward) {
            tools.intakeMotor.setPower(.3);
        } else if (intakeBackward) {
            tools.intakeMotor.setPower(-.3);
        } else {
            tools.intakeMotor.setPower(0);
        }
        if (threeProngStart) {
            tools.flywheelServo.setPower(1);
        } else {
            tools.flywheelServo.setPower(0);
        }
        if (gamepad2.right_trigger > 0){
            tools.flywheelMotor.setVelocity(TPSFar);
        } else if (gamepad2.left_trigger > 0){
            tools.flywheelMotor.setVelocity(TPSClose);
        } else {
            tools.flywheelMotor.setVelocity(0);
        }


        drivetrain.arcadeDrive(leftJoyY,rightJoyX);
        // Left joystick Y axis -> drive straight
        // Right joystick X axis -> turn

        telemetry.update(); // last thing you do in the loop is update telemetry
    }
}
