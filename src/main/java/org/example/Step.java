package org.example;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Step {

    private final Deque<String> queue = new ArrayDeque<>();

    public void stepForward(Scanner sc) {
        System.out.println("Add to deque:");
        queue.add(sc.nextLine());
    }

    public void stepBackward() {
        if(!queue.isEmpty()) {
            queue.removeLast();
        } else {
            System.out.println("No steps to undo.");
        }
    }
   public Deque<String> getQueue() {
        return queue;
   }

   public void saveToTxTFile(String filename) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for(String step : queue) {
                writer.write(step);
                writer.newLine();
            }
        }
   }
}
