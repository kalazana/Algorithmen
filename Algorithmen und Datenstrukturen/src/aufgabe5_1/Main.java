package aufgabe5_1;

import java.util.Arrays;


public class Main {
    public static void main(String[] args) {

        /*
          @param hashedFirstName - first names at (index = result hash function)
         */
        String[] hashedFirstName = new String[32];
        Arrays.fill(hashedFirstName, "");

        String[] firstName = {"Alexander", "David", "Felix", "Maximilian", "Leon", "Lukas", "Luca", "Paul", "Jonas", "Tim", "Anna", "Emily", "Julia", "Maria", "Laura", "Lea", "Lena", "Leonie", "Marie", "Sophie"};
        /*
          @param collison - numbers of collisions for the same index in hashedFirstName
         */
        int[] collison = new int[32];
        /*
          @param collisonCounter - counts collisions
         */
        int collisonCounter;

        boolean inserted = false;

        for (String name : firstName) {
            collisonCounter = 1;
            int key = Hashing.hashfunction(name);
            inserted = false;
            // if no collision
            if (hashedFirstName[key].equals("")) {
                hashedFirstName[key] = name;
                collison[key] = 0;
            // if collision
            } else {
                do {
                    if (hashedFirstName[key + collisonCounter].equals("")) {
                        hashedFirstName[key + collisonCounter] = name;
                        collison[key + collisonCounter] = collisonCounter;
                        inserted = true;
                    } else {
                        collisonCounter++;
                    }
                } while (!inserted);
            }
        }

        // console output
        for (int i = 0; i < hashedFirstName.length; i++) {
            if (hashedFirstName[i].equals("")) {
                System.out.println("[Empty]: " + collison[i]);
            } else {
                System.out.println(hashedFirstName[i] + ": " + collison[i]);
            }
        }

        // Sum of collisions
        collisonCounter = 0;
        for (int i : collison) {
            collisonCounter += i;
        }
        System.out.println("\ncollisions: " + collisonCounter);
    }
}
