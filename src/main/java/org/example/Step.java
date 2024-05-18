package org.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Step implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
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

   public void leadTxtFile(String filename) throws IOException {
        queue.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                queue.add(line);
            }
        }
   }

   public void serializeQueue(String filename) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(this);
        }
   }

    public Step loadFromFile(String filename) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            return (Step) ois.readObject();
        }
    }
}
