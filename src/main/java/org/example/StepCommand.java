package org.example;

import java.util.Scanner;

public class StepCommand implements Command {

    Step steps;
    Scanner sc;

    public StepCommand(Step steps, Scanner sc) {
        this.steps = steps;
        this.sc = sc;
    }

    @Override
    public void execute() {
        steps.stepForward(sc);
    }

    @Override
    public void undo() {
        steps.stepBackward();
    }
}
