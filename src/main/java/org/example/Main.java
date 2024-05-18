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

        // load steps from file
        try {
                steps.leadTxtFile("yourSteps.txt");
                System.out.println("Loaded queue from text file " + steps.getQueue());
        } catch (IOException e) {
                System.err.println("Failed to load file " + e.getMessage());
        }

        // serialise queue
        try {
                steps.serializeQueue("yourStepsSerialized.ser");
                System.out.println("Steps serialized");
        } catch (IOException e) {
                System.err.println("Failed to save file: " + e.getMessage());
        }

        // read from serialize
        try {
                Step step = steps.loadFromFile("yourStepsSerialized.ser");
                System.out.println("Loaded from serialize." + step.getQueue());

        } catch (IOException | ClassNotFoundException e) {
                System.err.println("Failed to load steps: " + e.getMessage());
        }

        sc.close();
    }
}