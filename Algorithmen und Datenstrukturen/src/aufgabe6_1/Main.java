package aufgabe6_1;

import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {
        DataHandler data = new DataHandler();
        ArrayList<Hospital> hospitals;

        // Read data from hard drive
        hospitals = data.read_data();

        // Write data to hard drive
        data.write_data(hospitals, "data/K95.txt");

        // select an entry and write it to the console
        data.output();

//        data.toSting();
    }
}
