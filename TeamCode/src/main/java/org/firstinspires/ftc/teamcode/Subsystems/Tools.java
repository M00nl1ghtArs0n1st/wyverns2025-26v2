package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.CRServo;

public class Tools {
    public DcMotorEx flywheelMotor, intakeMotor;
    public CRServo flywheelServo;
    public Tools(HardwareMap hMap) {
        flywheelMotor = hMap.get(DcMotorEx.class, "flywheelMotor");
        intakeMotor = hMap.get(DcMotorEx.class, "intakeMotor");
        flywheelServo = hMap.get(CRServo.class, "flywheelServo");
        flywheelMotor.setDirection(DcMotorSimple.Direction.FORWARD);
        flywheelServo.setDirection(CRServo.Direction.FORWARD);
        intakeMotor.setDirection(DcMotorSimple.Direction.FORWARD);
        resetToolEncoders();
    }
    public void resetToolEncoders() {
        flywheelMotor.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
        intakeMotor.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
        flywheelMotor.setMode(DcMotorEx.RunMode.RUN_WITHOUT_ENCODER);
        intakeMotor.setMode(DcMotorEx.RunMode.RUN_WITHOUT_ENCODER);
    }
}
