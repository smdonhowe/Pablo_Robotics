public class Robot {
    boolean driving = false;
    String robotName = "Rob";

    public void drive() {
        driving = true;
        System.out.println("The robot is driving");
    }

    @Override
    public String toString() {
        return robotName;
    }
}
