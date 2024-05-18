package org.example;

import java.util.Scanner;

public class Main {
public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Controller controller = new Controller();
        Step steps = new Step();

        Command stepForward = new StepCommand(steps, sc);
        controller.setCommand(stepForward);
        // add command
        controller.executeCommand();
        controller.executeCommand();
        controller.executeCommand();
        controller.executeCommand();
        controller.executeCommand();
        controller.executeCommand();


        System.out.println("Steps in queue " + steps.getQueue());
        // undo last command
        controller.undoCommand();

        System.out.println("Steps in queue " + steps.getQueue());
        // undo another command
        controller.undoCommand();
        System.out.println("Steps in queue " + steps.getQueue());

        sc.close();
    }
}