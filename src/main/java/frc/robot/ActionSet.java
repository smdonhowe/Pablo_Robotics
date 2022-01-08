package frc.robot;

public class ActionSet {
    Action[] actions;
    int index;

    public ActionSet(Action... actions) {
        this.actions = actions;
    }

    public void run() {
        if (index < actions.length) {
            actions[index].run();
            if (actions[index].isFinished()) {
                index = index + 1;
                if (index < actions.length)
                    actions[index].init();
            }
        }
    }

}
