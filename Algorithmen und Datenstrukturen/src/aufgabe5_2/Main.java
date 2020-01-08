package aufgabe5_2;

import java.util.Arrays;


public class Main {
    public static void main(String argv[]) {

//      Binary search tree (by default order):


          System.out.println("Standard Aufgabenfolge");

          BinarySearchTree binarySearchTreeDefaultOrder = new BinarySearchTree();

          binarySearchTreeDefaultOrder
                  .insert("Alexander")
                  .insert("David")
                  .insert("Felix")
                  .insert("Maximilian")
                  .insert("Leon")
                  .insert("Lukas")
                  .insert("Luca")
                  .insert("Paul")
                  .insert("Jonas")
                  .insert("Tim")
                  .insert("Anna")
                  .insert("Emily")
                  .insert("Julia")
                  .insert("Maria")
                  .insert("Laura")
                  .insert("Lea")
                  .insert("Lena")
                  .insert("Leonie")
                  .insert("Marie")
                  .insert("Sophie");

          binarySearchTreeDefaultOrder.inOrder();

          System.out.print("\nHöhe des Baums: ");
          binarySearchTreeDefaultOrder.maxDepth();

          System.out.println("\n\nReinfolge nach Hash");


//      Binary search tree (by index order):

           /*
            hashedFirstName - first names at (index = result hash function)
           */
          String[] hashedFirstName = new String[32];
          Arrays.fill(hashedFirstName, " ");

          String[] firstName = {"Alexander", "David", "Felix", "Maximilian", "Leon", "Lukas", "Luca", "Paul", "Jonas", "Tim", "Anna", "Emily", "Julia", "Maria", "Laura", "Lea", "Lena", "Leonie", "Marie", "Sophie"};
          /*
            collison - numbers of collisions for the same index in hashedFirstName
           */
          int[] collison = new int[32];
          /*
            collisonCounter - counts collisions
           */
          int collisonCounter = 1;

          for (String name : firstName) {
              int key = Hashing.hashfunction(name);
              // if no collion
              if (hashedFirstName[key].equals(" ")) {
                  hashedFirstName[key] = name;
                  collison[key] = 0;
                  // if collision
              } else {
                  do {
                      if (hashedFirstName[(key + collisonCounter) % 20].equals(" ")) {
                          hashedFirstName[(key + collisonCounter) % 20] = name;
                          collison[key + collisonCounter] = collisonCounter;
                      } else {
                          collisonCounter++;
                      }
                  } while (collison[key + collisonCounter] == 0);
              }
          }

          BinarySearchTree binarySearchTreeIndexOrder = new BinarySearchTree();

          for (String aHashedFirstName : hashedFirstName) {
              if (!aHashedFirstName.equals(" ")) {
                  binarySearchTreeIndexOrder.insert(aHashedFirstName);
              }
          }

          binarySearchTreeIndexOrder.inOrder();

          System.out.print("\nHöhe des Baums: ");
          binarySearchTreeIndexOrder.maxDepth();
      }
  }

