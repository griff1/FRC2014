//Team 4024
//2014 - Aerial Assist

package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.IterativeRobot;

public class AerialAssist extends IterativeRobot 
{
    DriveTrain drive = new DriveTrain();
    Goalie block = new Goalie();
    Shooter shoot = new Shooter();
    
    public void robotInit() 
    {
        
        
    }
    
    public void autonomousPeriodic() 
    {
        
    }
    
    public void teleopPeriodic() 
    {
        drive.main();
    }
}
