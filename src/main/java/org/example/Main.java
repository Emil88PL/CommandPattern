package org.example;

import java.io.IOException;
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

        // save to file
        try {
                steps.saveToTxTFile("yourSteps.txt");
                System.out.println("Steps saved to a file");
        } catch (IOException e) {
                System.err.println("Filed to save file: " + e.getMessage());
        }

        sc.close();
    }
}