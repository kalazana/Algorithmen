package aufgabe7;

import java.util.ArrayList;

public class Main {
    public static void main(String... args) {
        DataHandler data = new DataHandler();
        ArrayList<Hospital> hospitals;

        // Read data from hard drive
        hospitals = data.read_data();

        // Write data to hard drive
        data.write_data(hospitals, "data/K95.txt");

        // select an entry and write it to the console
//        data.output();

//        System.out.print("Enter a postcode between 1000 & 99999: ");
//        Scanner scanner = new Scanner(System.in);
//        int postcode = Integer.parseInt(scanner.nextLine());

        for(int postcode: data.getRandomEntries(hospitals)) {
            // Search an entry via postcode
        data.search(hospitals, postcode);
        }
        System.out.println("\nSequential search (included): ");
        data.getAverageEffort();
        
        
        for(int postcode: data.getNotIncludedPostcodes(hospitals)) {
            // Search an entry via postcode
        data.search(hospitals, postcode);
        }
        System.out.println("\nSequential search (not included): ");
        data.getAverageEffort();

        // sort the list by term with selection search algorithm
        hospitals = data.selectionSort(hospitals, "Postleitzahl");

//        data.insertionSort(hospitals, "Postleitzahl");


        for(int postcode: data.getRandomEntries(hospitals)) {
            // search list for postcode with binary search
            data.binarySearch(hospitals, postcode);
        }
        System.out.println("\nBinary search (included): ");
        data.getAverageEffort();
        
        for(int postcode: data.getNotIncludedPostcodes(hospitals)) {
            // search list for postcode with binary search
            data.binarySearch(hospitals, postcode);
        }
        System.out.println("\nBinary search (not included): ");
        data.getAverageEffort();

        
        for(int postcode: data.getRandomEntries(hospitals)) {
            // search list for postcode with interpolation search
            data.interpolSearch(hospitals, postcode);
        }
        System.out.println("\nInterpolation search (included): ");
        data.getAverageEffort();

        
        for(int postcode: data.getNotIncludedPostcodes(hospitals)) {
            // search list for postcode with interpolation search
            data.interpolSearch(hospitals, postcode);
        }
        System.out.println("\nInterpolation search (not included): ");
        data.getAverageEffort();
    }
}
