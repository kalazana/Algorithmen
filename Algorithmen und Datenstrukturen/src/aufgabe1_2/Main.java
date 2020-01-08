/**
 * 
 */
package aufgabe1_2;

import java.io.IOException;


public class Main {
    public static void main(final String... args) {
        try {
        	Liste liste = new Liste(50);
    		liste.insert("Daniel", "Hoffmann", "10.03.1984", 123456);
    		liste.insert("Janin", "Hoffmann", "30.05.1985", 123457);
    		liste.insert("Willi", "Müller", "12.08.1989", 123458);
    		liste.insert("Herbert", "Monty", "22.01.1966", 123459);
    		liste.insert("Kathleen", "Klöckner", "07.07.1983", 123460);
    		liste.insert("Ferdinand", "Hullson", "02.11.1975", 123461);
    		liste.insert("Valeria", "Voss", "05.06.1982", 123462);

            // save and load file/list
            liste.save("task1_2");

            System.out.println();
            System.out.print("List size: ");
            System.out.println(liste.size());
            System.out.println();

            // delete element
            liste.delete(123456);
            liste.delete(123462);
            liste.delete(123459);

            liste.insert("Daniel", "Hoffmann", "10.03.1984", 123456);
            liste.insert("Valeria", "Voss", "05.06.1982", 123462);

            System.out.println();
            System.out.print("List size: ");
            System.out.println(liste.size());
            System.out.println();

            liste.printList();
            System.out.println();

            liste.save("hallo");
            try {
                liste.load("hallo");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
