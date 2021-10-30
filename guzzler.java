package frc.mechs;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.Solenoid;
import frc.gen.BIGData;

public class Guzzler implements Mech {
    private TalonSRX motor_l;
    private TalonSRX motor_r;

    private double intakeSpeed;
    private int num_blocks

    private boolean enabled;

    public Guzzler(int intake_talon_l_id, int intake_talon_r_id, int speed) {

        motor_l = new TalonSRX(intake_talon_l_id);
        motor_l.configContinuousCurrentLimit(10, 0);
        motor_l.configPeakCurrentLimit(15, 0);
        motor_l.configPeakCurrentDuration(100, 0);
        motor_l.enableCurrentLimit(true);

        motor_r = new TalonSRX(intake_talon_r_id);
        motor_r.configContinuousCurrentLimit(10, 0);
        motor_r.configPeakCurrentLimit(15, 0);
        motor_r.configPeakCurrentDuration(100, 0);
        motor_r.enableCurrentLimit(true);

        num_blocks = 0;
        enabled = false;
        intakeSpeed = speed;
    }
    //message to compiler that function is overiding base class
    @Override
    public void enable()
    {
        motor_r.enable();
        motor_l.enable();
        enabled = true;
    }

    @Override
    public void disable()
    {
        motor_r.disable();
        motor_l.enable();
        enabled = false;
    }

    public void increment_block()
    {
        num_blocks++;
    }

    public int get_num_blocks()
    {
        return num_blocks;
    }

    public set_num_blocks(int blocks)
    {
        num_blocks = blocks;
    }

    @Override
    public void update() {
        if(enabled)
        {
            //grabs block
            motor_l.set(ControlMode.PercentOutput, intakeSpeed);
            motor_r.set(ControlMode.PercentOutput, intakeSpeed);
        }

    }










}