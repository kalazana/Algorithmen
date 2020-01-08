package aufgabe2_2;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	    /**
	     * @param counterRecursions - Number of recursions
	     */
	    private static int counterRecursions = -1;
	    /**
	     * @param callStack - Call stack for method ggT
	     */
	    private static ArrayList<String> callStack = new ArrayList<>();

	    public static void main(String... args) {
	        Scanner in = new Scanner(System.in);

	        System.out.print("Zahl a: ");
	        long a = in.nextLong();
	        in.reset();

	        System.out.print("Zahl b: ");
	        long b = in.nextLong();
	        in.reset();

	        System.out.println("Der Größte gemeinsame Teiler ist: " + ggT(a, b));
	        System.out.println("\n");
	        System.out.println("Anzahl Rekursionen: " + counterRecursions);
	        System.out.println("\n");
	        System.out.println("Call Stack:");
	        for (String stackElement : callStack) {
	            System.out.println(stackElement);
	        }
	    }

	    static long ggT(final long a, final long b) {
	        counterRecursions++;
	        callStack.add(0, "ggt(" + b + ", " + a + ")");
	        if (b == 0) {
	            return a;
	        } else if (a == b) {
	            return (a);
	        } else {
	            return (ggT(b, a % b));
	        }
	    }
	}

