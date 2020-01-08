package aufgabe1_1;

import java.io.IOException;


public class Main {

	public static void main(String[] args) throws IOException {
		
		//Liste liste = new Liste("test");
		
		Liste liste = new Liste();
		liste.append("Daniel", "Hoffmann", "10.03.1984", 123456);
		liste.append("Janin", "Hoffmann", "30.05.1985", 123457);
		liste.append("Willi", "Müller", "12.08.1989", 123458);
		liste.append("Herbert", "Monty", "22.01.1966", 123459);
		liste.append("Kathleen", "Klöckner", "07.07.1983", 123460);
		liste.append("Ferdinand", "Hullson", "02.11.1975", 123461);
		liste.append("Valeria", "Voss", "05.06.1982", 123462);
		System.out.println(liste.countEle() + " Element(e)");
		liste.writeList("A01_1_test");
		liste.print();
		liste.delete(123456);
		liste.print();
		liste.delete(123462);
		liste.print();
		liste.delete(123458);
		liste.print();
		/*liste.delete(123457);
		liste.delete(123458);
		liste.delete(123460);
		liste.delete(123461);*/
		liste.print();
		liste = new Liste("A01_1_test");
		System.out.println(liste.countEle() + " Element(e)");
		liste.print();

		
		
		
		
		
		
		
		System.out.println(liste.find(123458));
		
		
		//liste.delete(123459);
		
		
		
		liste.print();
		liste.writeList("Miau");
		liste.loadListe("Miau");
		System.out.println(liste.countEle() + " Element(e)");
		
	}

}
