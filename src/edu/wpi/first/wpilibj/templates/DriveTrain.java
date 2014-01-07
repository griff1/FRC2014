//Drive Train

package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class DriveTrain extends AerialAssist
{
    CANJaguar flm;
    CANJaguar rlm;
    CANJaguar frm;
    CANJaguar rrm;
    
    private final double Pk = 0.0;
    private final double Ik = 0.0;
    private final double Dk = 0.0;
    
    JoystickButton rTrigger;
    
    public DriveTrain()
    {
        rTrigger = new JoystickButton(rightj,1);
        
        try
        {
            flm = new CANJaguar(1, CANJaguar.ControlMode.kSpeed);
            rlm = new CANJaguar(2, CANJaguar.ControlMode.kSpeed);
            frm = new CANJaguar(3, CANJaguar.ControlMode.kSpeed);
            rrm = new CANJaguar(4, CANJaguar.ControlMode.kSpeed);
            
            flm.setPID(Pk, Ik, Dk);
            rlm.setPID(Pk, Ik, Dk);
            frm.setPID(Pk, Ik, Dk);
            rrm.setPID(Pk, Ik, Dk);
            
            flm.setSpeedReference(CANJaguar.SpeedReference.kEncoder);
            rlm.setSpeedReference(CANJaguar.SpeedReference.kEncoder);
            frm.setSpeedReference(CANJaguar.SpeedReference.kEncoder);
            rrm.setSpeedReference(CANJaguar.SpeedReference.kEncoder);
            
            flm.configEncoderCodesPerRev(250);
            rlm.configEncoderCodesPerRev(250);
            frm.configEncoderCodesPerRev(250);
            rrm.configEncoderCodesPerRev(250);
            
            flm.enableControl();
            rlm.enableControl();
            frm.enableControl();
            rrm.enableControl();
        }catch(Exception e){}
    }
    
    public void main()
    {
        try
        {
            if (rTrigger.get() == true)
            {
                //Mecanum
                flm.setX(rightj.getY()*150+rightj.getX()*150);
                rlm.setX(rightj.getY()*150-rightj.getX()*150);
                frm.setX(rightj.getY()*150-rightj.getX()*150);
                rrm.setX(rightj.getY()*150+rightj.getX()*150);
            }
            else
            {
                //Tank
                flm.setX(leftj.getY()*150);
                rlm.setX(leftj.getY()*150);
                frm.setX(rightj.getY()*150);
                rrm.setX(rightj.getY()*150);
            }
        }catch(Exception e){}
    }
    
    public void autonDrive()
    {
        try
        {
            flm.setX(150);
            rlm.setX(150);
            frm.setX(150);
            rrm.setX(150);
            Timer.delay(2);
            flm.setX(0);
            rlm.setX(0);
            frm.setX(0);
            rrm.setX(0);
        }catch(Exception e){}
    }
}
