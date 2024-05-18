package org.example;

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
}
