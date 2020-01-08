package aufgabe2_1;

import java.util.Scanner;


public class Main {
	    public static void main(String... args) {
	    	System.out.println("Machen Sie eine Eingabe:");
	        Scanner scanner = new Scanner(System.in);
	        Spooler spooler = new Spooler();

	        do {
	            byte Byte = scanner.nextByte();
	            spooler.addByte(Byte);
	        } while (true);
	    }
	}