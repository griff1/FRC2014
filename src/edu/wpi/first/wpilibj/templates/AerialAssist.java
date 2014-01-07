//Team 4024
//2014 - Aerial Assist

package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;

public class AerialAssist extends IterativeRobot 
{
    DriveTrain drive = new DriveTrain();
    Goalie block = new Goalie();
    Shooter shoot = new Shooter();
    
    public Joystick rightj = new Joystick(1);
    public Joystick leftj = new Joystick(2);
    
    public void robotInit() 
    {
        
    }
    
    public void autonomousPeriodic() 
    {
        drive.autonDrive();
    }
    
    public void teleopPeriodic() 
    {
        drive.main();
    }
}
