package frc.robot;

public interface Action {
    public void run();
    
    public boolean isFinished();

    public void init();
}
